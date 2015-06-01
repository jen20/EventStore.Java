package com.jen20.client.internal;

import java.net.InetSocketAddress;

class NodeEndpoints {
    private final InetSocketAddress tcpEndpoint;
    private final InetSocketAddress secureTcpEndpoint;

    public NodeEndpoints(InetSocketAddress tcpEndpoint, InetSocketAddress secureTcpEndpoint) {
        if (tcpEndpoint == null && secureTcpEndpoint == null) {
            throw new IllegalArgumentException("Both tcpEndpoint and secureTcpEndpoint are null.");
        }

        this.tcpEndpoint = tcpEndpoint;
        this.secureTcpEndpoint = secureTcpEndpoint;
    }

    public InetSocketAddress getSecureTcpEndpoint() {
        return secureTcpEndpoint;
    }

    public InetSocketAddress getTcpEndpoint() {
        return tcpEndpoint;
    }

    @Override
    public String toString() {
        return "NodeEndpoints{" +
                "tcpEndpoint=" + tcpEndpoint +
                ", secureTcpEndpoint=" + secureTcpEndpoint +
                '}';
    }
}
