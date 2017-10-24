
public class JeuDeLaVie {
	private static final int NB_LIGNES = 10;
	private static final int NB_COLONNES = 10;

	// Grille des cellules l'instant t
	private Cellule[][] grilleCour = new Cellule[NB_LIGNES][NB_COLONNES];
	// Grille de cellules à l'instant t+1
	private Cellule[][] grilleSuiv = new Cellule[NB_LIGNES][NB_COLONNES];
	// Grille de cellules pour sauvegarder les états d'origines.
	private Cellule[][] grilleOri = new Cellule[NB_LIGNES][NB_COLONNES];

	/**
	 * Retourne le nombre de ligne du jeux de la vie
	 * 
	 * @return Retourne le nombre de ligne de la grille du jeuw de la vie.
	 */
	public int getNbLignes() {
		return JeuDeLaVie.NB_LIGNES;
	}
	
	/**
	 * Retourne le nombre de colonnes du jeux de la vie
	 * 
	 * @return Nombre de ligne
	 */
	public int getNbColonnes() {
		return JeuDeLaVie.NB_COLONNES;
	}

	//Constructeur
	public JeuDeLaVie() {
		double p;
		Etat e;
		for (int i=0; i<NB_LIGNES; i++) {
			for (int j=0; j<NB_COLONNES; j++){
				p = Math.random();
				if (p>0.5) {
					e = Etat.VIVANT;
				}
				else
					e = Etat.MORT;
				this.grilleCour[i][j] = new Cellule(i,j,e);
				this.grilleOri[i][j] = new Cellule(i,j,e);
				this.grilleSuiv[i][j] = new Cellule(i,j,Etat.MORT);
			}
		}
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
	private Cellule getVoisin(Cellule c, int position){

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
	 *Calcule le future état de la cellule c et le stoque dans la grille suivante.
	 *
	 * @param c La cellule à mettre à jour.
	 */
	private void majCellule(Cellule c){
		int x = c.getXInt();
		int y = c.getYInt();
		int nbVoisinsVivants = 0;
		Etat etat = Etat.MORT;

		// On compte le nombre de voisin vivant
		for(int i=1; i<9; i++){
			if (getVoisin(c, i).estVivante()) nbVoisinsVivants++;
		}

		switch (nbVoisinsVivants){
		case 4: case 5: case 6: case 7: case 8:
			etat = Etat.MORT;
			break;
		case 3:
			etat = Etat.VIVANT;
			break;
		case 2:
			etat = c.getEtat();
			break;
		case 0: case 1:
			etat = Etat.MORT;
			break;
		}

		this.grilleSuiv[x][y].setEtat(etat);
	}
}
