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

	/**
	 * Construteur initialisant la position d'une cellule sur les axes x et y
	 * @param x
	 * @param y
	 */
	public Cellule(int x, int y) {
		this.setLocation(x, y);
	}
	
	/**
	 * Constructeur initialissant la position d'une cellule sur les axes x ainsi que son état
	 * @param x
	 * @param y
	 * @param etat
	 */
	public Cellule(int x, int y, int etat) {
		this(x, y);
		this.setEtat(etat);		
	}
	
	/**
	 * Renvoie de l'état d'une cellule
	 * @return état de la cellule
	 */
	public int getEtat() {
		return this.etat;
	}
	
	/**
	 * Retour de la couleur d'un état d'une cellule
	 * @return Color couleur de la cellule
	 */
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
	
	/**
	 * Initialisation de l'état d'une cellule
	 * @param etat de la cellule
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	/**
	 * Renvoi de la coordonée x d'une cellule
	 * @return x Coordonnée x
	 */
	public int getXInt() {
		return (int)super.getX();
	}
	
	/**
	 * Renvoi de la coordonnée y d'une cellule
	 * @return y coordonnée y
	 */
	public int getYInt() {
		return (int)super.getY();
	}
	
	/**
	 * Dit si une cellule est morte ou vivante
	 * @return un booléen =1 pour vivant =0 pour mort
	 */
	public boolean estVivante() {
		if (this.etat > 0){
			return true;
		}
		else
			return false;
	}
}
