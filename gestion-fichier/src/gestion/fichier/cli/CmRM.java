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
public class CmRM extends Commande {
    private String cible;

    @Override
    public void executer() {

        try {
            if (cible == null) {
              System.out.println("Vous devriez preciser le fichier supprimer");
              return;
            } 
            Navigateur.getInstance().suppressionFichier(cible);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {

        }
    }

    @Override
    public void setParametres(String[] parametres) {
        if (parametres.length >= 1) {
            this.cible = parametres[0];
        }
    }
    
}
