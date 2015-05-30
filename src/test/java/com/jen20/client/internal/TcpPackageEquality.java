package com.jen20.client.internal;

import java.util.Arrays;

public class TcpPackageEquality {
    public static boolean tcpPackagesAreEquivalent(TcpPackage expected, TcpPackage actual) {
        if (expected.Command != actual.Command) return false;
        if (expected.Flags != actual.Flags) return false;
        if (expected.CorrelationId != null ? !expected.CorrelationId.equals(actual.CorrelationId) : actual.CorrelationId != null)
            return false;
        if (expected.Login != null ? !expected.Login.equals(actual.Login) : actual.Login != null) return false;
        if (!Arrays.equals(expected.Password, actual.Password)) return false;

        int expectedDataLength = expected.Data.capacity() - expected.Data.arrayOffset();
        int actualDataLength = actual.Data.capacity() - actual.Data.arrayOffset();

        if (expectedDataLength != actualDataLength) return false;

        byte[] expectedBytes = new byte[expectedDataLength];
        byte[] actualBytes = new byte[actualDataLength];

        expected.Data.getBytes(0, expectedBytes);
        actual.Data.getBytes(0, actualBytes);

        return Arrays.equals(expectedBytes, actualBytes);
    }
}
