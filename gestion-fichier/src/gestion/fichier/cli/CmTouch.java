/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;


/**
 *
 * @author tkossi
 */
public class CmTouch extends Commande {
    private String nom;

    @Override
    public void executer() {
        if (!Navigateur.getInstance().getRepertoireCourant().existeFichierSimple(nom)) {
            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nom);
        } else {
            System.out.println("Le fichier existe déjà.");
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
     
}
