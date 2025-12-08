/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Etudiant;

/**
 *
 * @author tkossi
 */
public class CmEtudiantAfficher extends Commande {
    private int indice;

    @Override
    public void executer() {
        if (indice != 0){
            Etudiant.afficherindice(indice);
        } else {
            Etudiant.afficherTout();
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.indice = Integer.parseInt(parametres[0]);
    }
    
}
