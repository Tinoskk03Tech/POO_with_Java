/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

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
            case "MKDIR" :
                commande = new CmMKDIR();
                break;
            case "TOUCH" :
                commande = new CmTouch();
                break;
            case "LS" :
                commande = new CmLS();
                break;
            case "EXISTEF" :
                commande = new CmExisteFichier();
                break;
            case "EXISTER" :
                commande = new CmExisteRepertoire();
                break;
            case "CD" :
                commande = new CmCD();
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
