
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class Test {

    public static void main( String [] args)throws IOException{

        ServerSocket server=new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...."); 
        while (true){ 
            Socket clientSocket =server.accept();
            // InputStreamReader isr=new InputStreamReader(clientSocket.getInputStream());
            // BufferedReader reader=new BufferedReader(isr);
            // String line=reader.readLine();
            // while(!line.isEmpty()){
            //     System.out.println(line);
            //     line=reader.readLine();
            // }

            Date today=new Date();
            String httpResponse="HTTP/1.1 200 OK \r\n\r\n"+today;
            clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        }
    }
}