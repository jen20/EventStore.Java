package com.jen20.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by James on 30/05/15.
 */
public interface WritableEventStoreConnection {
    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, EventData... events);

    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, List<EventData> events);

    CompletableFuture<DeleteResult> deleteStream(String streamName, int expectedVersion);
}
