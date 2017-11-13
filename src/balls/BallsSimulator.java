
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
    private EventManager manager = new EventManager();
    
    /**
     * Création des balles et placement de celles-ci dans la GUI
     *** 
     * @param gui L'interface où va se dérouller la simulation
     */
    public BallsSimulator(GUISimulator gui, int nbBalls, EventManager manager){
        this.gui = gui;
        this.nosBalles = new Balls(nbBalls);
        this.manager=manager;
        this.drawBalls();
    }
    
        

    protected void drawBalls(){
        gui.reset();
        for (int i=0; i< this.nosBalles.getNbBalls(); i++){
            Point ball = this.nosBalles.getBall(i);
            gui.addGraphicalElement(
                    new Oval((int)ball.getX(), (int)ball.getY(),
                            Color.decode("#1f77b4"), Color.decode("#1f77b4"), 
                            25, 25));
        }
    }

    @Override
    public void next() {
    	
    	this.manager.next();
    }

    @Override
    public void restart() {
        nosBalles.reInit();
        this.drawBalls();
    }
}
