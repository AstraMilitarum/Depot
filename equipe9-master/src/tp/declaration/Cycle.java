/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.declaration;

/**
 *
 * @author Luc
 */
public abstract class Cycle {
    /**
     * Retourne une instance de sous-classe de Cycle correspondant
     * à l'identifiant du cycle. Seul le cycle "2012-2014" est supporté
     * pour l'instant.
     * @param nomCycle nom du cycle en format <a-b> où (a) est l'année
     * de début du cycle, et (b) est l'année de fin du cycle.
     * @return une instance de sous-classe de la classe Cycle
     * @throws Exception 
     */
    public static final Cycle getCycleCorrespondant(String nomCycle) throws Exception {
        Cycle cycle = null;
        if (nomCycle.equals("2012-2014")) {
            cycle = new Cycle2012_2014();
        } else {
            throw new Exception("Cycle " + nomCycle + " n'est pas supporté.");
        }
        return cycle;
    }
    
    /**
     * Effectue la validation des données contenues dans une instance de
     * la classe Declaration. Comme les règles de validation peuvent différer
     * d'un cycle à l'autre, la sous-classe de Cycle doit implémenter cette
     * méthode.
     * @param declaration La déclaration à valider.
     * @throws Exception 
     */
    public abstract void validerDeclaration(Declaration declaration);
}
