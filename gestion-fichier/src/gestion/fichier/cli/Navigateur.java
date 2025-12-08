/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author tkossi
 */
public class Navigateur {

    private static Navigateur instance;
    private Repertoire repertoireCourant;

    static {
        instance = new Navigateur();
    }

    private Navigateur() {

    }

    public static Navigateur getInstance() {
        return instance;
    }

    public Repertoire getRepertoireCourant() {
        return this.repertoireCourant;
    }

    public void setRepertoireCourant(Repertoire repertoireCourant) {
        this.repertoireCourant = repertoireCourant;
    }

    public void changerRepertoire(String nom) throws FileNotFoundException {
        if (nom == null) {
            return;
        }
        String[] nomsRepertoire = nom.split("/");
        Repertoire r = this.repertoireCourant;
        try {
            this.changerRepertoire(nomsRepertoire);
        } catch (FileNotFoundException e) {
            this.repertoireCourant = r;
            throw e;
        }
    }

    public void changerRepertoire(String[] nomsRepertoire) throws FileNotFoundException {
        for (String nomRepertoire : nomsRepertoire) {
            if (nomRepertoire.equals("..") && this.repertoireCourant.getRepertoireParent() != null) {
                this.repertoireCourant = this.repertoireCourant.getRepertoireParent();
                continue;
            }
            this.repertoireCourant = this.repertoireCourant.getRepertoire(nomRepertoire);
        }
    }

    public Repertoire getRepertoireParNom(String nom) throws FileNotFoundException {
        if (this.repertoireCourant.existeRepertoire(nom)) {
            return this.repertoireCourant.getRepertoire(nom);
        }
        throw new FileNotFoundException("Répertoire '" + nom + "' non trouvé dans " + this.repertoireCourant.getNomComplet());
    }
}
