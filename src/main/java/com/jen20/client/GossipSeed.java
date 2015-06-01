package com.jen20.client;

import java.net.InetSocketAddress;

/**
 * Represents a seed node for cluster gossip
 */
public class GossipSeed {
    private final InetSocketAddress endpoint;
    private final String hostHeader;

    /**
     * Creates a new GossipSeed
     * @param endpoint the address of the External HTTP endpoint of the gossip seed. The standard port is 2113.
     * @param hostHeader The host header to be sent when exchanging gossip.
     */
    public GossipSeed(InetSocketAddress endpoint, String hostHeader) {
        this.endpoint = endpoint;
        this.hostHeader = hostHeader;
    }

    /**
     * Creates a new GossipSeed
     * @param endpoint the address of the External HTTP endpoint of the gossip seed. The standard port is 2113.
     */
    public GossipSeed(InetSocketAddress endpoint) {
        this.endpoint = endpoint;
        this.hostHeader = "";
    }

    @Override
    public String toString() {
        return "GossipSeed{" +
                "endpoint=" + endpoint +
                ", hostHeader='" + hostHeader + '\'' +
                '}';
    }

    /**
     * Gets the endpoint of the gossip seed
     * @return the endpoint of the gossip seed
     */
    public InetSocketAddress getEndpoint() {
        return endpoint;
    }

    /**
     * Gets the host header of the gossip seed
     * @return the host header of the gossip seed
     */
    public String getHostHeader() {
        return hostHeader;
    }
}
