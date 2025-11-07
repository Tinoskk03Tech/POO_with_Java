/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelisationnombrecomplexes;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Complexe {
    private double partieReelle;
    private double partieImaginaire;

    // Constructeur
    public Complexe(double partieReelle, double partieImaginaire) {
        this.partieReelle = partieReelle;
        this.partieImaginaire = partieImaginaire;
    }

    // Conjugué
    public Complexe conjugue() {
        return new Complexe(partieReelle, -partieImaginaire);
    }

    // Carré
    public Complexe carre() {
        double re = partieReelle * partieReelle - partieImaginaire * partieImaginaire;
        double im = 2 * partieReelle * partieImaginaire;
        return new Complexe(re, im);
    }

    // Module
    public double module() {
        return Math.sqrt(partieReelle * partieReelle + partieImaginaire * partieImaginaire);
    }

    // Addition
    public Complexe plus(Complexe z) {
        return new Complexe(this.partieReelle + z.partieReelle, this.partieImaginaire + z.partieImaginaire);
    }

    // Multiplication
    public Complexe fois(Complexe z) {
        double re = this.partieReelle * z.partieReelle - this.partieImaginaire * z.partieImaginaire;
        double im = this.partieReelle * z.partieImaginaire + this.partieImaginaire * z.partieReelle;
        return new Complexe(re, im);
    }

    // Comparaison
    public boolean estEgal(Complexe z) {
        return this.partieReelle == z.partieReelle && this.partieImaginaire == z.partieImaginaire;
    }

    // Afficher
    public void afficher() {
        System.out.println(partieReelle + " + " + partieImaginaire + "i");
    }
}
