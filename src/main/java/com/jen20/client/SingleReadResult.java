package com.jen20.client;

import java.util.Optional;

public class SingleReadResult {
    private final EventReadStatus status;
    private final String stream;
    private final int eventNumber;
    private final Optional<ResolvedEvent> event;

    public SingleReadResult(EventReadStatus status, String stream, int eventNumber, Optional<ResolvedEvent> event) {
        this.status = status;
        this.stream = stream;
        this.eventNumber = eventNumber;
        this.event = event;
    }

    public String getStream() {
        return stream;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public Optional<ResolvedEvent> getEvent() {
        return event;
    }

    public EventReadStatus getStatus() {
        return status;
    }
}
