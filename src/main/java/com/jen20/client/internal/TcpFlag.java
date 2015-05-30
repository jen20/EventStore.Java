package com.jen20.client.internal;

enum TcpFlag {
    NONE((byte)0),
    AUTHENTICATED((byte)1);

    public final byte value;

    TcpFlag(byte value) {
        this.value = value;
    }

    public static TcpFlag fromUnsignedByte(byte value) {
        return TcpFlag.values()[value];
    }
}
