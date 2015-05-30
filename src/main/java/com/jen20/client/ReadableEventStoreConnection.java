package com.jen20.client;

import java.util.concurrent.CompletableFuture;

/**
 * Created by James on 30/05/15.
 */
public interface ReadableEventStoreConnection {
    CompletableFuture<StreamEventsSlice> readEventsForward(String streamName, int start, int count, LinkAction resolveLinks);

    CompletableFuture<StreamEventsSlice> readEventsBackward(String streamName, int start, int count, LinkAction resolveLinks);

    CompletableFuture<SingleReadResult> readEvent(String streamName, int eventNumber, LinkAction resolveLinks);
}
