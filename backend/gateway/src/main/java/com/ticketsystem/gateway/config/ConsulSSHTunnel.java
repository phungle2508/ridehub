package com.ticketsystem.gateway.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsulSSHTunnel {

    private static final Logger log = LoggerFactory.getLogger(ConsulSSHTunnel.class);
    private Session session;

    @Value("${tunnel.vps-host}")
    private String vpsHost;

    @Value("${tunnel.vps-user}")
    private String vpsUser;

    @Value("${tunnel.vps-password}")
    private String vpsPassword;

    @Value("${server.port:8080}")
    private int localPort;

    @PostConstruct
    public void init() {
        // Run tunnel creation in separate thread to avoid blocking Spring startup
        new Thread(this::createTunnel).start();
    }

    private void createTunnel() {
        try {
            Thread.sleep(2000); // Wait for app to start

            JSch jsch = new JSch();
            session = jsch.getSession(vpsUser, vpsHost, 22);
            session.setPassword(vpsPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(10000);

            session.setPortForwardingR(localPort + 1000, "localhost", localPort);
            log.info("SSH tunnel created: {}:{} -> localhost:{}", vpsHost, localPort + 1000, localPort);
            portCustomizer();
        } catch (Exception e) {
            log.error("SSH tunnel failed: {}", e.getMessage());
        }
    }

    @PreDestroy
    public void destroy() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            log.info("SSH tunnel closed");
        }
    }

    ConsulRegistrationCustomizer portCustomizer() {
        return registration -> {
            registration.getService().setPort(localPort + 1000);
        };
    }
}