package fr.utc.sr03;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String nom;
    private String telephone;
    private Point2D position;

    public Restaurant(String nom, String telephone, Point2D position) {
        this.nom = nom;
        this.telephone = telephone;
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "nom=" + nom + ", telephone=" + telephone + ", position=" + position + '}';
    }
}
