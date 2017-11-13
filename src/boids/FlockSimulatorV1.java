package boids;

import gui.GUISimulator;
import gui.Simulable;
import gui.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;



public class FlockSimulator implements Simulable {
	private Flock flock;

	protected GUISimulator gui;

	private int height;
	private int width;
	
	//Pour polygone
	private int triX[];
	private int triY[];
	private int h;
	private int l;
	
	public FlockSimulator(GUISimulator gui){
		this(gui, 20);
	}
	
		public FlockSimulator(GUISimulator gui, int nb_boids){
		this.gui = gui;
		 this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
		this.flock = new Flock(this.width, this.height, nb_boids);
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
			
			/* Soit le triangle isocèle de hauteur H et de bas l suivant :
			 * 
			 *      A      G, centre de gravité du triangle isocèle est la coordonées du boids.
			 *     / \     A=[Xg;(Yg-2/3.H)]
			 *    /   \	   B=[(Xg-1/2.l);(Yg+1/3.H)]
			 *   /  G  \   C=[(Xg+1/2.l);(Yg+1/3.H)]
			 *  /       \
			 * B ------- C          
			 */
			//Point A
			this.triX[0]=(int) c.getX();
			this.triY[0]=((int) c.getY()-(2/3)*this.h);
			//Point B
			this.triX[1]=((int) c.getX()-(1/2)*this.l);
			this.triY[1]=((int) c.getY()+(1/3)*this.h);
			//Point C
			this.triX[2]=((int) c.getX()+(1/2)*this.l);
			this.triY[2]=((int) c.getY()+(1/3)*this.h);
			//Création du triangle isocèle
			Polygon tri = new Polygon(this.triX,this.triY,3);
		
			
			
			/*
			gui.addGraphicalElement(
					
					new Rectangle(
							(int)c.getX(),
							(int)c.getY(), 
							Color.black, 
							Color.red, 
							50, 
							50));
							*/
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

