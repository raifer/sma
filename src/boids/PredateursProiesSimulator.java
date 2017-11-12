package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Oval;
import java.awt.Color;

public class PredateursProiesSimulator implements Simulable {
	
	private Flock predateurs;
	private Flock proies;
	
	protected GUISimulator gui;

	private int height;
	private int width;
	
	public PredateursProiesSimulator(GUISimulator gui){
		this(gui, 3, 20);
	}
	

	public PredateursProiesSimulator(GUISimulator gui, int nb_pred, int nb_proies) {
		this.gui = gui;
		this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
		this.predateurs = new Flock(this.width, this.height, nb_pred, 100, 2);
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
							Color.blue, 
							30, 
							30));
		}
		for (Boid boid : proies.getBoids()) {
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
