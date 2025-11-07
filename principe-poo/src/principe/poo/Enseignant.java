/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principe.poo;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Enseignant extends Personne {
    private String specialite;
    
    public Enseignant(String nom, String prenom) {
        super(nom, prenom);
    }
    
    @Override
    public String getPresentation() {
        return "Je suis l'enseignant " + this.nom + " " + this.prenom;
    }
    
    @Override
    public void sePresenter() {
        
    }
}
