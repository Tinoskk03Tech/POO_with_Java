/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public abstract class Fichier implements Serializable {
    @Serial
    private static final long serialVersionUID = 15624876235145L;
    private static Repertoire root = new Repertoire("Root", null);
    public static final String chemin = "/home/tkossi/MEGA/serialisation/gestion_fichier.ser";
    private LocalDateTime dateCreation;
    private String nom;
    private Repertoire repertoireParent;
    
    public Fichier() {
        this.dateCreation = LocalDateTime.now();
    }
    
    public Fichier(String nom) {
        this();
        this.nom = nom;
    }
    
    public Fichier(String nom, Repertoire repertoireParent) {
        this(nom);
        this.repertoireParent = repertoireParent;
        if (repertoireParent != null) {
            this.repertoireParent.getFichier().add(this);
        }
    }
    
    public static void sauvegarder() throws Exception {
        FileOutputStream fichier = new FileOutputStream(Fichier.chemin);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
        objectOutputStream.writeObject(root);
        objectOutputStream.flush();
    }
    
    public static void restaurer() {
        try {
            FileInputStream fichier = new FileInputStream(Fichier.chemin);
            ObjectInputStream objectInputStream = new ObjectInputStream(fichier);
            root = (Repertoire) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            root = new Repertoire("Root", null);
        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
    }
    
    public static Repertoire getRoot() {
        return root;
    }
    
    public abstract int getTaille();
    
    public abstract boolean estRepertoire();
    
    public String getNomComplet() {
        if (this.getRepertoireParent() == null) {
            return this.getNom();
        }
        return this.getRepertoireParent().getNomComplet() + "/" + this.nom;
    }
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Repertoire getRepertoireParent() {
        return this.repertoireParent;
    }
    
    public void copierFichier(FichierSimple src, String destNom) {
        FichierSimple fCopie = new FichierSimple(destNom, (Repertoire) this);
        fCopie.setContenu(src.getContenu());
    }

    public void copierRepertoire(Repertoire src, String destNom) {
        Repertoire nouveauRep = new Repertoire(destNom, (Repertoire) this);
        for (Fichier f : src.getFichier()) {
            if (f.estRepertoire()) {
                nouveauRep.copierRepertoire((Repertoire) f, f.getNom());
            } else {
                nouveauRep.copierFichier((FichierSimple) f, f.getNom());
            }
        }
    }
    
}
