/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Etudiant;
import metier.Parcours;

/**
 *
 * @author tkossi
 */
public class CmParcoursInscrireEtudiant extends Commande {
    private String libelle;
    private int numeroCarte;

    @Override
    public void executer() {
        Parcours p = Parcours.getByLibelle(this.libelle);
        Etudiant e = Etudiant.getByNumeroCarte(this.numeroCarte);
        p.inscrireEtudiant(e);
    }

    @Override
    public void setParametres(String[] parametres) {
        this.libelle = parametres[0];
        this.numeroCarte = Integer.parseInt(parametres[1]);
    }
    
}
