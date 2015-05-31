package com.jen20.client.internal;

import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.junit.Test;

import java.nio.ByteOrder;
import java.util.UUID;

import static com.jen20.client.internal.TcpPackageEquality.tcpPackagesAreEquivalent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestTcpPackageDecoding {

    @Test
    public void testDecodeSingleTcpPackage() {
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

    @Test
    public void testDecodeMultipleTcpPackages() {
        ByteBuf input = TestDataResources.completeTcpFrameMultipleTcpPackage().retain();

        EmbeddedChannel channel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 64*1024*1024, 0, 4, 0, 4, true),
                new TcpPackageDecoder()
        );
        channel.writeInbound(input);
        channel.finish();

        String[] expectedTcpPackageCorrelationIDs = getExpectedCorrelationIDs();

        TcpPackage[] actualTcpPackages = new TcpPackage[expectedTcpPackageCorrelationIDs.length];
        for (int i = 0; i < actualTcpPackages.length; i++) {
            actualTcpPackages[i] = (TcpPackage)channel.readInbound();
        }

        for (int i = 0; i < actualTcpPackages.length; i++) {
            assertEquals(UUID.fromString(expectedTcpPackageCorrelationIDs[i]), actualTcpPackages[i].CorrelationId);
        }

        assertTrue(tcpPackagesAreEquivalent(getFirstTcpPackage(), actualTcpPackages[0]));
        assertTrue(tcpPackagesAreEquivalent(getLastTcpPackage(), actualTcpPackages[actualTcpPackages.length - 1]));

        assertNull(channel.readInbound());
    }

    private TcpPackage getFirstTcpPackage() {
        ByteBuf input = TestDataResources.singleLengthPrefixedTcpPackage().retain();

        return new TcpPackage(TcpCommand.WRITE_EVENTS, TcpFlag.NONE, UUID.fromString("a7f0416a-b26a-40d2-a883-2755bd077568"),
                null, null, input.slice(22, 489));
    }

    private TcpPackage getLastTcpPackage() {
        ByteBuf input = TestDataResources.lastSingleLengthFramedTcpPackage().retain();

        return new TcpPackage(TcpCommand.WRITE_EVENTS, TcpFlag.NONE, UUID.fromString("b65abf69-84a3-4c72-8412-aca6075283d3"),
                null, null, input.slice(22, 489));
    }

    private String[] getExpectedCorrelationIDs() {
        return new String[] {
                "a7f0416a-b26a-40d2-a883-2755bd077568",
                "450f112f-34d1-42b0-aee4-6a0033784aef",
                "7686ee53-514c-434a-8dd6-9ca4ff957a2f",
                "fcd5120b-7b3e-4493-b0c7-ed10d2781058",
                "ca1fc518-e9ab-4c5e-8923-e2486229e0ef",
                "3443c645-d1ba-4793-b738-2e3aaae55e2c",
                "6fe4e69e-069b-41c6-aac2-b97d094cdb00",
                "637cc266-1293-4fb0-8647-c88769a735ac",
                "1a013c2a-cfcb-4219-83fa-b50de72b6715",
                "3d0fc77a-ef87-479a-920a-30fa220a6285",
                "5aac1837-4167-48a5-88d3-cd9166a1b63b",
                "6cf152fb-dc59-4e50-bd18-7394db9dfcc3",
                "b24490c6-bd53-4b90-8a2c-28578fd923a6",
                "5f8537f0-4de0-4b37-bf2b-ac7bc1135d38",
                "cd8fb3c2-1173-4e1e-9cf8-83b8ec0e5f85",
                "b1ebf693-5def-45d6-bf9b-076bdc33481e",
                "7a67fa25-440a-4feb-bca3-ad3ca33242f4",
                "dd4e9704-2960-47b7-b086-40f74bd640cb",
                "3bcb596e-3c80-431f-9eaa-596c53057baf",
                "510569ac-820c-482e-9362-2db610be7188",
                "9f15d41b-7fc2-4f1a-9bcd-9ad2f51dd01f",
                "6c22bc95-2591-42b2-ba41-224e8312deca",
                "90d78ffb-62c3-4aeb-bef6-2b530e7b9e95",
                "0e0cb20d-2ff1-42de-baf0-8ea7a198224d",
                "5f397529-70c3-4487-b2fb-66b6c95305b9",
                "50bb95d2-265a-46f9-8026-ddda4b3002af",
                "52012216-38ac-4419-9ac6-59143892998c",
                "04dc03fd-91ef-49c6-9916-bc2ab8f2790a",
                "d939851e-e448-480f-8f28-ededa64a3ea2",
                "5dda59b9-1fa9-4894-837f-3355424ebed5",
                "b65abf69-84a3-4c72-8412-aca6075283d3"
        };
    }
}
