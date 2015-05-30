package com.jen20.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by James on 30/05/15.
 */
public interface SubscribableEventStoreConnection {
    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop);
    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          Credentials credentials,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop);

    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop,
                                                          Executor executor);
    CompletableFuture<Subscription> subscribeToStreamLive(String streamName,
                                                          LinkAction linkAction,
                                                          Credentials credentials,
                                                          BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                          BiConsumer<Subscription, DropReason> onDrop,
                                                          Executor executor);

    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                       BiConsumer<Subscription, DropReason> onDrop);
    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       Credentials credentials,
                                                       BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                       BiConsumer<Subscription, DropReason> onDrop);

    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                       BiConsumer<Subscription, DropReason> onDrop,
                                                       Executor executor);
    CompletableFuture<Subscription> subscribeToAllLive(LinkAction linkAction,
                                                       Credentials credentials,
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
                                                                     Credentials credentials,
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
    CompletableFuture<Subscription> subscribeToStreamFromEventNumber(String stream,
                                                                     int eventNumber,
                                                                     LinkAction linkAction,
                                                                     Credentials credentials,
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
                                                               Credentials credentials,
                                                               BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                               BiConsumer<Subscription, DropReason> onDrop,
                                                               Consumer<Subscription> onLiveProcessingStart);

    CompletableFuture<Subscription> subscribeToAllFromPosition(Position position,
                                                               LinkAction linkAction,
                                                               BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                               BiConsumer<Subscription, DropReason> onDrop,
                                                               Consumer<Subscription> onLiveProcessingStart,
                                                               Executor executor);
    CompletableFuture<Subscription> subscribeToAllFromPosition(Position position,
                                                               LinkAction linkAction,
                                                               Credentials credentials,
                                                               BiConsumer<Subscription, ResolvedEvent> onEvent,
                                                               BiConsumer<Subscription, DropReason> onDrop,
                                                               Consumer<Subscription> onLiveProcessingStart,
                                                               Executor executor);
}
