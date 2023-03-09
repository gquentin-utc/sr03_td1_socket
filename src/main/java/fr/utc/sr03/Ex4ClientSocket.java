package fr.utc.sr03;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex4ClientSocket {
    private static final Logger LOGGER = Logger.getLogger(Ex4ClientSocket.class.getName());

    public static void main(String[] args) {
        try {
            // Socket de communication et Data Stream
            Socket clientSocket = new Socket("localhost", 20000);
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();

            System.out.println("Client : Connexion effectuee");
            Thread.sleep(5000);

            // Envoi des donnees
            System.out.println("Client : Envoi des donnees");
            out.write("hello".getBytes());

            // Attente et lecture des donnees
            byte[] buffer = new byte[1024];
            System.out.println("Client : Attente des donnees");
            int size = in.read(buffer);
            String message = new String(buffer, 0, size);
            System.out.println("Client : Taille des donnees = " + size);
            System.out.println("Client : Message recu = " + message);

            // Fermeture des stream et de la socket
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }
}
