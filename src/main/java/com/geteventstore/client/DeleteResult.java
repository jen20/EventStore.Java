package com.geteventstore.client;

public class DeleteResult {
    private final Position position;

    public Position getPosition() {
        return position;
    }

    public DeleteResult(Position position) {
        this.position = position;
    }
}
