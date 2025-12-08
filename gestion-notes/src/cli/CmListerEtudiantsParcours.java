/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Parcours;

/**
 *
 * @author tkossi
 */
public class CmListerEtudiantsParcours extends Commande {
    private int indice = 0;
    private String libelle;

    @Override
    public void executer() {
        Parcours p = null;
        p = Parcours.getByLibelle(libelle);
        if (indice > 0) {
            p = Parcours.getListe().get(indice - 1);
        } else if (libelle != null && !libelle.isEmpty()) {
            p = Parcours.getByLibelle(libelle);
        } else {
            Parcours.afficherTout();
        }
        if (p != null) {
            p.afficher();
            p.afficherEtudiant();
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        try {
            this.indice = Integer.parseInt(parametres[0]);
        } catch (NumberFormatException ex) {
            this.libelle = parametres[0];
        }
    }
    
}
