/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.FileNotFoundException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tkossi
 */
public class Repertoire extends Fichier {
    @Serial
    private static final long serialVersionUID = 64234876235145L;
    private List<Fichier> fichiers = new ArrayList<>();
    
    public Repertoire() {
        
    }
    
    public Repertoire(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }
    
    public void ajouterRepertoire(String nom) {
        new Repertoire(nom, this);
    }
    
    public void ajouterFichierSimple(String nom) {
        new FichierSimple(nom, this);
    }
    
    public void afficherContenu() {
        for (Fichier fichier : fichiers) {
            System.out.print(fichier.getNom() + "\t");
        }
    }

    public void afficherContenuR(Repertoire getRepertoire) {
        List<Fichier> fichiers = getRepertoire.getFichier();
        for (Fichier fichier : fichiers) {
            System.out.print(fichier.getNom() + "\t");
        }
    }

    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier fichier : fichiers) {
            taille += fichier.getTaille();
        }
        return taille;                                                          
    }
    
    @Override
    public boolean estRepertoire() {
        return true;
    }
    
    public boolean existeFichierSimple (String nom) {
        if (nom == null) {
            return false;
        }
        for(Fichier f : fichiers) {
            if(!f.estRepertoire() && f.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existeRepertoire(String nom) {
        if (nom == null) {
            return false;
        }
        for(Fichier f : fichiers) {
            if(f.estRepertoire() && f.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }
    
    public Repertoire getRepertoire(String nom) throws FileNotFoundException {
        for(Fichier f : fichiers) {
            if(f.estRepertoire() && f.getNom().equals(nom)) {
                return (Repertoire) f;
            }
        }
        throw new FileNotFoundException("Repertoire '" + nom + "' non trouvé");
    }
    
    public List<Fichier> getFichier() {
        return this.fichiers;
    }
    
}
