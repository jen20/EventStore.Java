package com.jen20.client;

import java.time.LocalDateTime;
import java.util.UUID;

public class RecordedEvent {
    private final String eventStreamId;
    private final UUID eventId;
    private final int eventNumber;
    private final String eventType;
    private final byte[] data;
    private final byte[] metadata;
    private final Boolean isJson;
    private final LocalDateTime timeStamp;
    private final long timeStampSinceEpoch;

    public RecordedEvent(String eventStreamId, UUID eventId, int eventNumber, String eventType, byte[] data, byte[] metadata, Boolean isJson, LocalDateTime timeStamp, long timeStampSinceEpoch) {
        this.eventStreamId = eventStreamId;
        this.eventId = eventId;
        this.eventNumber = eventNumber;
        this.eventType = eventType;
        this.data = data;
        this.metadata = metadata;
        this.isJson = isJson;
        this.timeStamp = timeStamp;
        this.timeStampSinceEpoch = timeStampSinceEpoch;
    }

    public String getEventStreamId() {
        return eventStreamId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public byte[] getData() {
        return data;
    }

    public byte[] getMetadata() {
        return metadata;
    }

    public Boolean isJson() {
        return isJson;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public long getTimeStampSinceEpoch() {
        return timeStampSinceEpoch;
    }
}
