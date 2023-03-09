package fr.utc.sr03;

public class Ex1 {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(1, 2);
        Point2D p2 = new Point2D(3, 4);
        System.out.println("Distance entre " + p1 + " et " + p2 + " : " + p1.calculerDistance(p2));
    }
}
