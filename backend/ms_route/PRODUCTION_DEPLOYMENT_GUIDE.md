# Production Deployment Guide for ms_route Microservice

This guide provides step-by-step instructions for deploying the ms_route microservice in a production environment.

## Prerequisites

Before deploying to production, ensure you have:

1. **Java 17+** installed on the target server
2. **Maven 3.2.5+** for building the application
3. **Docker & Docker Compose** for containerized deployment
4. **Production-grade MySQL** database server
5. **Redis** server for caching
6. **Elasticsearch** cluster for search functionality
7. **Apache Kafka** cluster for message streaming
8. **Consul** for service discovery
9. **Keycloak** or another OAuth2/OIDC provider for authentication

## Option 1: Docker Compose Deployment (Recommended for Small to Medium Production)

### Step 1: Prepare Production Environment Variables

Create a `.env` file in the project root with production values:

```bash
# Database Configuration
SPRING_DATASOURCE_URL=jdbc:mysql://your-mysql-host:3306/ms_route?useUnicode=true&characterEncoding=utf8&useSSL=true&useLegacyDatetimeCode=false&createDatabaseIfNotExist=true
SPRING_DATASOURCE_USERNAME=your_prod_db_user
SPRING_DATASOURCE_PASSWORD=your_secure_db_password
SPRING_LIQUIBASE_URL=${SPRING_DATASOURCE_URL}

# Redis Configuration
JHIPSTER_CACHE_REDIS_SERVER=redis://your-redis-host:6379
JHIPSTER_CACHE_REDIS_CLUSTER=false

# Elasticsearch Configuration
SPRING_ELASTICSEARCH_URIS=http://your-elasticsearch-host:9200

# Kafka Configuration
SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS=your-kafka-host1:9092,your-kafka-host2:9092

# Consul Configuration
SPRING_CLOUD_CONSUL_HOST=your-consul-host
SPRING_CLOUD_CONSUL_PORT=8500

# OAuth2 Configuration (Keycloak)
SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_OIDC_ISSUER_URI=https://your-keycloak-host/realms/jhipster
SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_ID=your_client_id
SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_SECRET=your_client_secret

# Application Configuration
JAVA_OPTS=-Xmx2g -Xms1g -XX:+UseG1GC -XX:+UseContainerSupport
SPRING_PROFILES_ACTIVE=prod,api-docs
MANAGEMENT_PROMETHEUS_METRICS_EXPORT_ENABLED=true
```

### Step 2: Build the Application

```bash
# Build the JAR file
./mvnw -Pprod clean verify -DskipTests

# Build the Docker image
./mvnw -Pprod jib:dockerBuild
```

### Step 3: Create Production Docker Compose File

Create a `docker-compose.prod.yml` file:

```yaml
version: '3.8'
name: ms_route_prod
services:
  app:
    image: ms_route:latest
    restart: unless-stopped
    environment:
      - _JAVA_OPTIONS=${JAVA_OPTS}
      - SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
      - MANAGEMENT_PROMETHEUS_METRICS_EXPORT_ENABLED=${MANAGEMENT_PROMETHEUS_METRICS_EXPORT_ENABLED}
      - SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
      - SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
      - SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
      - SPRING_LIQUIBASE_URL=${SPRING_LIQUIBASE_URL}
      - JHIPSTER_CACHE_REDIS_SERVER=${JHIPSTER_CACHE_REDIS_SERVER}
      - JHIPSTER_CACHE_REDIS_CLUSTER=${JHIPSTER_CACHE_REDIS_CLUSTER}
      - SPRING_ELASTICSEARCH_URIS=${SPRING_ELASTICSEARCH_URIS}
      - SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS=${SPRING_CLOUD_STREAM_KAFKA_BINDER_BROKERS}
      - SPRING_CLOUD_CONSUL_HOST=${SPRING_CLOUD_CONSUL_HOST}
      - SPRING_CLOUD_CONSUL_PORT=${SPRING_CLOUD_CONSUL_PORT}
      - SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_OIDC_ISSUER_URI=${SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_OIDC_ISSUER_URI}
      - SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_ID=${SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_ID}
      - SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_SECRET=${SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_SECRET}
    ports:
      - "8082:8082"
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8082/management/health"]
      interval: 30s
      timeout: 10s
      retries: 3
    depends_on:
      - redis
    networks:
      - ms_route_network

  redis:
    image: redis:8.0.0-alpine
    restart: unless-stopped
    command: redis-server --appendonly yes --requirepass ${REDIS_PASSWORD}
    volumes:
      - redis_data:/data
    networks:
      - ms_route_network

volumes:
  redis_data:

networks:
  ms_route_network:
    driver: bridge
```

### Step 4: Deploy with Docker Compose

```bash
# Deploy the application
docker-compose -f docker-compose.prod.yml --env-file .env up -d

# Check the logs
docker-compose -f docker-compose.prod.yml logs -f app

# Check health status
curl http://localhost:8082/management/health
```

## Option 2: Traditional JAR Deployment

### Step 1: Build the Application

```bash
./mvnw -Pprod clean verify -DskipTests
```

### Step 2: Configure Production Settings

Edit `src/main/resources/config/application-prod.yml` with your production values:

```yaml
spring:
  datasource:
    url: jdbc:mysql://your-mysql-host:3306/ms_route?useUnicode=true&characterEncoding=utf8&useSSL=true&useLegacyDatetimeCode=false&createDatabaseIfNotExist=true
    username: your_prod_db_user
    password: your_secure_db_password
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  
  cloud:
    consul:
      host: your-consul-host
      port: 8500
      discovery:
        prefer-ip-address: true
        health-check-path: /management/health
        health-check-interval: 15s
        health-check-timeout: 5s
        health-check-critical-timeout: 30s
  
  elasticsearch:
    uris: http://your-elasticsearch-host:9200
    connection-timeout: 5s
    socket-timeout: 30s
  
  cloud:
    stream:
      kafka:
        binder:
          brokers: your-kafka-host1:9092,your-kafka-host2:9092
          auto-create-topics: false
          replication-factor: 3

jhipster:
  cache:
    redis:
      server: redis://your-redis-host:6379
      password: ${REDIS_PASSWORD}
      timeout: 2000ms
```

### Step 3: Deploy the JAR

```bash
# Copy the JAR to the server
cp target/ms-route-0.0.1-SNAPSHOT.jar /opt/ms_route/

# Create a systemd service file
sudo tee /etc/systemd/system/ms_route.service > /dev/null <<EOF
[Unit]
Description=MS Route Service
After=network.target

[Service]
Type=simple
User=ms_route
WorkingDirectory=/opt/ms_route
ExecStart=/usr/bin/java -jar -Xmx2g -Xms1g -Dspring.profiles.active=prod ms-route-0.0.1-SNAPSHOT.jar
Restart=always
RestartSec=10
StandardOutput=journal
StandardError=journal
SyslogIdentifier=ms_route

[Install]
WantedBy=multi-user.target
EOF

# Enable and start the service
sudo systemctl daemon-reload
sudo systemctl enable ms_route
sudo systemctl start ms_route

# Check status
sudo systemctl status ms_route
```

## Production Security Considerations

### 1. Database Security

- Use SSL connections to MySQL
- Create a dedicated database user with limited privileges
- Enable MySQL audit logging
- Regularly update database passwords

### 2. Redis Security

- Enable Redis authentication with a strong password
- Use Redis ACLs if available
- Disable dangerous commands
- Enable TLS for Redis connections

### 3. Network Security

- Use firewalls to restrict access to ports
- Implement VPN or private networks for service-to-service communication
- Use TLS/SSL for all external communications

### 4. Application Security

- Enable HTTPS with valid certificates
- Configure proper CORS settings
- Implement rate limiting
- Regularly update dependencies

## Monitoring and Logging

### 1. Application Monitoring

The application exposes several endpoints for monitoring:

- `/management/health` - Health checks
- `/management/metrics` - Prometheus metrics
- `/management/info` - Application information
- `/management/prometheus` - Prometheus scrape endpoint

### 2. Log Management

Configure logback for production in `src/main/resources/logback-spring.xml`:

```xml
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>/var/log/ms_route/ms_route.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>/var/log/ms_route/ms_route.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>100MB</maxFileSize>
            <maxHistory>30</maxHistory>
            <totalSizeCap>3GB</totalSizeCap>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="FILE" />
    </root>
</configuration>
```

### 3. Prometheus Monitoring

Configure Prometheus to scrape metrics:

```yaml
scrape_configs:
  - job_name: 'ms_route'
    static_configs:
      - targets: ['localhost:8082']
    metrics_path: '/management/prometheus'
    scrape_interval: 15s
```

## Backup and Recovery

### 1. Database Backup

Create a backup script:

```bash
#!/bin/bash
BACKUP_DIR="/backup/mysql"
DATE=$(date +%Y%m%d_%H%M%S)
DB_NAME="ms_route"

mkdir -p $BACKUP_DIR
mysqldump -h your-mysql-host -u backup_user -p$BACKUP_PASSWORD $DB_NAME | gzip > $BACKUP_DIR/ms_route_$DATE.sql.gz

# Keep only last 7 days of backups
find $BACKUP_DIR -name "*.sql.gz" -mtime +7 -delete
```

### 2. Application Backup

Backup the application and configuration:

```bash
#!/bin/bash
BACKUP_DIR="/backup/app"
DATE=$(date +%Y%m%d_%H%M%S)

mkdir -p $BACKUP_DIR
tar -czf $BACKUP_DIR/ms_route_$DATE.tar.gz /opt/ms_route/
```

## Scaling Considerations

### 1. Horizontal Scaling

- Deploy multiple instances behind a load balancer
- Use sticky sessions if needed
- Configure session replication if using HTTP sessions

### 2. Database Scaling

- Implement read replicas for read-heavy workloads
- Consider database sharding for very large datasets
- Use connection pooling effectively

### 3. Caching Strategy

- Implement Redis clustering for high availability
- Use appropriate cache eviction policies
- Consider multi-level caching

## Troubleshooting

### Common Issues and Solutions

1. **Out of Memory Errors**
   - Increase heap size with `-Xmx` flag
   - Check for memory leaks with profiling tools
   - Optimize database queries

2. **Database Connection Issues**
   - Check connection pool settings
   - Verify network connectivity
   - Check database server status

3. **High CPU Usage**
   - Profile the application to identify bottlenecks
   - Optimize inefficient code
   - Consider scaling horizontally

4. **Slow Response Times**
   - Check database query performance
   - Optimize Elasticsearch queries
   - Review caching strategy

## Performance Tuning

### JVM Tuning

```bash
JAVA_OPTS="-Xmx2g -Xms1g \
           -XX:+UseG1GC \
           -XX:MaxGCPauseMillis=200 \
           -XX:+UseStringDeduplication \
           -XX:+OptimizeStringConcat \
           -Djava.security.egd=file:/dev/./urandom"
```

### Database Connection Pool

```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
      leak-detection-threshold: 60000
```

## Maintenance

### Regular Tasks

1. **Weekly**
   - Check application logs for errors
   - Monitor system resources
   - Review security alerts

2. **Monthly**
   - Update dependencies
   - Review and rotate secrets
   - Performance tuning

3. **Quarterly**
   - Security audit
   - Disaster recovery testing
   - Capacity planning

This guide provides a comprehensive approach to deploying the ms_route microservice in production. Adjust the configurations based on your specific infrastructure requirements.

## Appendix: Production Deployment Script

Below is a sample deployment script that you can save as `deploy-production.sh`:

```bash
#!/bin/bash

# Production Deployment Script for ms_route
# This script automates the deployment process

set -e

# Configuration
APP_NAME="ms_route"
JAR_FILE="target/ms-route-0.0.1-SNAPSHOT.jar"
DEPLOY_DIR="/opt/ms_route"
SERVICE_NAME="ms_route"
BACKUP_DIR="/backup/ms_route"
LOG_FILE="/var/log/ms_route/deploy.log"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Check if running as root
if [ "$EUID" -ne 0 ]; then
    print_error "This script must be run as root"
    exit 1
fi

# Create log directory
mkdir -p "$(dirname "$LOG_FILE")"

# Log function
log() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') - $1" | tee -a "$LOG_FILE"
}

# Check prerequisites
check_prerequisites() {
    log "Checking prerequisites..."
    
    # Check Java
    if ! command -v java &> /dev/null; then
        print_error "Java is not installed"
        exit 1
    fi
    
    # Check Maven
    if ! command -v mvn &> /dev/null; then
        print_error "Maven is not installed"
        exit 1
    fi
    
    # Check if JAR file exists
    if [ ! -f "$JAR_FILE" ]; then
        print_error "JAR file not found at $JAR_FILE"
        print_status "Building the application..."
        ./mvnw -Pprod clean verify -DskipTests
    fi
    
    print_status "Prerequisites check completed"
}

# Create deployment directory
create_deployment_dir() {
    log "Creating deployment directory..."
    
    # Create user if not exists
    if ! id "$APP_NAME" &>/dev/null; then
        useradd -r -s /bin/false "$APP_NAME"
        print_status "Created user: $APP_NAME"
    fi
    
    # Create directories
    mkdir -p "$DEPLOY_DIR"
    mkdir -p "$BACKUP_DIR"
    mkdir -p "/var/log/ms_route"
    
    # Set ownership
    chown -R "$APP_NAME:$APP_NAME" "$DEPLOY_DIR"
    chown -R "$APP_NAME:$APP_NAME" "/var/log/ms_route"
    
    print_status "Deployment directory created"
}

# Backup current deployment
backup_current() {
    log "Backing up current deployment..."
    
    if [ -f "$DEPLOY_DIR/ms-route.jar" ]; then
        BACKUP_FILE="$BACKUP_DIR/ms-route-$(date +%Y%m%d_%H%M%S).jar"
        cp "$DEPLOY_DIR/ms-route.jar" "$BACKUP_FILE"
        print_status "Current deployment backed up to $BACKUP_FILE"
    else
        print_warning "No current deployment found"
    fi
}

# Deploy application
deploy_application() {
    log "Deploying application..."
    
    # Copy new JAR
    cp "$JAR_FILE" "$DEPLOY_DIR/ms-route.jar"
    chown "$APP_NAME:$APP_NAME" "$DEPLOY_DIR/ms-route.jar"
    chmod +x "$DEPLOY_DIR/ms-route.jar"
    
    print_status "Application deployed"
}

# Create systemd service
create_service() {
    log "Creating systemd service..."
    
    cat > "/etc/systemd/system/$SERVICE_NAME.service" << EOF
[Unit]
Description=MS Route Service
After=network.target

[Service]
Type=simple
User=$APP_NAME
WorkingDirectory=$DEPLOY_DIR
ExecStart=/usr/bin/java -jar -Xmx2g -Xms1g -Dspring.profiles.active=prod ms-route.jar
Restart=always
RestartSec=10
StandardOutput=journal
StandardError=journal
SyslogIdentifier=ms_route
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
EOF

    systemctl daemon-reload
    print_status "Systemd service created"
}

# Start service
start_service() {
    log "Starting service..."
    
    systemctl enable "$SERVICE_NAME"
    systemctl restart "$SERVICE_NAME"
    
    # Wait for service to start
    sleep 10
    
    # Check service status
    if systemctl is-active --quiet "$SERVICE_NAME"; then
        print_status "Service started successfully"
    else
        print_error "Service failed to start"
        systemctl status "$SERVICE_NAME"
        exit 1
    fi
}

# Health check
health_check() {
    log "Performing health check..."
    
    # Wait for application to fully start
    sleep 30
    
    # Check health endpoint
    if curl -f http://localhost:8082/management/health > /dev/null 2>&1; then
        print_status "Health check passed"
    else
        print_error "Health check failed"
        exit 1
    fi
}

# Main deployment process
main() {
    log "Starting deployment process..."
    
    check_prerequisites
    create_deployment_dir
    backup_current
    deploy_application
    create_service
    start_service
    health_check
    
    log "Deployment completed successfully"
    print_status "Application is now running at http://localhost:8082"
}

# Handle script interruption
trap 'print_error "Deployment interrupted"; exit 1' INT

# Run main function
main "$@"
```

Make the script executable:
```bash
chmod +x deploy-production.sh
```

Run the script:
```bash
sudo ./deploy-production.sh
```

## Quick Production Deployment Checklist

Before deploying to production, ensure you have:

- [ ] Configured production database credentials
- [ ] Set up Redis with authentication
- [ ] Configured Elasticsearch cluster
- [ ] Set up Kafka cluster
- [ ] Configured Consul for service discovery
- [ ] Set up Keycloak for authentication
- [ ] Generated SSL/TLS certificates
- [ ] Configured firewall rules
- [ ] Set up monitoring and alerting
- [ ] Created backup strategies
- [ ] Tested disaster recovery procedures
- [ ] Reviewed security configurations
- [ ] Performance tested the application