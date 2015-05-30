package com.jen20.client;

import java.util.List;

public class StreamEventsSlice {
    private final SliceReadStatus status;
    private final String streamName;
    private final int fromEventNumber;
    private final int nextEventNumber;
    private final int lastEventNumber;
    private final boolean isEndOfStream;
    private final ReadDirection readDirection;
    private final List<ResolvedEvent> events;

    public StreamEventsSlice(SliceReadStatus status, String streamName, int fromEventNumber, int nextEventNumber, int lastEventNumber, boolean isEndOfStream, ReadDirection readDirection, List<ResolvedEvent> events) {
        this.status = status;
        this.streamName = streamName;
        this.fromEventNumber = fromEventNumber;
        this.nextEventNumber = nextEventNumber;
        this.lastEventNumber = lastEventNumber;
        this.isEndOfStream = isEndOfStream;
        this.readDirection = readDirection;
        this.events = events;
    }

    public String getStreamName() {
        return streamName;
    }

    public int getFromEventNumber() {
        return fromEventNumber;
    }

    public int getNextEventNumber() {
        return nextEventNumber;
    }

    public int getLastEventNumber() {
        return lastEventNumber;
    }

    public boolean isEndOfStream() {
        return isEndOfStream;
    }

    public ReadDirection getReadDirection() {
        return readDirection;
    }

    public SliceReadStatus getStatus() {
        return status;
    }

    public List<ResolvedEvent> getEvents() {
        return events;
    }
}
