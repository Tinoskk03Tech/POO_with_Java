/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principe.poo;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected int age;
    
    // Methode abstraite
    public abstract void sePresenter();
    
    public String getPresentation() {
        return this.nom + " " + this.prenom;
    }
    
    // Constructeurs
    public Personne() {
        System.out.println("Je suis appelé");
    }
    
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age<0) {
            System.out.println("L'age est invalide");
        }else{
            this.age = age;
        }
    }
    
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom(String prenom) {
        return this.prenom;
    }
    public void setPrenom() {
        this.prenom = prenom;
    }
    
    @Override
    public String toString() {
        return "Nom : "+ this.nom +", prenom : "+ this.prenom +", age : "+ this.age;
    }
}
