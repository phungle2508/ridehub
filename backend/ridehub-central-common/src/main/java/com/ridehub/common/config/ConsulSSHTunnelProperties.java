package com.ridehub.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for Consul SSH Tunnel functionality.
 * These properties are used to configure SSH tunneling for development environments
 * to enable service discovery with Consul.
 */
@ConfigurationProperties(prefix = "tunnel")
public class ConsulSSHTunnelProperties {

    /**
     * VPS host for SSH tunneling
     */
    private String vpsHost;

    /**
     * VPS username for SSH authentication
     */
    private String vpsUser;

    /**
     * VPS password for SSH authentication
     */
    private String vpsPassword;

    /**
     * Service ID to register with Consul.
     * Defaults to application name if not specified.
     */
    private String serviceId;

    /**
     * Service name to register with Consul.
     * Defaults to application name if not specified.
     */
    private String serviceName;

    /**
     * Local port of the application.
     * Gets value from server.port property with default of 8080.
     */
    @Value("${server.port:8080}")
    private int localPort;

    /**
     * Port offset for the tunnel.
     * The tunnel will be created on localPort + portOffset.
     * Defaults to 1000.
     */
    private int portOffset = 1000;

    /**
     * Profile suffix for development environment.
     * Defaults to "DEV".
     */
    private String devSuffix = "dev";

    // Getters and Setters
    public String getVpsHost() {
        return vpsHost;
    }

    public void setVpsHost(String vpsHost) {
        this.vpsHost = vpsHost;
    }

    public String getVpsUser() {
        return vpsUser;
    }

    public void setVpsUser(String vpsUser) {
        this.vpsUser = vpsUser;
    }

    public String getVpsPassword() {
        return vpsPassword;
    }

    public void setVpsPassword(String vpsPassword) {
        this.vpsPassword = vpsPassword;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public int getPortOffset() {
        return portOffset;
    }

    public void setPortOffset(int portOffset) {
        this.portOffset = portOffset;
    }

    public String getDevSuffix() {
        return devSuffix;
    }

    public void setDevSuffix(String devSuffix) {
        this.devSuffix = devSuffix;
    }

    /**
     * Get the tunnel port (localPort + portOffset)
     */
    public int getTunnelPort() {
        return localPort + portOffset;
    }

    /**
     * Get the service ID with development suffix
     */
    public String getServiceIdWithSuffix() {
        return (serviceId != null ? serviceId : "") + devSuffix.toLowerCase();
    }

    /**
     * Get the service name with development suffix
     */
    public String getServiceNameWithSuffix() {
        return (serviceName != null ? serviceName : "") + devSuffix;
    }
}