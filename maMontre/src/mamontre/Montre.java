/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mamontre;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Montre {
    private static int compteur = 1;
    // Variable declaration
    private int numSerie;
    private int annee;
    private int mois;
    private int jour;
    private int heure;
    private int minute;
    private int seconde;
    
    // Default Cronstructor //
    public Montre() {
        this.numSerie = compteur;
        compteur++;
    }
    
    // Constructor
    public Montre(int annee, int mois, int jour, int heure, int minute, int seconde) {
        this();
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
        this.minute = minute;
        this.seconde = seconde;
    }
     // Copie Constructor or recopie Constructor
    public Montre(Montre montre) {
        this();
        this.annee = montre.annee;
        this.mois = montre.mois;
        this.jour = montre.jour;
        this.heure = montre.heure;
        this.minute = montre.minute;
        this.seconde = montre.seconde;
    }
    
    // getter and setter for the year variable
    public int getNumSerie() {
        return this.numSerie;
    }
    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }
    
    // getter and setter for the year variable //// Accesseurs
    public int getAnnee() {
        return this.annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    // getter and setter for the year variable
    public int getMois() {
        return this.mois;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    
    // getter and setter for the jour variable
    public int getjour() {
        return this.jour;
    }
    public void setJour(int jour) {
        this.jour = jour;
    }
    
    // getter and setter for the heure variable
    public int getHeure() {
        return this.heure;
    }
    public void setHeure(int heure) {
        this.heure = heure;
    }
    
    // getter and setter for the minute variable
    public int getMinute() {
        return this.minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    // getter and setter for the seconde variable
    public int getSeconde() {
        return this.seconde;
    }
    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }
    // print date and hour
    public String toString() {
        return this.numSerie + ": " + this.annee + "-" + this.mois + "-" + this.jour + "  " + this.heure + ":" 
                + this.minute + ":" + this.seconde;
    }
}
