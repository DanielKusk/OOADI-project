import java.net.*;
import java.io.*;

public class GreenhouseClient {
    public static void main(String[] args) throws IOException{

        try{
            System.out.println("Client started");
            Socket s = new Socket("localhost", 9806);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
