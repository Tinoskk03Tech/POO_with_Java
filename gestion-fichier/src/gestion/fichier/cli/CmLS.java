/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;

/**
 *
 * @author tkossi
 */
public class CmLS extends Commande {
    private Repertoire nom;

    @Override
    public void executer() {
        if (nom != null) {
            try {
                Navigateur.getInstance().getRepertoireCourant().afficherContenuR(nom);
                System.out.println("");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Navigateur.getInstance().getRepertoireCourant().afficherContenu();
            System.out.println("");
        }
        
    }

    @Override
    public void setParametres(String[] parametres) {
        if (parametres.length > 0) {
            try {
                this.nom = Navigateur.getInstance().getRepertoireParNom(parametres[0]);
            } catch (Exception e) {
                System.err.println("Erreur: " + e.getMessage());
                this.nom = null;
            }
        }
    }
     
}
