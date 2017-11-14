
package balls;
import java.awt.Point;

import evenements.EventManager;
import gui.GUISimulator;
import gui.Simulable;
import gui.Oval;
import java.awt.Color;


public class BallsSimulator implements Simulable {

    private Balls nosBalles;
    private GUISimulator gui;
    private EventManager manager;
    
    /**
     * Création des balles et placement de celles-ci dans la GUI
     *** 
     * @param gui L'interface où va se dérouller la simulation
     * @param nbBalls nombre de balles à simuler
     * @manager le gestionnaire d'évènements
     */
    protected BallsSimulator(GUISimulator gui, int nbBalls, EventManager manager){
        this.setGui(gui);
        this.setNosBalles(new Balls(nbBalls));
        this.setManager(manager);//instancier premier evenement
        this.manager.addEvent(new MajBalls(1,this));
        this.drawBalls();
    }
    
        
    /**
     * Ajoute les éléments graphiques correspondant
     * aux balles à l'interfacde de simulation gui
     */
    protected void drawBalls(){
        getGui().reset();
        for (int i=0; i< this.getNosBalles().getNbBalls(); i++){
            Point ball = this.getNosBalles().getBall(i);
            getGui().addGraphicalElement(
                    new Oval((int)ball.getX(), (int)ball.getY(),
                            Color.decode("#1f77b4"), Color.decode("#1f77b4"), 
                            25, 25));
        }
    }

    
    @Override
    public void next() {
    	this.getManager().next();
    }

    @Override
    public void restart() {
        getNosBalles().reInit();
        this.drawBalls();
    }



	public GUISimulator getGui() {
		return gui;
	}



	public void setGui(GUISimulator gui) {
		this.gui = gui;
	}



	public Balls getNosBalles() {
		return nosBalles;
	}



	public void setNosBalles(Balls nosBalles) {
		this.nosBalles = nosBalles;
	}



	public EventManager getManager() {
		return manager;
	}



	public void setManager(EventManager manager) {
		this.manager = manager;
	}
}
