/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Etudiant;

/**
 * Commande pour supprimer un etudiant par numero de carte
 */
public class CmEtudiantSupprimer extends Commande {
    private int numeroCarte;

    @Override
    public void executer() {
        Etudiant.supprimer(this.numeroCarte);
    }

    @Override
    public void setParametres(String[] parametres) {
        if (parametres != null && parametres.length > 0) {
            this.numeroCarte = Integer.parseInt(parametres[0]);
        }
    }
    
}
