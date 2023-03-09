package fr.utc.sr03;

public class Ex2 {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(3, 4, 5);
        System.out.println("Distance entre " + p1 + " et " + p2 + " : " + p1.calculerDistance(p2));

        Point2D p2d1 = new Point2D(1, 2);
        Point2D p2d2 = new Point2D(3, 4);
        System.out.println("Distance entre " + p2d1 + " et " + p2d2 + " : " + p2d1.calculerDistance(p2d2));
        System.out.println("Distance entre " + p1 + " et " + p2d2 + " : " + p1.calculerDistance(p2d2));
    }
}
