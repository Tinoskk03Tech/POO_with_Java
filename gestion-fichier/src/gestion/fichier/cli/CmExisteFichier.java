/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmExisteFichier extends Commande {
    private String nom;
    
    @Override
    public void executer() {
        if (Navigateur.getInstance().getRepertoireCourant().existeFichierSimple(nom)) {
            System.out.println("Le fichier " + this.nom + " existe");
        } else {
            System.out.println("Le fichier " + this.nom + " n'existe pas");
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
}
