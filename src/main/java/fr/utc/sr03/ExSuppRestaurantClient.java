package fr.utc.sr03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExSuppRestaurantClient {
    private static final Logger LOGGER = Logger.getLogger(ExSuppRestaurantClient.class.getName());

    public static void main(String[] args) {
        try {
            // Socket de communication et Object Stream
            Socket clientSocket = new Socket("localhost", 20000);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Client : Connexion effectuee");

            // Envoi des donnees
            System.out.println("Client : Envoi des donnees");
            out.writeObject(new Point2D(50, 60));

            // Attente et lecture des donnees
            Restaurant restaurant = (Restaurant) in.readObject();
            System.out.println("Client : Restaurant recu = " + restaurant);

            // Fermeture des stream et de la socket
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }
}
