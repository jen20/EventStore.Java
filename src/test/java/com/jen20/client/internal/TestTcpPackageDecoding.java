package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.junit.Test;

import java.nio.ByteOrder;
import java.util.UUID;

import static com.jen20.client.internal.TcpPackageEquality.tcpPackagesAreEquivalent;
import static org.junit.Assert.assertTrue;

public class TestTcpPackageDecoding {

    @Test
    public void TestTcpPackageDecoding1() {
        ByteBuf input = TestDataResources.singleLengthPrefixedTcpPackage().retain();

        EmbeddedChannel channel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 64*1024*1024, 0, 4, 0, 4, true),
                new TcpPackageDecoder()
        );
        channel.writeInbound(input);
        channel.finish();

        TcpPackage actual = (TcpPackage)channel.readInbound();

        TcpPackage expected = new TcpPackage(TcpCommand.WRITE_EVENTS, TcpFlag.NONE, UUID.fromString("a7f0416a-b26a-40d2-a883-2755bd077568"),
                null, null, input.slice(22, 489));

        assertTrue(tcpPackagesAreEquivalent(expected, actual));
    }
}
