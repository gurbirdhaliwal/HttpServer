import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.Date;

public class HttpServer {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            try (Socket client = serverSocket.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}