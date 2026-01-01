/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmMKDIR extends Commande {
    private String nom;

    @Override
    public void executer() {
        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
        try {
            repertoireCourant.existeDeja(nom);
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nom);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
     
}
