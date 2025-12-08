/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import java.util.Arrays;

/**
 *
 * @author tkossi
 */
public class ParseurCommande {
    public Commande parser(String strCommande) {
        String[] tbCmd = strCommande.trim().split(" ");
        String premierMot = tbCmd[0].toUpperCase();
        Commande commande;
        switch(premierMot) {
            case "EXIT" :
                commande = new CmQuitter();
                break;
            case "HELP" :
                commande = new CmAide();
                break;
            case "ETU" :
                commande = new CmListerEtudiantsParcours();
                break;
            case "PARCOURS-CREER" :
                commande = new CmParcoursCreer();
                break;
            case "PARCOURS-AFFICHER" :
                commande = new CmParcoursAfficher();
                break;
            case "ETUDIANT-CREER" :
                commande = new CmEtudiantCreer();
                break;
            case "ETUDIANT-AFFICHER" :
                commande = new CmEtudiantAfficher();
                break;
            case "ETUDIANT-MODIFIER" :
                commande = new CmEtudiantModifier();
                break;
            case "ETUDIANT-SUPPRIMER" :
                commande = new CmEtudiantSupprimer();
                break;
            case "ET-PC-IN" :
                commande = new CmParcoursInscrireEtudiant();
                break;
            default :
                commande = new CmInconnue();
        }
        if (tbCmd.length > 1){
            String[] parametres = Arrays.copyOfRange(tbCmd, 1, tbCmd.length);
            commande.setParametres(parametres);
        }
        return commande;
    }
}
