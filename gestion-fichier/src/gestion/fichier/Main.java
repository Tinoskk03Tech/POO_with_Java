/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichier;

import gestion.fichier.cli.Commande;
import gestion.fichier.cli.ParseurCommande;
import java.util.Scanner;

/**
 *
 * @author tkossi
 */
public class Main {
    private static Scanner clavier = new Scanner(System.in);
    private static ParseurCommande parseur = new ParseurCommande();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("\nBonjour TinosTechnology ");
        System.out.print("\nTaper votre commande : ");
        while (true) {
            String strCmde = clavier.nextLine();
            Commande commande = parseur.parser(strCmde);
            commande.executer();
        }
    }
    
}
