/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelisationnombrecomplexes;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Modelisationnombrecomplexes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Complexe z1 = new Complexe(2, 3);
        Complexe z2 = new Complexe(1, -4);

        System.out.print("z1 = "); z1.afficher();
        System.out.print("z2 = "); z2.afficher();

        System.out.print("Conjugué de z1 : "); z1.conjugue().afficher();
        System.out.print("Carré de z1 : "); z1.carre().afficher();
        System.out.println("Module de z1 : " + z1.module());

        System.out.print("z1 + z2 = "); z1.plus(z2).afficher();
        System.out.print("z1 * z2 = "); z1.fois(z2).afficher();

        System.out.println("z1 est égal à z2 ? " + z1.estEgal(z2));
    }
    
}
