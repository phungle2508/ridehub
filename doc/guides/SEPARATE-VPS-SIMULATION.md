# Separate VPS Simulation

This setup simulates two VPS hosts on one Docker host:

- `vps-infra` owns Consul, Vault, Keycloak, Kafka, Redis, and Elasticsearch.
- `vps-microservices` owns the gateway and business services.
- The two stacks do not share a Docker network. They communicate through host-published ports.

## Start

Create the microservice images first, then start the infrastructure and microservice stacks:

```bash
cd infra/vps-infra
docker compose up -d

cd ../vps-microservices
docker compose up -d
```

For two real VPS hosts, the microservice stack uses these domain-based values:

```dotenv
CONSUL_HOST=consul.${DOMAIN}
CONSUL_PORT=443
CONSUL_SCHEME=https
CONSUL_DISCOVERY_PREFER_IP_ADDRESS=true
CONSUL_DISCOVERY_SCHEME=https
GATEWAY_DISCOVERY_ADDRESS=apigateway.${DOMAIN}
MS_BOOKING_DISCOVERY_ADDRESS=msbooking.${DOMAIN}
MS_PROMOTION_DISCOVERY_ADDRESS=mspromotion.${DOMAIN}
MS_ROUTE_DISCOVERY_ADDRESS=msroute.${DOMAIN}
MS_USER_DISCOVERY_ADDRESS=msuser.${DOMAIN}
```

For the same-host Docker simulation, override Consul with `host.docker.internal:8500/http` and use `host.docker.internal` as every discovery address.

When Consul and service domains are behind Cloudflare Access, the machine-to-machine requests must be allowed with a service token or Access bypass. A normal browser login is not sufficient for Spring Cloud Consul or Consul health checks. A private DNS/VPN route is preferable for production service-to-service traffic.

## Verify

```bash
curl -H "X-Consul-Token: f4security" http://localhost:8500/v1/agent/checks
```

Every registered service check should use `host.docker.internal` and its published service port, rather than a Docker container hostname.