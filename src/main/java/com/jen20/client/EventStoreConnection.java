package com.jen20.client;

import java.util.concurrent.CompletableFuture;

public interface EventStoreConnection extends AutoCloseable, WritableEventStoreConnection, ReadableEventStoreConnection, SubscribableEventStoreConnection {
    CompletableFuture connect();

    static ClusterConnectionBuilder newClusterConnectionBuilder() {
        return new ClusterConnectionBuilder();
    }

    static SingleNodeConnectionBuilder newSingleNodeBuilder() {
        return new SingleNodeConnectionBuilder();
    }
}