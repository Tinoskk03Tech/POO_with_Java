/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.FichierSimple;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;

/**
 *
 * @author Kossivi Tinè KOSSI
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
        throw new FileNotFoundException("Répertoire '" + nom + "' non trouvé dans '" + this.repertoireCourant.getNomComplet() + "'");
    }

    public void lsChemin(String nom) throws FileAlreadyExistsException {
        try {
            String[] cheminCible = nom.split("/");
            String fichierCible = cheminCible[cheminCible.length - 1];
            Repertoire repCourant = this.getRepertoireCourant();
            if (cheminCible.length > 1) {
                String[] restef = Arrays.copyOf(cheminCible, cheminCible.length - 1);
                String repertoireCible = String.join("/", restef);
                this.changerRepertoire(repertoireCible);
                Repertoire repertoireCibles = this.getRepertoireCourant();
                if ("..".equals(fichierCible)) {
                    repertoireCibles.getRepertoireParent().afficherContenu();
                    System.out.println("");
                    this.setRepertoireCourant(repCourant);
                    return;
                } else if (!repertoireCourant.existeFichierSimple(fichierCible) && !repertoireCourant.existeRepertoire(fichierCible)) {
                    System.out.println("Erreur : '" + fichierCible + "' non trouve dans '" + repertoireCibles.getNomComplet() + "'");
                    this.setRepertoireCourant(repCourant);
                    return;
                }
                Fichier temp = repertoireCibles.getFichierParNom(fichierCible);
                if (temp.estRepertoire()) {
                    this.getRepertoireCourant().afficherContenuR((Repertoire) temp);
                }
            } else if ("..".equals(fichierCible)) {
                if (repCourant.getRepertoireParent() == null) {
                    System.out.println("Aucun repertoire parent trouve; vous etes deja dans '" + repCourant.getNomComplet() + "'");
                } else {
                    repCourant.getRepertoireParent().afficherContenu();
                    System.out.println("");
                    this.setRepertoireCourant(repCourant);
                }
                return;
            } else if (!repertoireCourant.existeFichierSimple(fichierCible) && !repertoireCourant.existeRepertoire(fichierCible)) {
                System.out.println("Erreur : '" + fichierCible + "' non trouve dans '" + repCourant.getNomComplet() + "'");
                return;
            } else {
                Fichier temps = repCourant.getFichierParNom(fichierCible);
                this.getRepertoireCourant().afficherContenuR((Repertoire) temps);
            }
            System.out.println("");
            this.setRepertoireCourant(repCourant);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void copier_deplacerFichier(String source, String destination, boolean depCop) throws FileNotFoundException {
        String[] cheminSource = source.split("/");
        String fichierSource = cheminSource[cheminSource.length - 1];
        String repertoireSource = "";
        if (cheminSource.length > 1) {
            String[] restef = Arrays.copyOf(cheminSource, cheminSource.length - 1);
            repertoireSource = String.join("/", restef);
        }
        Repertoire repCourant = this.getRepertoireCourant();
        if (fichierSource == null) {
            System.out.println("Erreur : fichier source requises");
            return;
        }
        if (!repertoireSource.isEmpty()) {
            this.changerRepertoire(repertoireSource);
        }
        Repertoire repertoireSources = this.getRepertoireCourant();
        Fichier src = repertoireSources.getFichierParNom(fichierSource);
        if (src == null) {
            System.out.println("Erreur : '" + fichierSource + "' introuvable dans '" + repertoireSources.getNomComplet() + "'");
            this.setRepertoireCourant(repCourant);
            return;
        }
        this.setRepertoireCourant(repCourant);
        if (destination == null) {
            try {
                repCourant.existeDeja(fichierSource);
            } catch (FileAlreadyExistsException e) {
                this.setRepertoireCourant(repCourant);
                System.out.println("Erreur : " + e.getMessage());
                return;
            }
            if (depCop) {
                if (src.estRepertoire()) {
                    repCourant.copierRepertoire((Repertoire) src, fichierSource);
                } else {
                    repCourant.copierFichier((FichierSimple) src, fichierSource);
                }
                this.setRepertoireCourant(repCourant);
            } else {
                if (src.estRepertoire()) {
                    repCourant.copierRepertoire((Repertoire) src, fichierSource);
                    repertoireSources.supprimerFichier(fichierSource);
                } else {
                    repCourant.copierFichier((FichierSimple) src, fichierSource);
                    repertoireSources.supprimerFichier(fichierSource);
                }
            }
        } else {
            this.changerRepertoire(destination);
            Repertoire repertoireDest = this.getRepertoireCourant();
            try {
                repertoireDest.existeDeja(fichierSource);
            } catch (FileAlreadyExistsException e) {
                this.setRepertoireCourant(repCourant);
                System.out.println("Erreur : " + e.getMessage());
                return;
            }
            if (depCop) {
                if (src.estRepertoire()) {
                    repertoireDest.copierRepertoire((Repertoire) src, fichierSource);
                } else {
                    repertoireDest.copierFichier((FichierSimple) src, fichierSource);
                }
                this.setRepertoireCourant(repCourant);
            } else {
                if (src.estRepertoire()) {
                    repertoireDest.copierRepertoire((Repertoire) src, fichierSource);
                    repertoireSources.supprimerFichier(fichierSource);
                } else {
                    repertoireDest.copierFichier((FichierSimple) src, fichierSource);
                    repertoireSources.supprimerFichier(fichierSource);
                }
                this.setRepertoireCourant(repCourant);
            }
        }
    } // copierFichier

    public void suppressionFichier(String cible) throws FileNotFoundException {
        Repertoire repCourant = this.getRepertoireCourant();
        String[] cheminCible = cible.split("/");
        String fichierCible = cheminCible[cheminCible.length - 1];
        String repertoireCible = "";
        if (cheminCible.length > 1) {
            String[] restef = Arrays.copyOf(cheminCible, cheminCible.length - 1);
            repertoireCible = String.join("/", restef);
        }
        if (!repertoireCible.isEmpty()) {
            this.changerRepertoire(repertoireCible);
        }
        Repertoire repertoireCibles = this.getRepertoireCourant();
        try {
            repertoireCibles.nExiste(fichierCible);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Erreur : " + e.getMessage());
            this.setRepertoireCourant(repCourant);
            return;
        }
        this.setRepertoireCourant(repCourant);
        repertoireCibles.supprimerFichier(fichierCible);
    } // suppressionFichier(String cible)
}
