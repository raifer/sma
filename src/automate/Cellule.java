/**
 * @author picardv Mathieu Claire
 * 
 */
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
			return Color.decode("#5084a2"); //Bleu
		case 2 :
			return Color.decode("#a06fa8"); //Rose
		case 3 :
			return Color.decode("#cec681"); //Creme
		case 4 :
			return Color.decode("#951f2b"); //Bordeau
		case 5 :
			return Color.decode("#9fe3ba"); //Vert
		case 6 :
			return Color.decode("#4cdfe9"); //Turquoise
		case 7 :
			return Color.decode("#9fa3a4"); //Argent
		case 8 :
			return Color.decode("#714872"); //Violet
		case 9 :
			return Color.decode("#a66970"); //Rouge
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
