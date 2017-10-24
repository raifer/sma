
import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;

public class CelluleSimulator implements Simulable {

    private JeuDeLaVie notreJeu;
    private GUISimulator gui;
    /**
     * Création des Cellules et placement de celles-ci dans la GUI
     *** 
     * @param gui L'interface où va se dérouller la simulation
     * @author picardv
     */
    public CelluleSimulator(GUISimulator gui){
        this.gui = gui;
        this.notreJeu = new JeuDeLaVie();
        this.drawJDLV();
    }
    
    /**
     * Dessine les cellules dans notre afficheur graphique
     */

    protected void drawJDLV(){
        gui.reset();
        for (int i=0; i< this.notreJeu.getNbColonnes(); i++){
        	//on parcourt les Colonnes de la grille
        	for (int j=0; j< this.notreJeu.getNbLignes(); j++){
        		//on parcourt les Lignes de la grille
        		
        		Cellule C = this.notreJeu.getCellule(i,j);
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
        notreJeu.majJeux();
        this.drawJDLV();
    }

    	/**
    	 * Réinitialisation des cellules
    	 * puis affichage
    	 */
    @Override
    public void restart() {
        //notreJeu.reInit();
        this.drawJDLV();
    }
}

