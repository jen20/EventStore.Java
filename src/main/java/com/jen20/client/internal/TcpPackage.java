package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.UUID;

class TcpPackage {
    public final TcpCommand Command;
    public final TcpFlag Flags;
    public final UUID CorrelationId;
    public final String Login;
    public final char[] Password;
    public final ByteBuf Data;

    public TcpPackage(TcpCommand command, TcpFlag flags, UUID correlationId, String login, char[] password, ByteBuf data) {
        Command = command;
        Flags = flags;
        CorrelationId = correlationId;
        Login = login;
        Password = password;
        Data = data;
    }

    @Override
    public String toString() {
        return "TcpPackage{" +
                "Command=" + Command +
                ", Flags=" + Flags +
                ", CorrelationId=" + CorrelationId +
                ", Login=" + (Login == null ? "null" : "'" + Login + '\'') +
                ", Password=" + Arrays.toString(Password) +
                ", Data=" + Data +
                '}';
    }
}
