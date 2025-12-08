/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import java.lang.reflect.Array;
import java.util.Arrays;
import metier.Parcours;

/**
 *
 * @author tkossi
 */
public class CmParcoursCreer extends Commande {
    private String libelle;
    
    @Override
    public void executer() {
        if(this.libelle != null){
            new Parcours(this.libelle);
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.libelle = parametres[0];
    }
    
}
