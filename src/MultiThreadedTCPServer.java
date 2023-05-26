import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedTCPServer {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Server listening on port " + 8888);

            while (true) {
                Socket clienSocket = serverSocket.accept();
                System.out.println("New client connected: " + clienSocket.getInetAddress().getHostAddress());

                // Create a new task and submit it to the thread pool
                threadpool.execute(new ClientHandler(clienSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }
        System.out.println("Hello, world!");
    }
}
