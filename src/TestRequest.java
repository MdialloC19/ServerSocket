import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;


public class TestRequest {
    public static void main (String []args) throws IOException{
        
        String host="localhost";
        int port=80;
        String path="/authentification/welcome.php";
        String username="moussa";
        String password="ababa";

        //les paramètres du requetes à envoyer

        String params="username="+URLEncoder.encode(username, "UTF-8")+
                      "&password="+URLEncoder.encode(password,"UTF-8");

        // Nous allons etablir une connexion avec le serveur

        Socket clientSocket =new Socket(host, port);

        //la requete http à envoyers

        String requete= "POST "+path+ " HTTP/1.1"+"\r\n"+
                        "Host: "+host+"\r\n"+
                        "Connection: close\r\n"+
                        "Content-Type: application/x-www-form-urlencoded\r\n"+
                        "Content-Length: "+params.length()+
                        "\r\n"+"\r\n"+params; 
        OutputStream outputStream=clientSocket.getOutputStream();              
        outputStream.write(requete.getBytes());
        outputStream.flush();

        InputStreamReader isr=new InputStreamReader(clientSocket.getInputStream());
        BufferedReader reader=new BufferedReader(isr);
        // Lire la réponse du serveur
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }

        // Afficher la réponse
        System.out.println(response.toString());
        reader.close();
        outputStream.close();
        clientSocket.close();





        
    }
}
