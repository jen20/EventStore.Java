package com.jen20.client.internal;

enum TcpCommand {
    HEARTBEAT_REQUEST((byte)0x01),
    HEARTBEAT_RESPONSE((byte)0x02),

    PING((byte)0x03),
    PONG((byte)0x04),

    PREPARE_ACK((byte)0x05),
    COMMIT_ACK((byte)0x06),

    SLAVE_ASSIGNMENT((byte)0x07),
    CLONE_ASSIGNMENT((byte)0x08),

    SUBSCRIBE_REPLICA((byte)0x10),
    REPLICA_LOG_POSITION_ACK((byte)0x11),
    CREATE_CHUNK((byte)0x12),
    RAW_CHUNK_BULK((byte)0x13),
    DATA_CHUNK_BULK((byte)0x14),
    REPLICA_SUBSCRIPTION_RETRY((byte)0x15),
    REPLICA_SUBSCRIBED((byte)0x16),

    WRITE_EVENTS((byte)0x82),
    WRITE_EVENTS_COMPLETED((byte)0x83),

    DELETE_STREAM((byte)0x8A),
    DELETE_STREAM_COMPLETED((byte)0x8B),

    READ_EVENT((byte)0xB0),
    READ_EVENT_COMPLETED((byte)0xB1),
    READ_STREAM_EVENTS_FORWARD((byte)0xB2),
    READ_STREAM_EVENTS_FORWARD_COMPLETED((byte)0xB3),
    READ_STREAM_EVENTS_BACKWARD((byte)0xB4),
    READ_STREAM_EVENTS_BACKWARD_COMPLETED((byte)0xB5),
    READ_ALL_EVENTS_FORWARD((byte)0xB6),
    READ_ALL_EVENTS_FORWARD_COMPLETED((byte)0xB7),
    READ_ALL_EVENTS_BACKWARD((byte)0xB8),
    READ_ALL_EVENTS_BACKWARD_COMPLETED((byte)0xB9),

    SUBSCRIBE_TO_STREAM((byte)0xC0),
    SUBSCRIPTION_CONFIRMATION((byte)0xC1),
    STREAM_EVENT_APPEARED((byte)0xC2),
    UNSUBSCRIBE_FROM_STREAM((byte)0xC3),
    SUBSCRIPTION_DROPPED((byte)0xC4),

    SCAVENGE_DATABASE((byte)0xD0),
    SCAVENGE_DATABASE_COMPLETED((byte)0xD1),

    BAD_REQUEST((byte)0xF0),
    NOT_HANDLED((byte)0xF1),
    AUTHENTICATE((byte)0xF2),
    AUTHENTICATED((byte)0xF3),
    NOT_AUTHENTICATED((byte)0xF4);

    public final byte value;

    TcpCommand(byte value) {
        this.value = value;
    }

    public static TcpCommand fromByte(byte value) {
        return TcpCommand.values()[value];
    }
}

