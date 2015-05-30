package com.jen20.client;

import java.util.Optional;

public abstract class Subscription {
    private String streamName;

    private long lastCommitPosition;
    private Optional<Integer> lastEventNumber;

    public Subscription(String streamName, long lastCommitPosition, Optional<Integer> lastEventNumber) {
        this.streamName = streamName;
        this.lastCommitPosition = lastCommitPosition;
        this.lastEventNumber = lastEventNumber;
    }

    public abstract void Unsubscribe();

    public void Close() {
        Unsubscribe();
    }

    public Boolean isSubscribedToAll() {
        return streamName.equals("");
    }

    public String getStreamName() {
        return streamName;
    }

    public long getLastCommitPosition() {
        return lastCommitPosition;
    }

    public Optional<Integer> getLastEventNumber() {
        return lastEventNumber;
    }
}

