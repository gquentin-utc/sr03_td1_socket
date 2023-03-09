package fr.utc.sr03;

import java.util.Scanner;

public class Ex0 {
    public static void main( String[] args ) {
        int[] tab = new int[3];

        for (int i = 0; i < tab.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez un nombre : ");
            tab[i] = sc.nextInt();
        }

        System.out.println("Contenu du tableau : ");
        for (int n : tab) {
            System.out.println(n);
        }
        System.out.println("Le plus grand nombre est : " + max(tab));
        System.out.println("Le plus petit nombre est : " + min(tab));
        System.out.println("La moyenne est : " + average(tab));
        System.out.println("L'écart type est : " + stdDeviation(tab));
    }

    private static int max(int[] tab) {
        int max = tab[0];
        for (int n : tab) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    private static int min(int[] tab) {
        int min = tab[0];
        for (int n : tab) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    private static double average(int[] tab) {
        double sum = 0;
        for (int n : tab) {
            sum += n;
        }
        return sum / tab.length;
    }

    private static double stdDeviation(int[] tab) {
        double avg = average(tab);
        double sum = 0;
        for (int n : tab) {
            sum += Math.pow(n - avg, 2);
        }
        return Math.sqrt(sum / tab.length);
    }
}
