/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principe.poo;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personne etudiant1 = new Etudiant("KOSSI", "Kossivi");
        etudiant1.setAge(-17);
        System.out.println(etudiant1.getPresentation());
        
        Personne prof1 = new Enseignant("ANAKPA", "Manawa");
        prof1.setAge(42);
        System.out.println(prof1.getPresentation());
        
        //Personne personne1 = new Personne("KOFFI", "Abra");
        //personne1.setAge(17);
        //System.out.println(personne1);
    }
    
}
