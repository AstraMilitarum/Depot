/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.declaration;

/**
 *
 * @author Seb
 */
public abstract class Activite {
    public abstract String getCategorie();
    public abstract int getHeures();
    public abstract boolean estAcceptee();
    public abstract int getNombreMessagesErreur();
    public abstract String getMessageErreur(int index) throws Exception;
    public abstract void appliquerReglesLocalesDeValidation(String[] actRec);
    public abstract String toString();
    public abstract void ajouterMessageErreur(String message);
   
}
