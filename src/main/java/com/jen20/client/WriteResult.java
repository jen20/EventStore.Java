package com.jen20.client;

public class WriteResult {
    public final int nextExpectedVersion;
    public final Position logPosition;

    public WriteResult(int nextExpectedVersion, Position logPosition) {
        this.nextExpectedVersion = nextExpectedVersion;
        this.logPosition = logPosition;
    }

    public Position getLogPosition() {
        return logPosition;
    }

    public int getNextExpectedVersion() {
        return nextExpectedVersion;
    }
}
