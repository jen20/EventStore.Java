package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.*;

public class TestDataResources {
    private static ByteBuf resourceAsByteBuf(String resourceName) {
        try {
            URL resource = TestDataResources.class.getResource(resourceName);
            InputStream resourceStream = resource.openStream();

            ByteBuf buf = Unpooled.buffer(resourceStream.available());
            buf.writeBytes(resourceStream, resourceStream.available());
            return buf;
        } catch (IOException e) {
            assertTrue("Cannot read test resource " + resourceName, false);
            return null;
        }
    }

    public static ByteBuf singleLengthPrefixedTcpPackage() {
        return resourceAsByteBuf("/singleLengthPrefixedTcpPackage");
    }

    public static ByteBuf lastSingleLengthFramedTcpPackage() {
        return resourceAsByteBuf("/lastSingleLengthFramedTcpPackage");
    }

    public static ByteBuf completeTcpFrameMultipleTcpPackage() {
        return resourceAsByteBuf("/completeTcpFrameMultipleTcpPackage");
    }
}
