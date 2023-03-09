package fr.utc.sr03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Math.floor;

/**
 * @author imineyou
 */
public class Ex6AllumetteServer {
    public static void main(String[] args) {
        int nb_compte=0;
        int nb_max_d=0; /*nbre d'allumettes maxi au départ*/
        int nb_allu_max=0; /*nbre d'allumettes maxi que l'on peut tirer au maxi*/
        int qui=0; /*qui joue? 0=Nous --- 1=PC*/
        int prise=0; /*nbre d'allumettes prises par le joueur*/
        int nb_allu_rest=0; /*nbre d'allumettes restantes*/

        try {
            ServerSocket server=new ServerSocket(7000);
            System.out.println("Serveur à l'écoute ......");
            Socket  client=server.accept();
            System.out.println(" nouveau client ...");


            DataInputStream ins=new DataInputStream(client.getInputStream());
            String []info_client=ins.readUTF().split("/");
            System.out.println("info client"+info_client[0]);
            nb_allu_max=Integer.parseInt(info_client[0]);
            nb_max_d=Integer.parseInt(info_client[1]);
            qui=Integer.parseInt(info_client[2]);
            nb_allu_rest=nb_max_d;
            DataOutputStream outs=new DataOutputStream(client.getOutputStream());
            do
            {
                System.out.println ("\nNombre d'allumettes restantes :"+nb_allu_rest);
                if (qui==0)
                {
                    prise=ins.readInt();
                    System.out.println("prise reçuu .."+prise);
                }
                else
                {

                    prise = jeu_ordi (nb_allu_rest , nb_allu_max);
                    outs.writeInt(prise);
                    outs.flush();
                    System.out.println ("\nPrise de l'ordi :"+prise);
                }
                qui=(qui+1)%2;

                nb_allu_rest= nb_allu_rest - prise;
            }
            while (nb_allu_rest >0);
        } catch (IOException ex) {
            System.err.println("client deconnecté ...");
        }
    }

    public static int jeu_ordi(int nb_allum, int prise_max) {
        int prise = 0;
        int s = 0;
        float t = 0;
        s = prise_max + 1;
        t = ((float) (nb_allum - s)) / (prise_max + 1);
        while (t != floor(t)) {
            s--;
            t = ((float) (nb_allum - s)) / (prise_max + 1);
        }
        prise = s - 1;
        if (prise == 0)
            prise = 1;
        return (prise);
    }
}
