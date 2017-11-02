package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;

import boids.model.Boid;
import boids.model.Flock;
import boids.util.Vector;

/**
 * @author Mathieu
 *
 */

public class FlockSimulator implements Simulable {
	private Flock flock;

	protected GUISimulator gui;

	public FlockSimulator(GUISimulator gui){
		this.gui = gui;
		this.flock = new Flock();
		this.drawFlock();
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
					new Rectangle(
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
		this.flock.updateBoidsPostion();
		this.drawFlock();
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

