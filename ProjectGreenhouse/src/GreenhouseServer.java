import java.net.*;
import java.io.*;

public class GreenhouseServer {

    public static void main(String[] args) throws IOException{
        try {
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(9806);
            Socket s = ss.accept();
            System.out.println("Connection established");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
