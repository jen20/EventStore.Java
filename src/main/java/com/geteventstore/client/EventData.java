package com.geteventstore.client;

import java.util.UUID;

public class EventData {
    private final UUID eventId;
    private final String type;
    private final Boolean isJson;
    private final byte[] data;
    private final byte[] metadata;

    public EventData(byte[] data, Boolean isJson, String type, UUID eventId) {
        this.data = data;
        this.isJson = isJson;
        this.type = type;
        this.eventId = eventId;
        this.metadata = new byte[0];
    }

    public EventData(UUID eventId, String type, Boolean isJson, byte[] data, byte[] metadata) {
        this.eventId = eventId;
        this.type = type;
        this.isJson = isJson;
        this.data = data;
        this.metadata = metadata;
    }

    public UUID getEventId() {
        return eventId;
    }

    public String getType() {
        return type;
    }

    public Boolean isJson() {
        return isJson;
    }

    public byte[] getData() {
        return data;
    }

    public byte[] getMetadata() {
        return metadata;
    }
}
