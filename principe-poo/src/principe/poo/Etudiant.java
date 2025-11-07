package principe.poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Etudiant extends Personne {
    private String numeroCarte;
    
    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
    }
    
    @Override
    public String getPresentation() {
        return "Je suis l'etudiant " + this.nom + " " + this.prenom;
    }
    
    public void sePresenter() {
        
    }
}
