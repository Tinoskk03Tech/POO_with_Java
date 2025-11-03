/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mamontre;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Création d'une nouvel montre
        Montre montre1 = new Montre();
        montre1.setAnnee(2025);
        montre1.setMois(10);
        montre1.setJour(30);
        montre1.setHeure(15);
        montre1.setMinute(55);
        montre1.setSeconde(30);
        System.out.println(montre1);
        //montre2 creation
        Montre montre2 = new Montre(2025, 11, 01, 16, 55, 15);
        System.out.println(montre2);
        
        Montre montre3 = new Montre(montre2);
        montre3.setMinute(45);
        System.out.println(montre3);
        
        Montre montre4 = montre2;
        //System.out.println(montre4);
        //montre2.setAnnee(2040);
        //System.out.println(montre4);
        
        System.out.println(montre2.equals(montre3));
        System.out.println(montre2.equals(montre4));
    }
}
