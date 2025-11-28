/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

/**
 *
 * @author tkossi
 */
public class FichierSimple extends Fichier {
    private String donnee;

    @Override
    public int getTaille() {
        return donnee.length();
    }
    
    
}
