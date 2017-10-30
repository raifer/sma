package automate;

import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;

/**
 * @author Picardv Mathieu
 *
 */

public class AutomateSimulator<Automate extends AutomateCellulaire> implements Simulable {

    protected  Automate notreAutomate;
    protected GUISimulator gui;
    

    public AutomateSimulator(Automate automate, GUISimulator gui){
        this.notreAutomate = automate;
        this.gui = gui;
        this.drawAutomate();
    }
    
    /**
     * Dessine les cellules dans notre afficheur graphique
     */
    protected void drawAutomate(){
        gui.reset();
        for (int i=0; i< this.notreAutomate.getNbColonnes(); i++){
        	//on parcourt les Colonnes de la grille
        	for (int j=0; j< this.notreAutomate.getNbLignes(); j++){
        		//on parcourt les Lignes de la grille
        		Cellule c = this.notreAutomate.getCellule(i,j);
        		gui.addGraphicalElement(
        				new Rectangle((c.getXInt())*20,(c.getYInt())*20,
        						Color.black,
        						c.getCouleur(),
		                            20, 20));
        	}
        }
    }

    /**
     * Mise à jour des cellule après un pas
     * puis affichage
     */
    @Override
    public void next() {
        this.notreAutomate.majAutomate();
        this.drawAutomate();
    }

    	/**
    	 * Réinitialisation des cellules
    	 * puis affichage
    	 */
    @Override
    public void restart() {
        this.notreAutomate.reInit();
        this.drawAutomate();
    }
}

