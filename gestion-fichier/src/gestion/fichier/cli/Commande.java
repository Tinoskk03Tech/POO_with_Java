/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author tkossi
 */
public abstract class Commande {
    public abstract void executer();
    public abstract void setPararmetres(String[] parametres);
}
