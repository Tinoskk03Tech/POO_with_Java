/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmExisteRepertoire extends Commande {
    private String nom;
    
    @Override
    public void executer() {
        if (Navigateur.getInstance().getRepertoireCourant().existeRepertoire(nom)) {
            System.out.println("Le repertoire " + this.nom + " existe");
        } else {
            System.out.println("Le repertoire " + this.nom + " n'existe pas");
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.nom = parametres[0];
    }
}
