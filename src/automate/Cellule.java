package automate;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("serial")
public class Cellule extends Point {

	private int etat;

	public Cellule(int x, int y) {
		this.setLocation(x, y);
	}
		
	public Cellule(int x, int y, int etat) {
		this(x, y);
		this.setEtat(etat);		
	}
	
	// Les get set
	public int getEtat() {
		return this.etat;
	}
	
	public Color getCouleur() {
		switch (this.etat) {
		case 0 :
			return Color.white;
		case 1 :
			return Color.black;
		case 2 :
			return Color.blue;
		case 3 :
			return Color.green;
		case 4 :
			return Color.yellow;
			default :
				throw new IllegalArgumentException("Il n'y a pas de couleur pour l'état " + this.etat);
//				return Color.red;
		}
	}
	
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getXInt() {
		return (int)super.getX();
	}
	
	public int getYInt() {
		return (int)super.getY();
	}
	
	// Les méthodes
	
	public boolean estVivante() {
		if (this.etat > 0){
			return true;
		}
		else
			return false;
	}
}
