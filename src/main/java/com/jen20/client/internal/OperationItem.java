package com.jen20.client.internal;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

class OperationItem {
    private static AtomicLong nextSequenceNumber;
    static {
        nextSequenceNumber = new AtomicLong(-1);
    }

    final long sequenceNumber = nextSequenceNumber.getAndIncrement();
    final ClientOperation operation;
    final int maxRetries;
    final Duration timeout;
    final LocalDateTime creationTime;

    UUID connectionId;
    UUID correlationId;
    int retryCount;
    LocalDateTime lastUpdated;

    public OperationItem(ClientOperation operation, int maxRetries, Duration timeout) {
        this.operation = operation;
        this.maxRetries = maxRetries;
        this.timeout = timeout;
        this.creationTime = LocalDateTime.now();

        correlationId = UUID.randomUUID();
        retryCount = 0;
        lastUpdated = this.creationTime;
    }

    @Override
    public String toString() {
        return String.format("OperationItem %d (%s) (%s): %s, retry count: %d, created: %s, last updated: %s",
                sequenceNumber,
                operation.getClass().getSimpleName(),
                correlationId,
                operation,
                retryCount,
                creationTime,
                lastUpdated);
    }
}

