/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automobile;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Automobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Appel des methodes Voiture
        // Déclaration de voiture1 avec constructeur par Défaut
        Voiture voiture1 = new Voiture();
        
        // Déclaration de voiture2 avec constructeur parametrés
        Voiture voiture2 = new Voiture("Tesla", "THQ-2025", "Verte", 5469743, 5);
        
        // Déclaration de voiture3 avec le constructeur copie
        Voiture voiture3 = voiture2;
        
        // Appel de la methode afficher pour afficher les trois voitures
        voiture1.afficher();
        voiture2.afficher();
        voiture3.afficher();
        
        // Modifier la couleur voiture3
        voiture3.setCouleur("Rouge");
        
        voiture3.afficher();
        
        // Déclaration de voiture4
        Voiture voiture4 = voiture3;
        
        System.out.println(voiture4.getNumeroDeChassis() == voiture3.getNumeroDeChassis());
        System.out.println(voiture4.estEgal(voiture4, voiture3));
        // Conclusion : La methode estEgal compare la voiture dans sa totalité avec les autres variables alors que
        // le comparrateur == permet de comparer le numeroDeChassis seul
    }
    
}
