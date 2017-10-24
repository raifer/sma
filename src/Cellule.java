import java.awt.Point;

public class Cellule extends Point {

	private Etat etat;
	
	// Les get set
	public Etat getEtat() {
		return this.etat;
	}
	public void setEtat(Etat e){
		this.etat = e;
	}
	
	
	public int getXInt() {
		return (int)super.getX();
	}
	public int getYInt() {
		return (int)super.getY();
	}
	
	// Le constructeur
	public Cellule(int x, int y, Etat e) {
	}
	
	// Les méthodes
	
	public boolean estVivante() {
		if (this.getEtat() == Etat.VIVANT){
			return true;
		}
		else
			return false;
	}
}
