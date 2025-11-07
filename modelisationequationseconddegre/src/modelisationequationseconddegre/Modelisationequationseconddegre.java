/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelisationequationseconddegre;

/**
 *
 * @author Kossivi Tinè KOSSI
 */
public class Modelisationequationseconddegre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EquationSecondDegre eq1 = new EquationSecondDegre(1, -3, 2);  // x² - 3x + 2 = 0
        eq1.afficher();
        eq1.resoudre();

        EquationSecondDegre eq2 = new EquationSecondDegre(1, 2, 5); // pas de solution réelle
        eq2.afficher();
        eq2.resoudre();
    }
    
}
