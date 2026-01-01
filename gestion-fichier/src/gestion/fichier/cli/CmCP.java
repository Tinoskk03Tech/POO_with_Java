/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import java.io.FileNotFoundException;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmCP extends Commande {
    private String source;
    private String destination;

    @Override
    public void executer() {
        try {
            Navigateur.getInstance().copier_deplacerFichier(source, destination, true);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        if(parametres.length >= 2){
            this.source = parametres[0];
            this.destination = parametres[1];
        } else {
            this.source = parametres[0];
        }
    }
    
}
