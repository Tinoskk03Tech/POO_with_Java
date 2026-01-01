/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;


import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmLS extends Commande {
    private String nom;

    @Override
    public void executer() {
        try {
            if (nom != null) {
                Navigateur.getInstance().lsChemin(nom);
            } else {
                Navigateur.getInstance().getRepertoireCourant().afficherContenu();
                System.out.println("");
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println("Erreur  : " + e.getMessage());
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        nom = parametres[0];
    }
     
}
