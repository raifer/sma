package automate;

import java.awt.Point;

@SuppressWarnings("serial")
public class Cellule extends Point {

	private Enum<?> etat;

	public Cellule(int x, int y) {
		this.setLocation(x, y);
	}
		
	public Cellule(int x, int y, Enum<?> etat) {
		//Cellule(x, y);
		this.setLocation(x, y);
		this.setEtat(etat);		
	}
	
	// Les get set
	public Enum<?> getEtat() {
		return this.etat;
	}
	
	public void setEtat(Enum<?> etat){
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
		if (this.getEtat().ordinal() > 0){
			return true;
		}
		else
			return false;
	}
}
