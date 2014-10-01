/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.declaration;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class Main {
    
    static String[] catReconnues = {"cours", "atelier", "séminaire", "colloque", 
                            "conférence", "lecture dirigée", "présentation", 
                            "groupe de discussion", "projet de recherche", 
                            "rédaction professionnelle"};
    
    public static void main (String[] params) throws FileNotFoundException, IOException, Exception {
//        String fichierTest = FileReader.loadFileIntoString("json/test.json", "UTF-8");
//        JSONObject formation = JSONObject.fromObject(fichierTest);
//        System.out.println("Permis: " + formation.getString("numero_de_permis"));
//        System.out.println("Cycle: " + formation.getString("cycle"));
//        System.out.println("Heures Transferes: " + formation.getInt("heures_transferees_du_cycle_precedent"));
//        System.out.println("Les activités entreprises au courant du cycle: " + "\n");
//        
//        JSONArray activites = formation.getJSONArray("activites");
//        int nbActivites = activites.size();
//        Activite[] listeAct = new Activite[nbActivites];
//        
//            
//        for(int i =0; i<nbActivites; i++) {
//            JSONObject activite = JSONObject.fromObject(activites.get(i));
//            listeAct[i] = new Activite2012_2014(activite);
//        }
//        
//        for(int i = 0; i<nbActivites; i++) {
//            listeAct[i].appliquerReglesLocalesDeValidation(catReconnues);
//            System.out.println(listeAct[i].toString());  
//            System.out.println(listeAct[i].estAcceptee());
//            if (!listeAct[i].estAcceptee()) {
//                int nbrErreurs = listeAct[i].getNombreMessagesErreur();
//                for (int j = 0; j<nbrErreurs; j++) {
//                    System.out.println(listeAct[i].getMessageErreur(j));
//                }
//            }            
//        }
        Declaration d = new Declaration(params[0]);
        d.valider();
        d.genererFichierResultat(params[1]);
    }
    
}
