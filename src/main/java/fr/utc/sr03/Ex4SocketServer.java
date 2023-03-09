package fr.utc.sr03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex4SocketServer {
    private static final Logger LOGGER = Logger.getLogger(Ex4SocketServer.class.getName());

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(20000);
            while (true) {
                // Attente de connexion
                System.out.println("Serveur : Attente de connexion");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Serveur : Connexion acceptee");

                // Data Stream
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();

                // Buffer qui contiendra les donnees recues
                byte[] buffer = new byte[1024];

                // Attente et lecture des donnees
                System.out.println("Serveur : Attente des donnees");
                int size = in.read(buffer);
                String message = new String(buffer, 0, size);
                System.out.println("Serveur : Taille des donnees = " + size);
                System.out.println("Serveur : Message recu = " + message);

                Thread.sleep(5000);

                // Envoi des donnees
                System.out.println("Serveur : Envoi des donnees");
                out.write(message.getBytes());

                // Fermeture des stream et de la socket
                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }
}
