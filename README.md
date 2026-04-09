MultiThreadedWebServer:
A simple multi-threaded TCP echo server and client demonstration in Java. The server handles multiple client connections concurrently using separate threads for each connection. Ideal for learning socket programming and concurrency.

Features
Server listens on port 8010 with 10-second timeout.
Spawns a new thread per client for concurrent handling.
Simple request-response: Clients send greeting, server responds with "Hello from the server!".
Client simulates load by spawning 100 concurrent threads.
Architecture

Server (Main Thread)
├── Accepts connections (infinite loop)
└── Per Client: New Thread → Send response → Close socket
Client (Main Thread)
└── Spawns 100 Threads → Connect → Send message → Read response → Print
Prerequisites
Java JDK (tested with Java 8+)
Compile & Run
Compile (from project root):

javac MultiThreadedWebServer/*.java
Start Server (new terminal):

java MultiThreadedWebServer.Server
Output: Server is listening on port 8010
Run Client (new terminal):

java MultiThreadedWebServer.Client
Expected: 100 responses printed rapidly, e.g., Response from Server Hello from the server!
Limitations
No error recovery beyond printStackTrace.
Fixed port; hardcoded messages.
Server uses Consumer lambda (Java 8+).
File Structure

MultiThreadedWebServer/
├── Server.java     # Multi-threaded server
├── Client.java     # Multi-threaded client
├── Server.class
├── Client.class
└── Client$1.class  # Lambda inner class
singlethreadedWebServer README
Overview
A basic single-threaded TCP echo server and client in Java. The server handles client connections sequentially (one at a time). Great for understanding fundamental socket programming.

Features
Server listens on port 8010 with 10-second timeout.
Single-threaded: Processes one client fully before accepting next.
Bidirectional: Server reads client input (unused), responds with "Hello client, you are connected to the server".
Simple single-run client.
Architecture

Server (Single Main Thread)
├── Accepts connections (infinite loop, sequential)
├── Read from client → Send response → Close socket
Client (Single Main Thread)
├── Connect → Send message → Read response → Print → Close
Prerequisites
Java JDK (tested with Java 8+)
Compile & Run
Compile (from project root):

javac singlethreadedWebServer/*.java
Start Server (new terminal):

java singlethreadedWebServer.Server
Output: server is listening on port 8010 → connection accepted from ...
Run Client (new terminal):

java singlethreadedWebServer.Client
Expected: Message from socket is: Hello client, you are connected to the server
Note: Run multiple clients sequentially; they queue up due to single-threading.

Limitations
Blocks on multi-clients (no concurrency).
No advanced error handling.
Server reads but ignores client input.
File Structure

singlethreadedWebServer/
├── Server.java  # Single-threaded server
├── Client.java  # Single client
├── Server.class
└── Client.class
Comparison: Multi vs Single-Threaded
Aspect	MultiThreaded	SingleThreaded
Concurrency	Yes (1 thread/client)	No (sequential)
Load Handling	100 clients instantly	Queues/blocks
Use Case	High-traffic demos	Basic learning
