package fr.utc.sr03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex3SocketServer {
    private static final Logger LOGGER = Logger.getLogger(Ex3SocketServer.class.getName());

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(20000);
            while (true) {
                // Attente de connexion
                System.out.println("Serveur : Attente de connexion");
                Socket clientSocket = serverSocket.accept();

                // Connexion acceptee
                System.out.println("Serveur : Connexion acceptee");
                clientSocket.close();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }
}
