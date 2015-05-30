package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("FieldCanBeLocal")
class TcpPackageDecoder extends ReplayingDecoder<Void> {
    private final int CommandOffset = 0;
    private final int FlagsOffset = CommandOffset + 1;
    private final int CorrelationOffset = FlagsOffset + 1;
    private final int AuthOffset = CorrelationOffset + 16;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        TcpCommand command = TcpCommands.fromByte(byteBuf.getByte(CommandOffset));
        TcpFlag flags = TcpFlag.fromUnsignedByte(byteBuf.getByte(FlagsOffset));
        UUID correlationId = DotNetEncoding.uuidFromByteBuf(byteBuf, CorrelationOffset);

        int headerLength = AuthOffset;

        String username = null;
        char[] password = null;
        if (flags == TcpFlag.AUTHENTICATED) {
            int usernameLength = byteBuf.getUnsignedByte(AuthOffset);
            username = byteBuf.slice(AuthOffset+1, usernameLength).toString(CharsetUtil.UTF_8);

            int passwordLength = byteBuf.getUnsignedByte(AuthOffset + 1 + usernameLength);
            password = new char[passwordLength];
            for (int i = 0, j = AuthOffset + 1 + usernameLength + 1; i < passwordLength; i++, j++) {
                password[i] = byteBuf.getChar(j);
            }

            headerLength += 1           // login length byte
                    + usernameLength    // actual length of the username
                    + 1                 // password length byte
                    + passwordLength;   // actual length of the password
        }

        ByteBuf dataSlice = byteBuf.slice(headerLength, byteBuf.capacity() - headerLength).retain();

        list.add(new TcpPackage(command, flags, correlationId, username, password, dataSlice));
        byteBuf.readerIndex(byteBuf.capacity());
    }
}

