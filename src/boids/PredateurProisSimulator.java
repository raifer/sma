package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Oval;
import java.awt.Color;

public class PredateurProisSimulator implements Simulable {
	
	private Flock predateurs;
	private Flock proies;
	
	protected GUISimulator gui;

	private int height;
	private int width;
	
	public PredateurProisSimulator(GUISimulator gui){
		this(gui, 15, 20);
	}
	

	public PredateurProisSimulator(GUISimulator gui, int nb_pred, int nb_proies) {
		this.gui = gui;
		this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
		this.predateurs = new Flock(this.width, this.height, nb_pred);
		this.proies = new Flock(this.width, this.height, nb_proies);
		this.drawFlock();
	}
	
	protected void drawFlock(){
		gui.reset();
		// Il faut désinner quelques chose et qu'il soit orientable.
		for (Boid boid : predateurs.getBoids()) {
			Vector c = boid.getPosition();
			gui.addGraphicalElement(
					new Oval(
							(int)c.getX(),
							(int)c.getY(), 
							Color.black, 
							Color.red, 
							20, 
							20));
		}
		for (Boid boid : proies.getBoids()) {
			Vector c = boid.getPosition();
			gui.addGraphicalElement(
					new Oval(
							(int)c.getX(),
							(int)c.getY(), 
							Color.black, 
							Color.blue, 
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
		this.predateurs.updateBoidsPostion();
		this.proies.updateBoidsPostion();
		this.drawFlock();
	}

	/**
	 * Réinitialisation des cellules
	 * puis affichage
	 */
	@Override
	public void restart() {
		this.predateurs.reInit();
		this.proies.reInit();
		this.drawFlock();
	}
	
}
