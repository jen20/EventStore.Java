package com.jen20.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface WritableEventStoreConnection {
    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, EventData... events);
    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, List<EventData> events);

    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, Credentials credentials, EventData... events);
    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, Credentials credentials, List<EventData> events);

    CompletableFuture<DeleteResult> deleteStream(String streamName, int expectedVersion);
    CompletableFuture<DeleteResult> deleteStream(String streamName, int expectedVersion, Credentials credentials);
}
