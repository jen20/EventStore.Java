package com.jen20.client;

public class Position {
    private final long commitPosition;
    private final long preparePosition;

    public Position(long commitPosition, long preparePosition) {
        this.commitPosition = commitPosition;
        this.preparePosition = preparePosition;
    }

    public long getCommitPosition() {
        return commitPosition;
    }

    public long getPreparePosition() {
        return preparePosition;
    }
}
