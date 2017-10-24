
import java.awt.Point;
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
     * @author Valentin
     */
    public CelluleSimulator(GUISimulator gui){
        this.gui = gui;
        this.notreJeu = new JeuDeLaVie();
        this.drawJDLV();
    }

    protected void drawJDLV(){
        gui.reset();
        for (int i=0; i< this.notreJeu.getNbLignes(); i++){
        	//on parcourt les lignes de la grille
        	for (int j=0; j< this.notreJeu.getNbColonnes(); j++){
        		//on parcourt les colonnes de la grille
        		
        		Cellule C = this.notreJeu.getCellule(i,j);
	            if (C.estVivante()){	
	            	//Si la cellule est vivante, elle sera affichée en bleu
		            gui.addGraphicalElement(
		                    new Rectangle((int)C.getX(), (int)C.getY(),
		                            Color.decode("#000000"), Color.decode("#1f77b4"), 
		                            20, 20));
	            }
	            else{
	            	//Si la cellule est morte, elle sera affichée en blanc
		            gui.addGraphicalElement(
		                    new Rectangle((int)C.getX(), (int)C.getY(),
		                            Color.decode("#000000"), Color.decode("#ffffff"), 
		                            20, 20));
	            }
        	}
        }
    }

    @Override
    public void next() {
        /*fonction de mise à jour de la grille*/;
        this.drawJDLV();
    }

    @Override
    public void restart() {
        notreJeu.reInit();
        this.drawJDLV();
    }
}

