package com.ridehub.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration properties for the Kafka library
 */
@ConfigurationProperties(prefix = "kafka.utility")
public class KafkaLibraryProperties {

    private boolean enabled = true;
    private String serviceName = "default-service";
    private String environment = "dev";
    private ThreadPool threadPool = new ThreadPool();
    private Retry retry = new Retry();
    private Dlq dlq = new Dlq();
    private Sse sse = new Sse();
    private Topics topics = new Topics();
    private Job job = new Job();

    // Getters and setters
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public Retry getRetry() {
        return retry;
    }

    public void setRetry(Retry retry) {
        this.retry = retry;
    }

    public Dlq getDlq() {
        return dlq;
    }

    public void setDlq(Dlq dlq) {
        this.dlq = dlq;
    }

    public Sse getSse() {
        return sse;
    }

    public void setSse(Sse sse) {
        this.sse = sse;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    // Inner classes
    public static class ThreadPool {
        private int coreSize = 4;
        private int maxSize = 12;
        private int queueCapacity = 50;
        private int keepAliveSeconds = 60;
        private String threadNamePrefix = "kafka-util-";
        private String rejectionPolicy = "CALLER_RUNS";

        // Getters and setters
        public int getCoreSize() {
            return coreSize;
        }

        public void setCoreSize(int coreSize) {
            this.coreSize = coreSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }

        public int getKeepAliveSeconds() {
            return keepAliveSeconds;
        }

        public void setKeepAliveSeconds(int keepAliveSeconds) {
            this.keepAliveSeconds = keepAliveSeconds;
        }

        public String getThreadNamePrefix() {
            return threadNamePrefix;
        }

        public void setThreadNamePrefix(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        public String getRejectionPolicy() {
            return rejectionPolicy;
        }

        public void setRejectionPolicy(String rejectionPolicy) {
            this.rejectionPolicy = rejectionPolicy;
        }
    }

    public static class Retry {
        private boolean enabled = true;
        private int maxAttempts = 3;
        private long backoffPeriod = 1000;
        private double backoffMultiplier = 2.0;
        private long maxBackoffPeriod = 10000;
        private List<String> retryExceptions = Arrays.asList(
            "org.apache.kafka.common.errors.RetriableException",
            "org.springframework.kafka.support.KafkaException",
            "java.net.SocketTimeoutException",
            "javax.net.ssl.SSLException"
        );

        // Getters and setters
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getMaxAttempts() {
            return maxAttempts;
        }

        public void setMaxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
        }

        public long getBackoffPeriod() {
            return backoffPeriod;
        }

        public void setBackoffPeriod(long backoffPeriod) {
            this.backoffPeriod = backoffPeriod;
        }

        public double getBackoffMultiplier() {
            return backoffMultiplier;
        }

        public void setBackoffMultiplier(double backoffMultiplier) {
            this.backoffMultiplier = backoffMultiplier;
        }

        public long getMaxBackoffPeriod() {
            return maxBackoffPeriod;
        }

        public void setMaxBackoffPeriod(long maxBackoffPeriod) {
            this.maxBackoffPeriod = maxBackoffPeriod;
        }

        public List<String> getRetryExceptions() {
            return retryExceptions;
        }

        public void setRetryExceptions(List<String> retryExceptions) {
            this.retryExceptions = retryExceptions;
        }
    }

    public static class Dlq {
        private boolean enabled = true;
        private String topicSuffix = ".dlq";
        private int maxRetriesBeforeDlq = 3;
        private boolean includeHeaders = true;
        private boolean includeStackTrace = false;

        // Getters and setters
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getTopicSuffix() {
            return topicSuffix;
        }

        public void setTopicSuffix(String topicSuffix) {
            this.topicSuffix = topicSuffix;
        }

        public int getMaxRetriesBeforeDlq() {
            return maxRetriesBeforeDlq;
        }

        public void setMaxRetriesBeforeDlq(int maxRetriesBeforeDlq) {
            this.maxRetriesBeforeDlq = maxRetriesBeforeDlq;
        }

        public boolean isIncludeHeaders() {
            return includeHeaders;
        }

        public void setIncludeHeaders(boolean includeHeaders) {
            this.includeHeaders = includeHeaders;
        }

        public boolean isIncludeStackTrace() {
            return includeStackTrace;
        }

        public void setIncludeStackTrace(boolean includeStackTrace) {
            this.includeStackTrace = includeStackTrace;
        }
    }

    public static class Sse {
        private boolean enabled = true;
        private long timeout = 300000;
        private long heartbeatInterval = 30000;
        private int maxConnections = 100;
        private int bufferSize = 2048;
        private List<String> broadcastEvents = Arrays.asList(
            "TICKET_CREATED", "TICKET_UPDATED", "URGENT_NOTIFICATION"
        );

        // Getters and setters
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public long getTimeout() {
            return timeout;
        }

        public void setTimeout(long timeout) {
            this.timeout = timeout;
        }

        public long getHeartbeatInterval() {
            return heartbeatInterval;
        }

        public void setHeartbeatInterval(long heartbeatInterval) {
            this.heartbeatInterval = heartbeatInterval;
        }

        public int getMaxConnections() {
            return maxConnections;
        }

        public void setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
        }

        public int getBufferSize() {
            return bufferSize;
        }

        public void setBufferSize(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        public List<String> getBroadcastEvents() {
            return broadcastEvents;
        }

        public void setBroadcastEvents(List<String> broadcastEvents) {
            this.broadcastEvents = broadcastEvents;
        }
    }

    public static class Topics {
        private boolean autoCreate = true;
        private int defaultPartitions = 3;
        private int defaultReplicationFactor = 1;
        private Map<String, TopicConfig> configurations = new HashMap<>();

        // Getters and setters
        public boolean isAutoCreate() {
            return autoCreate;
        }

        public void setAutoCreate(boolean autoCreate) {
            this.autoCreate = autoCreate;
        }

        public int getDefaultPartitions() {
            return defaultPartitions;
        }

        public void setDefaultPartitions(int defaultPartitions) {
            this.defaultPartitions = defaultPartitions;
        }

        public int getDefaultReplicationFactor() {
            return defaultReplicationFactor;
        }

        public void setDefaultReplicationFactor(int defaultReplicationFactor) {
            this.defaultReplicationFactor = defaultReplicationFactor;
        }

        public Map<String, TopicConfig> getConfigurations() {
            return configurations;
        }

        public void setConfigurations(Map<String, TopicConfig> configurations) {
            this.configurations = configurations;
        }

        public static class TopicConfig {
            private int partitions = 3;
            private int replicationFactor = 1;
            private long retentionMs = 259200000; // 3 days
            private String cleanupPolicy = "delete";
            private long segmentMs = 86400000; // 1 day

            // Getters and setters
            public int getPartitions() {
                return partitions;
            }

            public void setPartitions(int partitions) {
                this.partitions = partitions;
            }

            public int getReplicationFactor() {
                return replicationFactor;
            }

            public void setReplicationFactor(int replicationFactor) {
                this.replicationFactor = replicationFactor;
            }

            public long getRetentionMs() {
                return retentionMs;
            }

            public void setRetentionMs(long retentionMs) {
                this.retentionMs = retentionMs;
            }

            public String getCleanupPolicy() {
                return cleanupPolicy;
            }

            public void setCleanupPolicy(String cleanupPolicy) {
                this.cleanupPolicy = cleanupPolicy;
            }

            public long getSegmentMs() {
                return segmentMs;
            }

            public void setSegmentMs(long segmentMs) {
                this.segmentMs = segmentMs;
            }
        }
    }

    public static class Job {
        private int threadPoolSize = 10;
        private String threadNamePrefix = "kafka-job-";
        private String completionTopic = "job-completion";

        public int getThreadPoolSize() {
            return threadPoolSize;
        }

        public void setThreadPoolSize(int threadPoolSize) {
            this.threadPoolSize = threadPoolSize;
        }

        public String getThreadNamePrefix() {
            return threadNamePrefix;
        }

        public void setThreadNamePrefix(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        public String getCompletionTopic() {
            return completionTopic;
        }

        public void setCompletionTopic(String completionTopic) {
            this.completionTopic = completionTopic;
        }
    }
}
