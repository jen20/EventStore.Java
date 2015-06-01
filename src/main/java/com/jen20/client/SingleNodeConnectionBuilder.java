package com.jen20.client;

import java.net.InetSocketAddress;
import java.time.Duration;

public class SingleNodeConnectionBuilder {
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
    private Duration connectionTimeout;
    private InetSocketAddress connectionAddress;

    SingleNodeConnectionBuilder() {
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
        connectionTimeout = Duration.ofSeconds(1);
        connectionAddress = null;
    }

    public SingleNodeConnectionBuilder withConnectionAddress(InetSocketAddress address) {
        this.connectionAddress = address;
        return this;
    }

    public SingleNodeConnectionBuilder withConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }

    public SingleNodeConnectionBuilder withVerboseLogging() {
        this.verboseLogging = true;
        return this;
    }

    public SingleNodeConnectionBuilder withMaximumQueueDepth(int maximumQueueDepth) {
        this.maximumQueueDepth = maximumQueueDepth;
        return this;
    }

    public SingleNodeConnectionBuilder withMaximumConcurrentOperations(int maximumConcurrentOperations) {
        this.maximumConcurrentOperations = maximumConcurrentOperations;
        return this;
    }

    public SingleNodeConnectionBuilder withMaximumRetries(int maximumRetries) {
        this.maximumRetries = maximumRetries;
        return this;
    }

    public SingleNodeConnectionBuilder withMaximumReconnectionAttempts(int maximumReconnectionAttempts) {
        this.maximumReconnectionAttempts = maximumReconnectionAttempts;
        return this;
    }

    public SingleNodeConnectionBuilder withUnlimitedReconnectionAttempts() {
        this.maximumReconnectionAttempts = -1;
        return this;
    }

    public SingleNodeConnectionBuilder allowSlaveNodesToServiceOperations() {
        this.performOperationsOnlyOnMaster = false;
        return this;
    }

    public SingleNodeConnectionBuilder withReconnectionDelay(Duration reconnectionDelay) {
        this.reconnectionDelay = reconnectionDelay;
        return this;
    }

    public SingleNodeConnectionBuilder withOperationTimeout(Duration operationTimeout) {
        this.operationTimeout = operationTimeout;
        return this;
    }

    public SingleNodeConnectionBuilder withOperationTimeoutFrequency(Duration operationTimeoutFrequency) {
        this.operationTimeoutFrequency = operationTimeoutFrequency;
        return this;
    }

    public SingleNodeConnectionBuilder withDefaultCredentials(Credentials defaultCredentials) {
        this.defaultCredentials = defaultCredentials;
        return this;
    }

    public SingleNodeConnectionBuilder doNotFailOnNoServerResponse() {
        this.failOnNoServerResponse = false;
        return this;
    }

    public SingleNodeConnectionBuilder withHeartbeatInterval(Duration heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
        return this;
    }

    public SingleNodeConnectionBuilder withHeartbeatTimeout(Duration heartbeatTimeout) {
        this.heartbeatTimeout = heartbeatTimeout;
        return this;
    }

    public SingleNodeConnectionBuilder withConnectionTimeout(Duration connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public EventStoreConnection build() {
//        return new ConnectionSettings(connectionName, verboseLogging, maximumQueueDepth, maximumConcurrentOperations, maximumRetries, maximumReconnectionAttempts, performOperationsOnlyOnMaster, reconnectionDelay, operationTimeout, operationTimeoutFrequency, defaultCredentials, failOnNoServerResponse, heartbeatInterval, heartbeatTimeout, false, "", 0, 0, null, Duration.ZERO, connectionTimeout);
        //TODO(jen20): Make this work
        return null;
    }
}

