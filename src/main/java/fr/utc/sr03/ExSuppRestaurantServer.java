package fr.utc.sr03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExSuppRestaurantServer {
    private static final Logger LOGGER = Logger.getLogger(ExSuppRestaurantServer.class.getName());

    static final List<Restaurant> restaurants = new ArrayList<>() {{
        add(new Restaurant("Le petit resto", "1 rue de la paix", new Point2D(12, 34)));
        add(new Restaurant("Le grand resto", "2 rue de la paix", new Point2D(56, 78)));
        add(new Restaurant("Le resto de la paix", "3 rue de la paix", new Point2D(91, 112)));
    }};

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(20000);
            while (true) {
                // Attente de connexion
                System.out.println("Serveur : Attente de connexion");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Serveur : Connexion acceptee");

                // Object Stream
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                // Attente et lecture des donnees
                System.out.println("Serveur : Attente des donnees");
                Point2D position = (Point2D) in.readObject();
                System.out.println("Serveur : Position recu = " + position);

                // Envoi des donnees
                System.out.println("Serveur : Envoi des donnees");
                out.writeObject(getClosestRestaurant(position));

                // Fermeture des stream et de la socket
                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Erreur", e);
        }
    }

    private static Restaurant getClosestRestaurant(Point2D position){
        return restaurants.stream()
                .min(Comparator.comparingDouble(r -> r.getPosition().calculerDistance(position)))
                .get();
    }
}
