package com.jen20.client;

import java.time.Duration;
import java.util.Collection;

public class ConnectionSettingsBuilder {
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
    private String clusterDNSName;
    private int maximumDiscoveryAttempts;
    private int externalGossipPort;
    private GossipSeed[] gossipSeeds;
    private Duration gossipTimeout;
    private Duration connectionTimeout;

    ConnectionSettingsBuilder() {
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
        clusterDNSName = "";
        maximumDiscoveryAttempts = 10;
        externalGossipPort = 30778;
        gossipSeeds = new GossipSeed[0];
        gossipTimeout = Duration.ofSeconds(1);
        connectionTimeout = Duration.ofSeconds(1);
    }

    public ConnectionSettingsBuilder withVerboseLogging() {
        this.verboseLogging = true;
        return this;
    }

    public ConnectionSettingsBuilder withMaximumQueueDepth(int maximumQueueDepth) {
        this.maximumQueueDepth = maximumQueueDepth;
        return this;
    }

    public ConnectionSettingsBuilder withMaximumConcurrentOperations(int maximumConcurrentOperations) {
        this.maximumConcurrentOperations = maximumConcurrentOperations;
        return this;
    }

    public ConnectionSettingsBuilder withMaximumRetries(int maximumRetries) {
        this.maximumRetries = maximumRetries;
        return this;
    }

    public ConnectionSettingsBuilder withMaximumReconnectionAttempts(int maximumReconnectionAttempts) {
        this.maximumReconnectionAttempts = maximumReconnectionAttempts;
        return this;
    }

    public ConnectionSettingsBuilder allowSlaveNodesToServiceOperations() {
        this.performOperationsOnlyOnMaster = false;
        return this;
    }

    public ConnectionSettingsBuilder withReconnectionDelay(Duration reconnectionDelay) {
        this.reconnectionDelay = reconnectionDelay;
        return this;
    }

    public ConnectionSettingsBuilder withOperationTimeout(Duration operationTimeout) {
        this.operationTimeout = operationTimeout;
        return this;
    }

    public ConnectionSettingsBuilder withOperationTimeoutFrequency(Duration operationTimeoutFrequency) {
        this.operationTimeoutFrequency = operationTimeoutFrequency;
        return this;
    }

    public ConnectionSettingsBuilder withDefaultCredentials(Credentials defaultCredentials) {
        this.defaultCredentials = defaultCredentials;
        return this;
    }

    public ConnectionSettingsBuilder doNotFailOnNoServerResponse() {
        this.failOnNoServerResponse = false;
        return this;
    }

    public ConnectionSettingsBuilder withHeartbeatInterval(Duration heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
        return this;
    }

    public ConnectionSettingsBuilder withHeartbeatTimeout(Duration heartbeatTimeout) {
        this.heartbeatTimeout = heartbeatTimeout;
        return this;
    }

    public ConnectionSettingsBuilder withClusterDNSName(String clusterDNSName) {
        this.clusterDNSName = clusterDNSName;
        return this;
    }

    public ConnectionSettingsBuilder withMaximumDiscoveryAttempts(int maximumDiscoveryAttempts) {
        this.maximumDiscoveryAttempts = maximumDiscoveryAttempts;
        return this;
    }

    public ConnectionSettingsBuilder withExternalGossipPort(int externalGossipPort) {
        this.externalGossipPort = externalGossipPort;
        return this;
    }

    public ConnectionSettingsBuilder withGossipSeeds(GossipSeed... gossipSeeds) {
        this.gossipSeeds = gossipSeeds;
        return this;
    }

    public ConnectionSettingsBuilder withGossipSeeds(Collection<GossipSeed> gossipSeeds) {
        this.gossipSeeds = gossipSeeds.toArray(new GossipSeed[gossipSeeds.size()]);
        return this;
    }

    public ConnectionSettingsBuilder withGossipTimeout(Duration gossipTimeout) {
        this.gossipTimeout = gossipTimeout;
        return this;
    }

    public ConnectionSettingsBuilder withConnectionTimeout(Duration connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public ConnectionSettings build() {
        return new ConnectionSettings(verboseLogging, maximumQueueDepth, maximumConcurrentOperations, maximumRetries, maximumReconnectionAttempts, performOperationsOnlyOnMaster, reconnectionDelay, operationTimeout, operationTimeoutFrequency, defaultCredentials, failOnNoServerResponse, heartbeatInterval, heartbeatTimeout, clusterDNSName, maximumDiscoveryAttempts, externalGossipPort, gossipSeeds, gossipTimeout, connectionTimeout);
    }
}
