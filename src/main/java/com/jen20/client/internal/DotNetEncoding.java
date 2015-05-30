package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

/**
 * Contains helper methods for converting the crazy-endian encoding of the
 * GUID type produced by the .NET Framework's Guid.ToByteArray() method into
 * Java UUID types.
 */
class DotNetEncoding {
    private static final int[] mostOrder = new int[]{3,2,1,0,5,4,7,6};

    /**
     * Returns a Java UUID object containing the UUID represented by the sixteen
     * bytes of the Netty ByteBuf, starting from offset, assuming they follow the
     * encoding used by the .NET framework's Guid.ToByteArray() method.
     * @param buffer a netty ByteBuf
     * @param offset the offset in the ByteBuf at which the UUID starts
     * @return A UUID containing the UUID represented by the 16 bytes of buffer
     *         starting at offset.
     */
    public static UUID uuidFromByteBuf(ByteBuf buffer, int offset) {
        //TODO(jen20) consider checking buffer.readableBytes() here

        long most = 0;
        long least = 0;
        for (int i : mostOrder) {
            most = (most << 8) | (buffer.getByte(offset + i) & 0xFF);
        }
        for (int i = 8; i < 16; i++) {
            least = (least << 8) | (buffer.getByte(offset + i) & 0xFF);
        }
        return new UUID(most, least);
    }

    /**
     * Returns a Java UUID object containing the UUID represented by the sixteen
     * bytes of the array parameter starting from offset, assuming they follow
     * the encoding used by the .NET framework's Guid.ToByteArray() method.
     * @param array a byte array
     * @param offset the offset into the array at which the uuid starts
     * @return a UUID containing the UUID represented by the 16 bytes of array
     *         starting from offset
     */
    public static UUID uuidFromByteArray(byte[] array, int offset) {
        if (array.length < (offset + 16))
            throw new IllegalArgumentException(String.format("array must be minimum length %d + 16 bytes, received %d", offset, array.length));

        long most = 0;
        long least = 0;
        for (int i : mostOrder) {
            most = (most << 8) | (array[offset + i] & 0xFF);
        }
        for (int i = 8; i < 16; i++) {
            least = (least << 8) | (array[offset + i] & 0xFF);
        }
        return new UUID(most, least);
    }

    /**
     * Returns a Java UUID object containing the UUID represented by the sixteen
     * bytes of the array parameter, assuming they follow the encoding used by the
     * .NET framework's Guid.ToByteArray() method.
     * @param array a byte array
     * @return a UUID containing the UUID represented by the 16 bytes of array
     */
    public static UUID uuidFromByteArray(byte[] array) {
        return uuidFromByteArray(array, 0);
    }
}


