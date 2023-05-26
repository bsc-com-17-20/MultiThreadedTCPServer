import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clienSocket;

    public ClientHandler(Socket clienSocket) {
        this.clienSocket = clienSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clienSocket.getOutputStream(), true);

            // Handle client request
            // Echo back client messages
            while (true) {
                String echoString = input.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clienSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
