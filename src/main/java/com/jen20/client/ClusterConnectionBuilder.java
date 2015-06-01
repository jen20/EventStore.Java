package com.jen20.client;

import java.time.Duration;

public class ClusterConnectionBuilder {
    private String connectionName;
    private boolean verboseLogging;
    private int maximumQueueDepth;
    private int maximumConcurrentOperations;
    private int maximumRetries;
    private int maximumReconnectionAttempts;
    private boolean performOperationsOnlyOnMaster;
    private Duration reconnectionDelay;
    private Duration operationTimeout;
    private Duration operationTimeoutFrequency;
    private Credentials defaultCredentials;
    private boolean failOnNoServerResponse;
    private Duration heartbeatInterval;
    private Duration heartbeatTimeout;
    private boolean discoverViaDNS;
    private String clusterDNSName;
    private int maximumDiscoveryAttempts;
    private int externalGossipPort;
    private GossipSeed[] gossipSeeds;
    private Duration gossipTimeout;
    private Duration connectionTimeout;

    ClusterConnectionBuilder() {
        connectionName = "";
        verboseLogging = false;
        maximumQueueDepth = 5000;
        maximumConcurrentOperations = 5000;
        maximumRetries = 10;
        maximumReconnectionAttempts = 10;
        performOperationsOnlyOnMaster = true;
        reconnectionDelay = Duration.ofMillis(100);
        operationTimeout = Duration.ofSeconds(7);
        operationTimeoutFrequency = Duration.ofSeconds(1);
        defaultCredentials = null;
        failOnNoServerResponse = false;
        heartbeatInterval = Duration.ofMillis(750);
        heartbeatTimeout = Duration.ofMillis(1500);
        discoverViaDNS = false;
        clusterDNSName = "";
        maximumDiscoveryAttempts = 10;
        externalGossipPort = 30778;
        gossipSeeds = new GossipSeed[0];
        gossipTimeout = Duration.ofSeconds(1);
        connectionTimeout = Duration.ofSeconds(1);
    }

    public ClusterConnectionBuilder withConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }

    public ClusterConnectionBuilder withVerboseLogging() {
        this.verboseLogging = true;
        return this;
    }

    public ClusterConnectionBuilder withMaximumQueueDepth(int maximumQueueDepth) {
        this.maximumQueueDepth = maximumQueueDepth;
        return this;
    }

    public ClusterConnectionBuilder withMaximumConcurrentOperations(int maximumConcurrentOperations) {
        this.maximumConcurrentOperations = maximumConcurrentOperations;
        return this;
    }

    public ClusterConnectionBuilder withMaximumRetries(int maximumRetries) {
        this.maximumRetries = maximumRetries;
        return this;
    }

    public ClusterConnectionBuilder withMaximumReconnectionAttempts(int maximumReconnectionAttempts) {
        this.maximumReconnectionAttempts = maximumReconnectionAttempts;
        return this;
    }

    public ClusterConnectionBuilder withUnlimitedReconnectionAttempts() {
        this.maximumReconnectionAttempts = -1;
        return this;
    }

    public ClusterConnectionBuilder allowSlaveNodesToServiceOperations() {
        this.performOperationsOnlyOnMaster = false;
        return this;
    }

    public ClusterConnectionBuilder withReconnectionDelay(Duration reconnectionDelay) {
        this.reconnectionDelay = reconnectionDelay;
        return this;
    }

    public ClusterConnectionBuilder withOperationTimeout(Duration operationTimeout) {
        this.operationTimeout = operationTimeout;
        return this;
    }

    public ClusterConnectionBuilder withOperationTimeoutFrequency(Duration operationTimeoutFrequency) {
        this.operationTimeoutFrequency = operationTimeoutFrequency;
        return this;
    }

    public ClusterConnectionBuilder withDefaultCredentials(Credentials defaultCredentials) {
        this.defaultCredentials = defaultCredentials;
        return this;
    }

    public ClusterConnectionBuilder doNotFailOnNoServerResponse() {
        this.failOnNoServerResponse = false;
        return this;
    }

    public ClusterConnectionBuilder withHeartbeatInterval(Duration heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
        return this;
    }

    public ClusterConnectionBuilder withHeartbeatTimeout(Duration heartbeatTimeout) {
        this.heartbeatTimeout = heartbeatTimeout;
        return this;
    }

    public ClusterConnectionBuilder discoverClusterViaDNS(String clusterDNSName, int externalGossipPort, int maximumDiscoveryAttempts) {
        this.discoverViaDNS = true;
        this.clusterDNSName = clusterDNSName;
        this.externalGossipPort = externalGossipPort;
        this.maximumDiscoveryAttempts = maximumDiscoveryAttempts;
        return this;
    }

    public ClusterConnectionBuilder discoverClusterViaDNS(String clusterDNSName, int externalGossipPort) {
        this.discoverViaDNS = true;
        this.clusterDNSName = clusterDNSName;
        this.externalGossipPort = externalGossipPort;
        return this;
    }

    public ClusterConnectionBuilder discoverClusterViaNominatedSeeds(int maximumDiscoveryAttempts, GossipSeed... seedNodes) {
        this.discoverViaDNS = false;
        this.maximumDiscoveryAttempts = maximumDiscoveryAttempts;
        this.gossipSeeds = seedNodes;
        return this;
    }

    public ClusterConnectionBuilder discoverClusterViaNominatedSeeds(GossipSeed... seedNodes) {
        this.discoverViaDNS = false;
        this.gossipSeeds = seedNodes;
        return this;
    }

    public ClusterConnectionBuilder withGossipTimeout(Duration gossipTimeout) {
        this.gossipTimeout = gossipTimeout;
        return this;
    }

    public ClusterConnectionBuilder withConnectionTimeout(Duration connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public EventStoreConnection build() {
//        return new ConnectionSettings(connectionName, verboseLogging, maximumQueueDepth, maximumConcurrentOperations, maximumRetries, maximumReconnectionAttempts, performOperationsOnlyOnMaster, reconnectionDelay, operationTimeout, operationTimeoutFrequency, defaultCredentials, failOnNoServerResponse, heartbeatInterval, heartbeatTimeout, discoverViaDNS, clusterDNSName, maximumDiscoveryAttempts, externalGossipPort, gossipSeeds, gossipTimeout, connectionTimeout);
        //TODO(jen20): Make this work
        return null;
    }
}
