# JHipster generated Docker-Compose configuration

## Usage

Launch all your infrastructure by running: `docker compose up -d`.

## Configured Docker services

### Service registry and configuration server:

- [Consul](http://localhost:8500)

### Applications and dependencies:

- gateway (gateway application)
- gateway's no database
- ms_user (microservice application)
- ms_user's mysql database
- ms_route (microservice application)
- ms_route's mysql database
- ms_route's elasticsearch search engine
- ms_ticket (microservice application)
- ms_ticket's mysql database
- ms_booking (microservice application)
- ms_booking's mysql database
- ms_payment (microservice application)
- ms_payment's mysql database
- ms_notification (microservice application)
- ms_notification's mysql database

### Additional Services:

- [Prometheus server](http://localhost:9090)
- [Prometheus Alertmanager](http://localhost:9093)
- [Grafana](http://localhost:3000)
- [Keycloak server](http://localhost:9080)
