package automate;

import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;

/**
 * @author Picardv Mathieu
 *
 */

public class CelluleSimulator<Automate extends AutomateCellulaire> implements Simulable {

    protected  Automate notreAutomate;
    protected GUISimulator gui;
    

    public CelluleSimulator(Automate automate, GUISimulator gui){
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
        		
        		Cellule C = this.notreAutomate.getCellule(i,j);
	            if (C.estVivante()){	
	            	//Si la cellule est vivante, elle sera affichée en bleu
		            gui.addGraphicalElement(
		                    new Rectangle((C.getXInt())*20,(C.getYInt())*20,
		                            Color.decode("#000000"), Color.decode("#1f77b4"), 
		                            20, 20));
	            }
	            else{
	            	//Si la cellule est morte, elle sera affichée en blanc
		            gui.addGraphicalElement(
		                    new Rectangle((C.getXInt())*20,(C.getYInt())*20,
		                            Color.decode("#000000"), Color.decode("#ffffff"), 
		                            20, 20));
	            }
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

