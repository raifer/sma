/**
 * 
 */
package automate;

import java.util.Random;

/**
 * @author Mathieu Picardv
 *
 */

public abstract class AutomateCellulaire {

	private int nbLignes;
	private int nbColonnes;

	/** Grille des cellules à l'instant t */
	private Cellule[][] grilleCour;
	/** Grille de cellules à l'instant t+1 */
	private Cellule[][] grilleSuiv = new Cellule[nbLignes][nbColonnes];
	/** Grille de cellules pour sauvegarder les états d'origines. */
	private Cellule[][] grilleOri = new Cellule[nbLignes][nbColonnes];
	protected Random randomGenerator;  // Objet permettant de géner un entier aléatoire

	public AutomateCellulaire() {
		this(10, 10);
	}

	public AutomateCellulaire(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.grilleCour = new Cellule[nbColonnes][nbLignes];
		this.grilleSuiv = new Cellule[nbColonnes][nbLignes];
		this.grilleOri = new Cellule[nbColonnes][nbLignes];
		// Génération de la grille
		for (int y=0; y<nbLignes; y++) {
			for (int x=0; x<nbColonnes; x++){
				this.grilleCour[x][y] = new Cellule(x, y);
				this.grilleOri[x][y] = new Cellule(x,y);
				this.grilleSuiv[x][y] = new Cellule(x, y);
			}
		}
	}

	/**
	 * Initialisation des états lors de la création du jeu
	 */
	public void InitEtat() {
		randomGenerator= new Random();
		for (int y=0; y<nbLignes; y++) {
			for (int x=0; x<nbColonnes; x++){
				int etat = this.randomEtat();
				this.setEtatCourant(x, y, etat);
				this.setEtatOri(x, y,etat);
			}
		}
	}

	abstract int randomEtat ();

	/**
	 * Retourne le nombre de ligne de l'automate cellulaire.
	 * 
	 * @return Retourne le nombre de ligne de la grille du l'automate.
	 */
	public int getNbLignes() {
		return this.nbLignes;
	}

	/**
	 * Retourne le nombre de colonnes du jeux de l'automate cellulaire.
	 * 
	 * @return Nombre de ligne
	 */
	public int getNbColonnes() {
		return this.nbColonnes;
	}

	// Méthodes

	/**
	 * Récupérer la cellule voisine de c à la position i.
	 * 
	 * @param c Cellule dont on recherche un voisin
	 * @param position Valeur de 1 à 8, 1 en haut à gauche puis on tourne dans le sense des aiguilles d'une montre.
	 * 
	 * @return Retourne la cellule voisine à la position i.
	 * @throw IllegalArgument Si la position n'est pas comprise entre 1 et 8
	 */
	protected Cellule getVoisin(Cellule c, int position){

		int x=0, y=0;
		switch (position) {
		case 1:
			x = c.getXInt()+1;
			y = c.getYInt()-1;
			break;
		case 2:
			x = c.getXInt()+1;
			y = c.getYInt();
			break;
		case 3:
			x = c.getXInt()+1;
			y = c.getYInt()+1;
			break;
		case 4:
			x = c.getXInt();
			y = c.getYInt()+1;
			break;
		case 5:
			x = c.getXInt()-1;
			y = c.getYInt()+1;
			break;
		case 6:
			x = c.getXInt()-1;
			y = c.getYInt();
			break;
		case 7:
			x = c.getXInt()-1;
			y = c.getYInt()-1;
			break;
		case 8:
			x = c.getXInt();
			y = c.getYInt()-1;
			break;
		default:
			throw new IllegalArgumentException("La position du voisin doit être compris entre 1 et 8");
		}
		if (x< 0) x = nbColonnes-1;
		if (x == nbColonnes) x = 0;
		if (y < 0) y = nbLignes-1;
		if (y == nbLignes) y = 0;

		return this.getCellule(x, y);
	}

	/**
	 * Retourne la cellule à la position X Y.
	 * 
	 * @param x Position x sur la grille
	 * @param y Position y sur la grille
	 * 
	 * @return Retourne une référence vers la cellule X Y.
	 */
	public Cellule getCellule(int x, int y){
		return this.grilleCour[x][y];
	}

	/**
	 * Modifie l'état future d'une cellule de coordonnées x, y.
	 * 
	 * @param x Position x de la cellule à modifier
	 * @param y Position y de la cellule à modifier
	 * @param etat Nouvelle etat de la cellule à modifier
	 */
	protected void setEtatSuiv(int x, int y, int etat) {
		grilleSuiv[x][y].setEtat(etat);
	}

	/**
	 * Modifie l'état courant d'une cellule de coordonnées x, y.
	 * 
	 * @param x Position x de la cellule à modifier
	 * @param y Position y de la cellule à modifier
	 * @param etat Nouvelle etat de la cellule à modifier
	 */
	protected void setEtatCourant(int x, int y, int etat) {
		grilleCour[x][y].setEtat(etat);
	}

	/**
	 * Modifie l'état Original d'une cellule de coordonnées x, y.
	 * 
	 * @param x Position x de la cellule à modifier
	 * @param y Position y de la cellule à modifier
	 * @param etat Nouvelle etat de la cellule à modifier
	 */
	protected void setEtatOri(int x, int y, int etat) {
		grilleOri[x][y].setEtat(etat);
	}


	/**
	 * Met à jour la grille avec les règles du jeux de la vie.
	 * 
	 */
	public void majAutomate(){
		for (int y=0; y < this.getNbLignes(); y++) {
			for (int x=0; x < this.getNbColonnes(); x++){
				majCellule(getCellule(x,y));	
			}
		}
		// Inversion des deux grilles.
		Cellule[][] grilleSAV;
		grilleSAV = this.grilleCour;
		this.grilleCour = this.grilleSuiv;
		this.grilleSuiv = grilleSAV;
	}

	/**
	 *Calcule le future état de la cellule c et le stoque dans la grille suivante.
	 *
	 * @param c La cellule à mettre à jour.
	 */
	abstract void majCellule(Cellule c);

	/**
	 * Réinitialise l'automate. Chaque cellule est remise à son état d'origine
	 */
	public void reInit() {
		for (int y=0; y<nbLignes; y++) {
			for (int x=0; x<nbColonnes; x++){
				this.setEtatCourant(x, y,
						this.grilleOri[x][y].getEtat());
			}
		}

	}

}