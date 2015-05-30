package com.jen20.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface EventStoreConnection {
    CompletableFuture connect();
    void close();

    CompletableFuture<WriteResult> appendToStream(String streamName, int expectedVersion, EventData[] events);

    CompletableFuture<DeleteResult> deleteStream(String streamName, int expectedVersion);

    CompletableFuture<StreamEventsSlice> readEventsForward(String streamName, int start, int count, LinkAction resolveLinks);
    CompletableFuture<StreamEventsSlice> readEventsBackward(String streamName, int start, int count, LinkAction resolveLinks);

    CompletableFuture<SingleReadResult> readEvent(String streamName, int eventNumber, LinkAction resolveLinks);

    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop);

    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop,
                                                          Executor executor);

    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                       BiConsumer<Subscription, DropReason> onDrop);

    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                       BiConsumer<Subscription, DropReason> onDrop,
                                                       Executor executor);

    CompletableFuture<Subscription> subscribeToStreamFromEventNumber(String stream,
                                                                     int eventNumber,
                                                                     LinkAction linkAction,
                                                                     BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                                     BiConsumer<Subscription, DropReason> onDrop,
                                                                     Consumer<Subscription> onLiveProcessingStart);

    CompletableFuture<Subscription> subscribeToStreamFromEventNumber(String stream,
                                                                     int eventNumber,
                                                                     LinkAction linkAction,
                                                                     BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                                     BiConsumer<Subscription, DropReason> onDrop,
                                                                     Consumer<Subscription> onLiveProcessingStart,
                                                                     Executor executor);

    CompletableFuture<Subscription> subscribeToAllFromPosition(Position position,
                                                               LinkAction linkAction,
                                                               BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                               BiConsumer<Subscription, DropReason> onDrop,
                                                               Consumer<Subscription> onLiveProcessingStart);

    CompletableFuture<Subscription> subscribeToAllFromPosition(Position position,
                                                               LinkAction linkAction,
                                                               BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                               BiConsumer<Subscription, DropReason> onDrop,
                                                               Consumer<Subscription> onLiveProcessingStart,
                                                               Executor executor);
}