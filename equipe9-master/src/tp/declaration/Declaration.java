 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.declaration;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Simon
 */
public class Declaration {

    private boolean complet = false;
    private String NumeroPermis;
    private String nomCycle;
    private int heuresTransfereesCyclePrecedent;
    private Cycle cycle;
    private ArrayList<Activite> activites;
    private ArrayList<String> erreurs;
    private ArrayList<Activite> activitesReconnues;
    private ArrayList<Activite> activitesIgnorees;
    private JSONObject json;

    public Declaration(String jsonFile) throws FileNotFoundException, IOException, Exception {
        String JSONInfo = FileReader.loadFileIntoString(jsonFile, "UTF-8");
        json = JSONObject.fromObject(JSONInfo);

        nomCycle = json.get("cycle").toString();
        NumeroPermis = json.get("numero_de_permis").toString();
        heuresTransfereesCyclePrecedent = Integer.parseInt(json.get("heures_transferees_du_cycle_precedent").toString());
        activitesReconnues = new ArrayList<>();
        activitesIgnorees = new ArrayList<>();
        activites = new ArrayList<>();
        try {
            cycle = Cycle.getCycleCorrespondant(nomCycle);
        } catch (Exception ex) {
            erreurs.add(ex.getMessage());
        }
    }

    public boolean estComplet() {
        return complet;
    }

    public void setComplet(boolean complet) {
        this.complet = complet;
    }

    public int getNombreActivites() {
        return activites.size();
    }

    public JSONObject getActivite(int index) {
        JSONArray cours = JSONArray.fromObject(json.get("activites"));
        return cours.getJSONObject(index);
    }

    public void ajouterActiviteReconnue(Activite activite) {
        activitesReconnues.add(activite);
    }

    public void ajouterActiviteIgnoree(Activite activite) {
        activitesIgnorees.add(activite);
    }

    public Activite getActiviteReconnue(int index) {
        return activitesReconnues.get(index);
    }

    public Activite getActiviteIgnoree(int index) {
        return activitesIgnorees.get(index);
    }

    public int getNombreActivitesReconnues() {
        return activitesReconnues.size();
    }

    public int getNombreActivitesIgnorees() {
        return activitesIgnorees.size();
    }

    public void setHeuresTransfereesDuCyclePrecedent(int heures) {
        heuresTransfereesCyclePrecedent = heures;
    }

    public int getHeuresTransfereesDuCyclePrecedent() {
        return heuresTransfereesCyclePrecedent;
    }

    public void ajouterMessageErreur(String message) {
        erreurs.add(message);
    }

    public void valider() {
        cycle.validerDeclaration(this);
    }

    public void initialiserErreurs() {
        erreurs = new ArrayList<>();
    }

    public void genererFichierResultat(String JsonFichier) {
        JSONArray jsonerreurs = new JSONArray();
        JSONObject jsonsortie = new JSONObject();
        
        for (int i = 0; i < erreurs.size(); i++)
        {
           jsonerreurs.add(erreurs.get(i));
        }
        
        jsonsortie.put("complet", complet);
        jsonsortie.put("erreurs", jsonerreurs);
        try {
        FileWriter sortie = new FileWriter(JsonFichier);
        sortie.write(jsonsortie.toString(2));
        sortie.flush();
        sortie.close();
        }
        catch (Exception e) {}
        
    }

}
