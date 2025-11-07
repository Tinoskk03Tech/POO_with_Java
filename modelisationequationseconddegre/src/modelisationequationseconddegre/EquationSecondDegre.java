/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelisationequationseconddegre;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class EquationSecondDegre {
    private double a;
    private double b;
    private double c;

    // Constructeur
    public EquationSecondDegre(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Méthode pour afficher l'équation
    public void afficher() {
        System.out.println(a + "x² + " + b + "x + " + c + " = 0");
    }

    // Discriminant Δ = b² - 4ac
    private double getDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    // Vérifie si l'équation a des solutions réelles
    private boolean admetSolution() {
        return getDiscriminant() >= 0;
    }
    
    // Résoudre l'équation
    public void resoudre() {
        double delta = getDiscriminant();
        System.out.println("Discriminant = " + delta);

        if (delta < 0) {
            System.out.println("Pas de solution réelle.");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Une seule solution : x = " + x);
        } else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println("Deux solutions : x1 = " + x1 + " et x2 = " + x2);
        }
    }
}
