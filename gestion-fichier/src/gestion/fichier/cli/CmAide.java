/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class CmAide extends Commande {

    @Override
    public void executer() {
        System.out.println("EXIT ~ exit : quitter le programme");
        System.out.println("HELP ~ help : aide");
        System.out.println("LS ~ ls : Afficher le contenu des repertoire");
        System.out.println("CD ~ cd : Naviguer entre les repertoire");
        System.out.println("CP ~ cp : Copier un fichier, un repertoire avec tout son contenu");
        System.out.println("MV ~ mv : deplace un fichier, repertoire vers un autre emplacement");
        System.out.println("RM ~ rm : supprimer un fichier, repertoire avec tout son contenu");
    }

    @Override
    public void setParametres(String[] parametres) {
        
    }
    
}