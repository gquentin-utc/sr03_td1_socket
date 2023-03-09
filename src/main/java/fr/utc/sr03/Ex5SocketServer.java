package fr.utc.sr03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex5SocketServer {
    private static final Logger LOGGER = Logger.getLogger(Ex5SocketServer.class.getName());

    public static void main(String[] args) {
        try{
            ServerSocket conn= new ServerSocket(10080);
            Socket comm= conn.accept();
            OutputStream out = comm.getOutputStream();
            InputStream in = comm.getInputStream();
            byte[] b = new byte[20];
            String chaine;

            do{
                in.read(b);
                chaine = new String(b);
                System.out.println("reçu : "+chaine);
                out.write(("suivant ?").getBytes());
                b=new byte[20];
            }while(!chaine.startsWith("END"));

            System.out.println("Fin");

            in.close();
            out.close();
            comm.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }
}
