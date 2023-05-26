# MultiThreadedTCPServer

This is a simple multithreaded TCP server in Java that accepts multiple connections from clients. It utilizes a thread pool to handle client requests efficiently.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## How It Works

The server listens for incoming connections from clients on a specified port. When a client connects, a new task (ClientHandler) is created and submitted to a thread pool for processing. The thread pool manages a fixed number of threads (THREAD_POOL_SIZE) and assigns tasks to available threads.

Each client connection is handled by a separate ClientHandler thread, allowing concurrent processing of multiple clients. The ClientHandler handles client requests, such as reading and writing data to the client's input and output streams.

<!-- In this example, the server simply echoes back the received messages from clients. -->

## Advantages of Using a Thread Pool

Using a thread pool has several advantages over creating a new thread for each client:

1. **Resource Management**: Creating a new thread for each client connection can consume a significant amount of system resources. Threads have associated overhead in terms of memory and context switching. By using a thread pool, we can limit the maximum number of threads and prevent resource exhaustion.

2. **Concurrency Control**: A thread pool provides better control over concurrency. It allows us to define the maximum number of concurrent threads, preventing a situation where an excessive number of client connections leads to system instability or performance degradation.

3. **Reuse of Threads**: Thread creation and destruction can be expensive operations. With a thread pool, threads are created once and can be reused for subsequent client connections. Reusing threads reduces the overhead of creating new threads for each request, resulting in better performance.

4. **Load Balancing**: A thread pool can distribute client requests evenly across available threads. It ensures that the workload is balanced among the threads, optimizing resource utilization and avoiding situations where some threads are overloaded while others are idle.

5. **Scalability**: Using a thread pool provides better scalability. As the number of client connections increases, the thread pool can automatically adjust and efficiently allocate resources to handle the increased workload.

## Usage

1. Compile the Java source code: `javac MultiThreadedTCPServer.java`

2. Run the server: `java MultiThreadedTCPServer`

3. The server will start listening on the specified port (default: 8888) for incoming client connections. Clients can connect to the server using the appropriate IP address and port number.

4. Customize the logic inside the `ClientHandler` class to implement your desired functionality for handling client requests.

## Notes

- Ensure that the specified port is not being used by any other process to avoid port conflicts.

- Proper error handling, graceful shutdown, and thread safety considerations may need to be implemented for production use cases.

- This is a simplified example to demonstrate the usage of a thread pool in a multithreaded TCP server. In real-world scenarios, additional features and optimizations may be required.
