/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automobile;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Voiture {
    private static int compteur = 1;
    // Déclaration des variables en privées
    private int nombreVoiture;
    private String marque;
    private String modele;  
    private String couleur;  
    private double numeroDeChassis;  
    private int nombreDePlaces;
    
    // Déclaration du constructeur par défaut
    public Voiture () {
        this.nombreVoiture = compteur;
        compteur++;
    }
    
    // Déclaration du constructeur avec paramètre
    public Voiture (String marque, String modele, String couleur, double numeroDeChassis, int nombreDePlaces) {
        this();
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.numeroDeChassis = numeroDeChassis;
        this.nombreDePlaces = nombreDePlaces;
    }
    
    // Declaration du constructeur de copie
    public Voiture (Voiture voiture) {
        this();
        this.marque = voiture.marque;
        this.modele = voiture.modele;
        this.couleur = voiture.couleur;
        this.numeroDeChassis = voiture.numeroDeChassis;
        this.nombreDePlaces = voiture.nombreDePlaces;
    }
    
    // Accesseur
    public int getNombreVoiture () {
        return nombreVoiture;
    }
    public void setNombreVoiture (int nombreVoiture) {
        this.nombreVoiture = nombreVoiture;
    }
    
    public String getMarque () {
        return marque;
    }
    public void setMarque (String marque) {
        this.marque = marque;
    }
    
    public String getModele () {
        return modele;
    }
    public void setModele (String modele) {
        this.modele = modele;
    }
    
    public String getCouleur () {
        return couleur;
    }
    public void setCouleur (String couleur) {
        this.couleur = couleur;
    }
    
    public double getNumeroDeChassis () {
        return numeroDeChassis;
    }
    public void setNumeroDeChassis (double numeroDeChassis) {
        this.numeroDeChassis = numeroDeChassis;
    }
    
    public int getNombreDePlace () {
        return nombreDePlaces;
    }
    public void setNombreDePlace (int nombreDePlaces) {
        this.nombreDePlaces = nombreDePlaces;
    }
    
    //
    public boolean estEgal (Voiture voiture1, Voiture voiture2) {
        return voiture1.equals(voiture2);
    }
    
    // Déclaration de la méthode afficher
    public void afficher () {
        System.out.println("Voiture Numéro " + this.nombreVoiture + " de marque " + this.marque + " de modèle " +
                this.modele + " de couleur " + this.couleur + ". Numéro de Chassis est " + this.numeroDeChassis + 
                " et de nombre de place " + this.nombreDePlaces + "\n");
    }
}
