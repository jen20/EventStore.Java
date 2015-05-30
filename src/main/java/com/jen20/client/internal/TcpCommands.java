package com.jen20.client.internal;

import java.util.HashMap;
import java.util.Map;

//TODO(jen20): Make this a lookup function that switches on the byte instead of
// requiring a boxing operation on every lookup.
class TcpCommands {
    private static Map<Byte, TcpCommand> values = new HashMap<>();

    static {
        for (TcpCommand c : TcpCommand.values()) {
            values.put(c.value, c);
        }
    }

    public static TcpCommand fromByte(byte value) {
        return values.get(value);
    }
}
