package com.jen20.client;

import java.time.Duration;
import java.util.Arrays;

class ConnectionSettings {
    private final String connectionName;
    private final boolean verboseLogging;
    private final int maximumQueueDepth;
    private final int maximumConcurrentOperations;
    private final int maximumRetries;
    private final int maximumReconnectionAttempts;
    private final boolean performOperationsOnlyOnMaster;
    private final Duration reconnectionDelay;
    private final Duration operationTimeout;
    private final Duration operationTimeoutFrequency;
    private final Credentials defaultCredentials;

    private final boolean failOnNoServerResponse;
    private final Duration heartbeatInterval;
    private final Duration heartbeatTimeout;

    private final boolean discoverViaDNS;

    private final String clusterDNSName;
    private final int maximumDiscoveryAttempts;
    private final int externalGossipPort;

    private final GossipSeed[] gossipSeeds;
    private final Duration gossipTimeout;
    private final Duration connectionTimeout;

    ConnectionSettings(String connectionName, boolean verboseLogging, int maximumQueueDepth, int maximumConcurrentOperations, int maximumRetries, int maximumReconnectionAttempts, boolean performOperationsOnlyOnMaster, Duration reconnectionDelay, Duration operationTimeout, Duration operationTimeoutFrequency, Credentials defaultCredentials, boolean failOnNoServerResponse, Duration heartbeatInterval, Duration heartbeatTimeout, boolean discoverViaDNS, String clusterDNSName, int maximumDiscoveryAttempts, int externalGossipPort, GossipSeed[] gossipSeeds, Duration gossipTimeout, Duration connectionTimeout) {
        if (maximumQueueDepth <= 0) {
            throw new IllegalArgumentException(String.format("maximumQueueDepth must be positive (supplied: %d)", maximumQueueDepth));
        }
        if (maximumConcurrentOperations <= 0) {
            throw new IllegalArgumentException(String.format("maximumConcurrentOperations must be positive (supplied: %d)", maximumConcurrentOperations));
        }
        if (maximumRetries < -1) {
            throw new IllegalArgumentException(String.format("maximumRetries must be -1 (unbounded), or >= 0 (bounded) (supplied: %d)", maximumRetries));
        }
        if (maximumReconnectionAttempts < -1) {
            throw new IllegalArgumentException(String.format("maximumReconnectionAttempts must be -1 (unbounded), or >= 0 (bounded) (supplied: %d)", maximumReconnectionAttempts));
        }

        this.connectionName = connectionName;
        this.verboseLogging = verboseLogging;
        this.maximumQueueDepth = maximumQueueDepth;
        this.maximumConcurrentOperations = maximumConcurrentOperations;
        this.maximumRetries = maximumRetries;
        this.maximumReconnectionAttempts = maximumReconnectionAttempts;
        this.performOperationsOnlyOnMaster = performOperationsOnlyOnMaster;
        this.reconnectionDelay = reconnectionDelay;
        this.operationTimeout = operationTimeout;
        this.operationTimeoutFrequency = operationTimeoutFrequency;
        this.defaultCredentials = defaultCredentials;
        this.failOnNoServerResponse = failOnNoServerResponse;
        this.heartbeatInterval = heartbeatInterval;
        this.heartbeatTimeout = heartbeatTimeout;
        this.discoverViaDNS = discoverViaDNS;
        this.clusterDNSName = clusterDNSName;
        this.maximumDiscoveryAttempts = maximumDiscoveryAttempts;
        this.externalGossipPort = externalGossipPort;
        this.gossipSeeds = gossipSeeds;
        this.gossipTimeout = gossipTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public String toString() {
        return "ConnectionSettings{" +
                "verboseLogging=" + verboseLogging +
                ", maximumQueueDepth=" + maximumQueueDepth +
                ", maximumConcurrentOperations=" + maximumConcurrentOperations +
                ", maximumRetries=" + maximumRetries +
                ", maximumReconnectionAttempts=" + maximumReconnectionAttempts +
                ", performOperationsOnlyOnMaster=" + performOperationsOnlyOnMaster +
                ", reconnectionDelay=" + reconnectionDelay +
                ", operationTimeout=" + operationTimeout +
                ", operationTimeoutFrequency=" + operationTimeoutFrequency +
                ", defaultCredentials=" + defaultCredentials +
                ", failOnNoServerResponse=" + failOnNoServerResponse +
                ", heartbeatInterval=" + heartbeatInterval +
                ", heartbeatTimeout=" + heartbeatTimeout +
                ", clusterDNSName='" + clusterDNSName + '\'' +
                ", maximumDiscoveryAttempts=" + maximumDiscoveryAttempts +
                ", externalGossipPort=" + externalGossipPort +
                ", gossipSeeds=" + Arrays.toString(gossipSeeds) +
                ", gossipTimeout=" + gossipTimeout +
                ", connectionTimeout=" + connectionTimeout +
                '}';
    }

    public boolean isVerboseLogging() {
        return verboseLogging;
    }

    public int getMaximumQueueDepth() {
        return maximumQueueDepth;
    }

    public int getMaximumConcurrentOperations() {
        return maximumConcurrentOperations;
    }

    public int getMaximumRetries() {
        return maximumRetries;
    }

    public int getMaximumReconnectionAttempts() {
        return maximumReconnectionAttempts;
    }

    public boolean isPerformOperationsOnlyOnMaster() {
        return performOperationsOnlyOnMaster;
    }

    public Duration getReconnectionDelay() {
        return reconnectionDelay;
    }

    public Duration getOperationTimeout() {
        return operationTimeout;
    }

    public Duration getOperationTimeoutFrequency() {
        return operationTimeoutFrequency;
    }

    public Credentials getDefaultCredentials() {
        return defaultCredentials;
    }

    public boolean isFailOnNoServerResponse() {
        return failOnNoServerResponse;
    }

    public Duration getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public Duration getHeartbeatTimeout() {
        return heartbeatTimeout;
    }

    public String getClusterDNSName() {
        return clusterDNSName;
    }

    public int getMaximumDiscoveryAttempts() {
        return maximumDiscoveryAttempts;
    }

    public int getExternalGossipPort() {
        return externalGossipPort;
    }

    public GossipSeed[] getGossipSeeds() {
        return gossipSeeds;
    }

    public Duration getGossipTimeout() {
        return gossipTimeout;
    }

    public Duration getConnectionTimeout() {
        return connectionTimeout;
    }

    public boolean isDiscoverViaDNS() {
        return discoverViaDNS;
    }

    public String getConnectionName() {
        return connectionName;
    }
}
