/**
 * 
 */
package automate;

/**
 * @author Mathieu
 *
 */

public abstract class AutomateCellulaire {
	
	private int NB_LIGNES = 10;
	private int NB_COLONNES = 10;

	// Grille des cellules à l'instant t
	protected Cellule[][] grilleCour = new Cellule[NB_LIGNES][NB_COLONNES];
	// Grille de cellules à l'instant t+1
	protected Cellule[][] grilleSuiv = new Cellule[NB_LIGNES][NB_COLONNES];
	// Grille de cellules pour sauvegarder les états d'origines.
	private Cellule[][] grilleOri = new Cellule[NB_LIGNES][NB_COLONNES];

	public AutomateCellulaire() {
		// Génération de la grille
		Enum<?> etat;
		for (int i=0; i<NB_LIGNES; i++) {
			for (int j=0; j<NB_COLONNES; j++){
				etat = this.randomEtat();
				this.grilleCour[i][j] = new Cellule(i,j,etat);
				this.grilleOri[i][j] = new Cellule(i,j,etat);
				this.grilleSuiv[i][j] = new Cellule(i,j);
			}
		}
	}		

	abstract Enum<?> randomEtat ();

	/**
	 * Retourne le nombre de ligne de l'automate cellulaire.
	 * 
	 * @return Retourne le nombre de ligne de la grille du l'automate.
	 */
	public int getNbLignes() {
		return this.NB_LIGNES;
	}
	
	/**
	 * Retourne le nombre de colonnes du jeux de l'automate cellulaire.
	 * 
	 * @return Nombre de ligne
	 */
	public int getNbColonnes() {
		return this.NB_COLONNES;
	}

	// Méthodes

	/**
	 * Récupérer la cellule voisine de c à la position i.
	 * 
	 * @param c Cellule dont on recherche un voisin
	 * @param position Valeur de 1 à 8, 1 en haut à gauche puis on tourne dans le sense des aiguilles d'une montre.
	 * 
	 * @return Retourne la cellule voisine à la position i.
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
		if (x< 0) x = NB_LIGNES-1;
		if (x == NB_LIGNES) x = 0;
		if (y < 0) y = NB_COLONNES-1;
		if (y == NB_COLONNES) y = 0;

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
	protected void setEtatSuiv(int x, int y, Enum<?> etat) {
		grilleSuiv[x][y].setEtat(etat);
	}
	
	/**
	 * Met à jour la grille avec les règles du jeux de la vie.
	 * 
	 */
	public void majAutomate(){
		for (int x=0; x < this.getNbLignes(); x++) {
			for (int y=0; y < this.getNbColonnes(); y++){
				majCellule(getCellule(x,y));	
			}
		}
		// Inversion des deux grilles.
		Cellule[][] grilleSAV = new Cellule[NB_LIGNES][NB_COLONNES];
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
	
}