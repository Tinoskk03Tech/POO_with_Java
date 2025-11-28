/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author tkossi
 */
public class CmMKDIR extends Commande {
    private String nom;

    @Override
    public void executer() {
        Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nom);
    }

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    }
     
}
