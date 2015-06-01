package com.jen20.client.internal;

import java.net.InetSocketAddress;

class InspectionResult {
    private final InspectionDecision decision;
    private final String description;
    private final InetSocketAddress tcpEndpoint;
    private final InetSocketAddress secureTcpEndpoint;

    public InspectionResult(InspectionDecision decision, String description, InetSocketAddress tcpEndpoint, InetSocketAddress secureTcpEndpoint) {
        if (decision == InspectionDecision.RECONNECT && tcpEndpoint == null) {
            throw new IllegalArgumentException("tcpEndpoint cannot be null if InspectionDecision is RECONNECT");
        } else if (tcpEndpoint != null) {
            throw new IllegalArgumentException("tcpEndpoint is not null for decision " + decision);
        }

        this.decision = decision;
        this.description = description;
        this.tcpEndpoint = tcpEndpoint;
        this.secureTcpEndpoint = secureTcpEndpoint;
    }

    public InspectionDecision getDecision() {
        return decision;
    }

    public String getDescription() {
        return description;
    }

    public InetSocketAddress getTcpEndpoint() {
        return tcpEndpoint;
    }

    public InetSocketAddress getSecureTcpEndpoint() {
        return secureTcpEndpoint;
    }
}
