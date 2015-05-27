package com.geteventstore.client;

public class StreamEventsSlice {
    private final SliceReadStatus status;
    private final String streamName;
    private final int fromEventNumber;
    private final int nextEventNumber;
    private final int lastEventNumber;
    private final Boolean isEndOfStream;
    private final ReadDirection readDirection;

    public StreamEventsSlice(SliceReadStatus status, String streamName, int fromEventNumber, int nextEventNumber, int lastEventNumber, Boolean isEndOfStream, ReadDirection readDirection) {
        this.status = status;
        this.streamName = streamName;
        this.fromEventNumber = fromEventNumber;
        this.nextEventNumber = nextEventNumber;
        this.lastEventNumber = lastEventNumber;
        this.isEndOfStream = isEndOfStream;
        this.readDirection = readDirection;
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

    public Boolean isEndOfStream() {
        return isEndOfStream;
    }

    public ReadDirection getReadDirection() {
        return readDirection;
    }

    public SliceReadStatus getStatus() {

        return status;
    }
}
