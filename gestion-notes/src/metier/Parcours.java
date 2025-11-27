/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tkossi
 */
public class Parcours {
    private static List<Parcours> liste = new ArrayList<>();
    private static int sequence = 1;
    private int id;
    private String libelle;
    private List<Etudiant> etudiants = new ArrayList<>();
    private List<Etablissement> etablissements = new ArrayList<>();
    private List<UniteEnseignement> uniteEnseignements = new ArrayList<>();
    
    public Parcours() {
        liste.add(this);
    }
    
    public Parcours(int id, String libelle) {
        this();
        this.id = id;
        this.libelle = libelle;
    }
    
    public Parcours(String libelle) {
        this(sequence, libelle);
        sequence = sequence + 1;
    }

    public static Parcours getByLibelle(String libelle) {
        if(libelle == null) return null;
        for (Parcours p : liste) {
            if (p.libelle != null && p.libelle.equalsIgnoreCase(libelle)) {
                return p;
            }
        }
        return null;
    }
    
    public static String getHeader(){
        return "N° \t Identifiant \t Libelle";
    }
    
    public static void afficherTout(){
        int i = 1;
        System.out.println(getHeader());
        for(Parcours p : liste){
            System.out.println(i + "\t" + p.id + "\t\t" + p.libelle);
            i++;
        }
    }
    
    public void inscrireEtudiant(Etudiant etudiant){
        etudiant.setParcours(this);
        this.etudiants.add(etudiant);
    }

    public void desinscrireEtudiant(Etudiant etudiant) {
        if (etudiant == null) return;
        if (this.etudiants.remove(etudiant)) {
            etudiant.setParcours(null);
        }
    }
    
    public void afficher(){
        System.out.println(this);
    }
    
    public void afficherEtudiant(){
        int i = 1;
        System.out.println(Etudiant.getHeader());
        for(Etudiant etudiant : this.etudiants){
            System.out.println(i + "\t" + etudiant.getnumeroCarte() + "\t\t\t" +etudiant.getNom() + "\t" +
                    etudiant.getPrenom() + "\t\t\t" + etudiant.getDateNaissance());
            i++;
        }
    }
    
    public String getLibelle (){
        return this.libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public static List<Parcours> getListe(){
        return liste;
    }
    
    public List<Etudiant> getEtudiants (){
        return this.etudiants;
    }
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    
    public List<Etablissement> getEtablissements (){
        return this.etablissements;
    }
    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }
    
    public List<UniteEnseignement> getUniteEnseignements (){
        return this.uniteEnseignements;
    }
    public void setUniteEnseignements(List<UniteEnseignement> uniteEnseignements) {
        this.uniteEnseignements = uniteEnseignements;
    }
    
    public void presenterEtablissement() {
        System.out.print(this.libelle + " --> Etablissements : ");
        for (Etablissement etablissement : etablissements) {
            System.out.print(etablissement.getLibelle() + "  ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.libelle;
    }
    
}
