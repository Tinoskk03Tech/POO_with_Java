/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tkossi
 */
public class Repertoire extends Fichier {
    private List<Fichier> fichiers = new ArrayList<>();
    
    public Repertoire() {
        
    }
    
    public Repertoire(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }

    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier fichier : fichiers) {
            taille += fichier.getTaille();
        }
        return taille;                                                          
    }
    
    public List<Fichier> getFichier() {
        return this.fichiers;
    }
    
}
