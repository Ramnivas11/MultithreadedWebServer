
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true) { 
           try{
             System.out.println("server is listening on port " + port);
             Socket acceptedConnection = socket.accept();
             System.out.println("connection accepted from " + acceptedConnection.getRemoteSocketAddress());
             PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
             toClient.println("Hello client, you are connected to the server");
             toClient.close();
             fromClient.close();
            acceptedConnection.close();
           }catch(IOException ex){
            ex.printStackTrace();
           }
        }

    }
    
    public static void main(String[] args) {
        System.out.println("Server is running...");
        Server server = new Server();
        try {
            server.run();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}