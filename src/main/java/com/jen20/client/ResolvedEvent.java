package com.jen20.client;

public class ResolvedEvent {
    private final RecordedEvent event;
    private final RecordedEvent link;

    public ResolvedEvent(RecordedEvent event, RecordedEvent link) {
        this.event = event;
        this.link = link;
    }

    public ResolvedEvent(RecordedEvent event) {
        this.event = event;
        this.link = null;
    }

    public RecordedEvent getLink() {
        return link;
    }

    public RecordedEvent getEvent() {
        return event;
    }
}
