import java.net.*;
import java.io.*;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class GreenhouseClient {

    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Client started");
            Socket clientSocket = new Socket("localhost", 9806);
            while (true) {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a string");
                String str = userInput.readLine();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(str);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(in.readLine());
                if (str.equals("close")){
                    break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}



