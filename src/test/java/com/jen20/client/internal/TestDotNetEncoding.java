package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Contains tests of the static methods in the DotNetEncoding class
 */
public class TestDotNetEncoding {
    @Test(expected=IllegalArgumentException.class)
    public void uuidFromByteArrayThrowsWithInsufficientlyLongInput() {
        byte[] input = new byte[15];
        DotNetEncoding.uuidFromByteArray(input);
    }

    @Test(expected=IllegalArgumentException.class)
    public void uuidFromByteArrayThrowsWithInsufficientlyLongInputAtOffset() {
        byte[] input = new byte[25];
        DotNetEncoding.uuidFromByteArray(input, 10);
    }

    @Test
    public void testSerializedUuidAtZeroOffset1() {
        byte[] input = new byte[] {
                (byte)0x46, (byte)0x6c, (byte)0xbc, (byte)0x3e, (byte)0x72, (byte)0xe2, (byte)0x26, (byte)0x42, (byte)0xbc, (byte)0xb5, (byte)0xaa, (byte)0x93, (byte)0xc4, (byte)0x11, (byte)0xed, (byte)0x0d
        };
        UUID actual = DotNetEncoding.uuidFromByteArray(input);

        UUID expected = UUID.fromString("3ebc6c46-e272-4226-bcb5-aa93c411ed0d");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtZeroOffset2() {
        byte[] input = new byte[] {
                (byte)0xf8, (byte)0xa6, (byte)0xbb, (byte)0x92, (byte)0xe4, (byte)0x07, (byte)0x4d, (byte)0x4a, (byte)0xb1, (byte)0xdf, (byte)0x19, (byte)0x04, (byte)0xa9, (byte)0x3c, (byte)0x65, (byte)0xa9
        };
        UUID actual = DotNetEncoding.uuidFromByteArray(input);

        UUID expected = UUID.fromString("92bba6f8-07e4-4a4d-b1df-1904a93c65a9");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtZeroOffset3() {
        byte[] input = new byte[] {
                (byte)0x86, (byte)0x6f, (byte)0x1b, (byte)0xf5, (byte)0x97, (byte)0xf4, (byte)0x7d, (byte)0x42, (byte)0xa0, (byte)0x10, (byte)0xc5, (byte)0x9b, (byte)0x16, (byte)0xf2, (byte)0x26, (byte)0x59
        };
        UUID actual = DotNetEncoding.uuidFromByteArray(input);

        UUID expected = UUID.fromString("f51b6f86-f497-427d-a010-c59b16f22659");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtNonZeroOffset1() {
        byte[] input = new byte[] {
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x40, (byte)0x2d, (byte)0xc2, (byte)0x3d, (byte)0xd1, (byte)0x63, (byte)0x99, (byte)0x48, (byte)0x80, (byte)0x7a, (byte)0x0c, (byte)0xa2, (byte)0xb0, (byte)0xac, (byte)0x40, (byte)0x32
        };
        UUID actual = DotNetEncoding.uuidFromByteArray(input, 4);

        UUID expected = UUID.fromString("3dc22d40-63d1-4899-807a-0ca2b0ac4032");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtNonZeroOffsetAndTrailingContent() {
        byte[] input = new byte[] {
                (byte)0x00, (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04, (byte)0x05, (byte)0x06, (byte)0x07, (byte)0x08, (byte)0x09, (byte)0xdf, (byte)0x39, (byte)0x0a, (byte)0x81, (byte)0x7c, (byte)0x00, (byte)0x2b, (byte)0x46, (byte)0x8f, (byte)0x90, (byte)0x58, (byte)0x45, (byte)0x2d, (byte)0xf8, (byte)0x2e, (byte)0x36, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00
        };
        UUID actual = DotNetEncoding.uuidFromByteArray(input, 10);

        UUID expected = UUID.fromString("810a39df-007c-462b-8f90-58452df82e36");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtZeroOffset1InNettyByteBuf() {
        byte[] input = new byte[] {
                (byte)0x46, (byte)0x6c, (byte)0xbc, (byte)0x3e, (byte)0x72, (byte)0xe2, (byte)0x26, (byte)0x42, (byte)0xbc, (byte)0xb5, (byte)0xaa, (byte)0x93, (byte)0xc4, (byte)0x11, (byte)0xed, (byte)0x0d
        };
        ByteBuf buf = Unpooled.wrappedBuffer(input);

        UUID actual = DotNetEncoding.uuidFromByteBuf(buf, 0);

        UUID expected = UUID.fromString("3ebc6c46-e272-4226-bcb5-aa93c411ed0d");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtZeroOffset2InNettyByteBuf() {
        byte[] input = new byte[] {
                (byte)0xf8, (byte)0xa6, (byte)0xbb, (byte)0x92, (byte)0xe4, (byte)0x07, (byte)0x4d, (byte)0x4a, (byte)0xb1, (byte)0xdf, (byte)0x19, (byte)0x04, (byte)0xa9, (byte)0x3c, (byte)0x65, (byte)0xa9
        };
        ByteBuf buf = Unpooled.wrappedBuffer(input);

        UUID actual = DotNetEncoding.uuidFromByteBuf(buf, 0);

        UUID expected = UUID.fromString("92bba6f8-07e4-4a4d-b1df-1904a93c65a9");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtZeroOffset3InNettyByteBuf() {
        byte[] input = new byte[] {
                (byte)0x86, (byte)0x6f, (byte)0x1b, (byte)0xf5, (byte)0x97, (byte)0xf4, (byte)0x7d, (byte)0x42, (byte)0xa0, (byte)0x10, (byte)0xc5, (byte)0x9b, (byte)0x16, (byte)0xf2, (byte)0x26, (byte)0x59
        };
        ByteBuf buf = Unpooled.wrappedBuffer(input);

        UUID actual = DotNetEncoding.uuidFromByteBuf(buf, 0);

        UUID expected = UUID.fromString("f51b6f86-f497-427d-a010-c59b16f22659");

        assertEquals(expected, actual);
    }
    @Test
    public void testSerializedUuidAtNonZeroOffset1InNettyByteBuf() {
        byte[] input = new byte[] {
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x40, (byte)0x2d, (byte)0xc2, (byte)0x3d, (byte)0xd1, (byte)0x63, (byte)0x99, (byte)0x48, (byte)0x80, (byte)0x7a, (byte)0x0c, (byte)0xa2, (byte)0xb0, (byte)0xac, (byte)0x40, (byte)0x32
        };
        ByteBuf buf = Unpooled.wrappedBuffer(input);

        UUID actual = DotNetEncoding.uuidFromByteBuf(buf, 4);

        UUID expected = UUID.fromString("3dc22d40-63d1-4899-807a-0ca2b0ac4032");

        assertEquals(expected, actual);
    }

    @Test
    public void testSerializedUuidAtNonZeroOffsetAndTrailingContentInNettyByteBuf() {
        byte[] input = new byte[] {
                (byte)0x00, (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04, (byte)0x05, (byte)0x06, (byte)0x07, (byte)0x08, (byte)0x09, (byte)0xdf, (byte)0x39, (byte)0x0a, (byte)0x81, (byte)0x7c, (byte)0x00, (byte)0x2b, (byte)0x46, (byte)0x8f, (byte)0x90, (byte)0x58, (byte)0x45, (byte)0x2d, (byte)0xf8, (byte)0x2e, (byte)0x36, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00
        };
        ByteBuf buf = Unpooled.wrappedBuffer(input);

        UUID actual = DotNetEncoding.uuidFromByteBuf(buf, 10);

        UUID expected = UUID.fromString("810a39df-007c-462b-8f90-58452df82e36");

        assertEquals(expected, actual);
    }
}
