package com.jen20.client;

import java.util.concurrent.CompletableFuture;

public interface ReadableEventStoreConnection {
    CompletableFuture<StreamEventsSlice> readEventsForward(String streamName, int start, int count, LinkAction resolveLinks);
    CompletableFuture<StreamEventsSlice> readEventsForward(String streamName, int start, int count, LinkAction resolveLinks, Credentials credentials);

    CompletableFuture<StreamEventsSlice> readEventsBackward(String streamName, int start, int count, LinkAction resolveLinks);
    CompletableFuture<StreamEventsSlice> readEventsBackward(String streamName, int start, int count, LinkAction resolveLinks, Credentials credentials);

    CompletableFuture<SingleReadResult> readEvent(String streamName, int eventNumber, LinkAction resolveLinks);
    CompletableFuture<SingleReadResult> readEvent(String streamName, int eventNumber, LinkAction resolveLinks, Credentials credentials);
}
