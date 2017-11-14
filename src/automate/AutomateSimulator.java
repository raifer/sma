package automate;
import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;


/**
 * Classe mère pour simuller les trois automate.
 *
 * @param <Automate>
 */
public class AutomateSimulator<Automate extends AutomateCellulaire> implements Simulable {

    protected  Automate notreAutomate;
    protected GUISimulator gui;
    
    private int sizeCell;
    
    /**
     * Constructeur
     * @param automate Automate variable en fonction du jeu choisi
     * @param gui Interface graphique
     */
    public AutomateSimulator(Automate automate, GUISimulator gui){
        this.notreAutomate = automate;
        this.gui = gui;
        this.sizeCell=Math.min(gui.getPanelHeight(),gui.getPanelWidth())/
    			Math.max(this.notreAutomate.getNbLignes(), this.notreAutomate.getNbColonnes());
        System.out.println(""+this.sizeCell);
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
	                    new Rectangle(((c.getXInt())*this.sizeCell)+(this.sizeCell/2),((c.getYInt())*this.sizeCell)+(this.sizeCell/2), 
	                            Color.black, c.getCouleur(), 
	                            this.sizeCell, this.sizeCell));
        	}
        }
    }

    /**
     * Mise à jour des cellule après un pas puis affichage
     */
    @Override
    public void next() {
        this.notreAutomate.majAutomate();
        this.drawAutomate();
    }

    /**
    * Réinitialisation des cellules puis affichage
    */
    @Override
    public void restart() {
        this.notreAutomate.reInit();
        this.drawAutomate();
    }
}

