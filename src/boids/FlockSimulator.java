package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Oval;
import java.awt.Color;

import evenements.EventManager;



public class FlockSimulator implements Simulable {
	protected Flock flock;

	protected GUISimulator gui;
	protected EventManager manager;

	private int height;
	private int width;
	
	public FlockSimulator(GUISimulator gui, EventManager manager){
		this(gui, 20, manager);
	}
	
	public FlockSimulator(GUISimulator gui, int nb_boids, EventManager manager){
		this.gui = gui;
		this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
		this.flock = new Flock(this.width, this.height, nb_boids);
		this.drawFlock();
		this.manager = manager;
		this.manager.addEvent(new MajFlock(1,this));
	}

	/**
	 * Dessine les boids dans notre afficheur graphique
	 */
	protected void drawFlock(){
		gui.reset();
		// Il faut désinner quelques chose et qu'il soit orientable.
		for (Boid boid : flock.getBoids()) {
			Vector c = boid.getPosition();
			gui.addGraphicalElement(
					new Oval(
							(int)c.getX(),
							(int)c.getY(), 
							Color.black, 
							Color.red, 
							50, 
							50));
		}
	}

	/**
	 * Mise à jour des boids après un pas
	 * puis affichage
	 */
	@Override
	public void next() {
		this.manager.next();
	}

	/**
	 * Réinitialisation des cellules
	 * puis affichage
	 */
	@Override
	public void restart() {
		this.flock.reInit();
		this.drawFlock();
	}

}

