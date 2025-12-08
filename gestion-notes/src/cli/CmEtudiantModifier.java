/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import java.time.LocalDate;
import metier.Etudiant;

/**
 * Commande pour modifier un etudiant existant
 * Syntaxe: ETUDIANT-MODIFIER {numeroCarte} {nom} {prenom} {dateNaissance}
 */
public class CmEtudiantModifier extends Commande {
    private int numeroCarte;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    @Override
    public void executer() {
        Etudiant e = Etudiant.getByNumeroCarte(this.numeroCarte);
        if (e == null) {
            return ;
        }
        if (this.nom != null){
            e.setNom(this.nom);
        }
        if (this.prenom != null){
            e.setPrenom(this.prenom);
        }
        if (this.dateNaissance != null){
            e.setDateNaissance(this.dateNaissance);
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.numeroCarte = Integer.parseInt(parametres[0]);
        this.nom = parametres[1];
        this.prenom = parametres[2];
        this.dateNaissance = LocalDate.parse(parametres[3]);
    }
    
}
