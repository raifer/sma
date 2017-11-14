package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Oval;
import gui.Rectangle;

import java.awt.Color;

import evenements.EventManager;

/**
 * Simule deux flocks différents
 *
 */

public class PredateursProiesSimulator implements Simulable {
	
	protected Flock predateurs;
	protected Flock proies;
	
	protected GUISimulator gui;
	protected EventManager manager;

	private int height;
	private int width;
	
	/**
	 * Constructeur par défaut avec 3 prédateurs et 20 proies
	 * 
	 * @param gui interface de simulation
	 * @param manager le gestionnaire d'évènements
	 */
	public PredateursProiesSimulator(GUISimulator gui, EventManager manager){
		this(gui, 3, 20, manager);
	}
	
	/**
	 * Constructeur avec choix du nombre de proies et de prédateurs
	 * 
	 * @param gui
	 * @param nb_pred
	 * @param nb_proies
	 * @param manager
	 */
	public PredateursProiesSimulator(GUISimulator gui, int nb_pred, int nb_proies, EventManager manager) {
		this.gui = gui;
		this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
		this.predateurs = new Flock(this.width, this.height, nb_pred, 100);
		this.predateurs.setAttractionFactor(4000);
		this.proies = new Flock(this.width, this.height, nb_proies);
		this.drawFlock();
		this.manager = manager;
		this.manager.addEvent(new MajPredateurs(2,this));
		this.manager.addEvent(new MajProies(1, this));
	}
	
	/**
	 * Dessine les deux flocks
	 */
	protected void drawFlock(){
		gui.reset();
		for (Boid boid : predateurs.getBoids()) {
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
		for (Boid boid : proies.getBoids()) {
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
	}
	
	/**
	 *Dessine la nourriture
	 */
	protected void drawFood() {
		gui.addGraphicalElement(new Rectangle(500, 100, Color.green, Color.black, 5, 5));
	}
	
	/**
	 * Mise à jour des boids après un pas
	 * puis affichage
	 */
	@Override
	public void next() {
		this.manager.next();
		this.drawFlock();
		this.drawFood();
	}

	/**
	 * Réinitialisation des cellules
	 * puis affichage
	 */
	@Override
	public void restart() {
		this.predateurs.reInit();
		this.proies.reInit();
		this.manager.restart();
		this.manager.addEvent(new MajPredateurs(2,this));
		this.manager.addEvent(new MajProies(1, this));
		this.drawFlock();
	}


	
}
