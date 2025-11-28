/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import java.time.LocalDateTime;

/**
 *
 * @author tkossi
 */
public abstract class Fichier {
    private LocalDateTime dateCreation;
    private String nom;
    private Repertoire repertoireParent;
    
    
    public abstract int getTaille();
    public String getNomComplet() {
        if (repertoireParent == null) {
            return this.nom;
        }
        return repertoireParent.getNomComplet() + "/" + this.nom;
    }
}
