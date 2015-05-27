# Event Store Java

This is a pure Java 8-targeted client API for the TCP protocol of [Event Store](https://geteventstore.com). Note that this is a personal project and is not currently supported as part of Event Store. There is a supported client for the JVM built on top of Akka, available here: [EventStore.JVM](https://github.com/EventStore/EventStore.JVM).

This is currently not functional, and is public to allow Java developers or those who may wrap the API for other purposes (e.g. JRuby) to influence the design early on.

The current intention is to take dependencies on:

- SLF4J (logging abstraction)
- Netty (network comms)
- Protocol buffers (required for the Event Store protocol)

The API is intended to mimic the .NET client (part of the main project repository) but is not bound by backward-compatibility constraints at this stage.
