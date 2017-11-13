/**
 * 
 */
package automate;


import java.util.LinkedList;
import java.util.List;


public class Schelling extends AutomateCellulaire {

	/** 
	 * Seuil k de la simulation
	 * Si une famille de couleur c a plus de K voisins de couleur différente alors la famille déménage, 
	 */
	private int k;

	/**
	 * Nombre de couleur pour la simulation 
	 */
	private int nbCouleurs;

	/**
	 * Nombre de cellules vacantes dans la grille
	 */
	private int nbCellulesVacantes;

	/**
	 * list qui contient toutes les cellules vacantes
	 * Choix d'd'une liste chaîné car :
	 * - Pas d'accès concurant;
	 * - Besoin d'accès par indice.
	 */
	List<Cellule> cellulesVacantes = new LinkedList<Cellule>();


	/**
	 *List qui va contenir les nouvelles cellules vaccantes 
	 */
	List<Cellule> newCellulesVacantes = new LinkedList<Cellule>();

	/**
	 * Objet permettant de générer des entier aléatoire dans un range
	 * 
	 */

	/**
	 * Constructeur par défaut 
	 * Le seuil est de 3 et le nombre de couleurs de 4
	 * cellules vacantes de 20 et grillle 10x10
	 */
	public Schelling() {
		this(3, 4, 20);
	}

	/**
	 * Construction de l'automate de schelling avec grille 10x10 par défaut
	 * @param k le seuil
	 * @param nbCouleurs le nombre de couleur sur la grille 
	 * (sans compter le blanc qui représente une habitation vacante)
	 * @param nbVacantes Nombre de cellule vacantes dans la grille
	 */
	public Schelling(int k,int nbCouleurs, int nbVacantes) {
		this(k, nbCouleurs, nbVacantes, 10, 10);
	}

	/**
	 * Constructeur où l'on précise la taille de la grille
	 * 
	 * @param nbLignes nombre de ligne dans la grille
	 * @param nbColonnes nombre de colonnes dans la grille
	 */
	public Schelling(int k,int nbCouleurs, int nbVacantes, int nbLignes, int nbColonnes) {
		super(nbLignes, nbColonnes);
		this.setK(k);
		this.setNbCouleurs(nbCouleurs);
		this.setNbCellulesVacantes(nbVacantes);
		this.InitEtat();
		// Placement des cellules vacantes
		this.placeCellulesVacantes(nbCellulesVacantes);
	}

	/**
	 * @param k the k to set
	 */
	private void setK(int k) {
		if (k>8|| k < 1){
			throw new IllegalArgumentException("Le seuil de voisins doit être compris entre 1 et 8.");
			//		return Color.red;
		}
		else {
			this.k=k;
		}
	}

	/**
	 * Donne le nombre de couleur différentes dans l'automate
	 * @return the nbCouleur
	 */
	public int getNbCouleurs() {
		return nbCouleurs;
	}

	/**
	 * @param nbCouleur the nbCouleur to set
	 */
	private void setNbCouleurs(int nbCouleurs) {

		if (nbCouleurs>9 || nbCouleurs < 1){
			throw new IllegalArgumentException("Le nombre de couleurs doit être compris entre 1 et 9");
		}
		else {
			this.nbCouleurs = nbCouleurs;
		}
	}

	/**
	 * Retourne le paramètre du nombre de cellules vacantes de l'automate
	 * 
	 * @return Le nombre de cellule vacantes (fixe)
	 */
	public int getNbCellulesVacantes() {
		return nbCellulesVacantes;
	}

	private void setNbCellulesVacantes(int nbCellulesVacantes) {
		this.nbCellulesVacantes = nbCellulesVacantes;
	}

	/**
	 * Trouve un entier alétoire compris entre 1 et le nombre de couleurs
	 */
	@Override
	protected int randomEtat() {
		return randomGenerator.nextInt(this.nbCouleurs) + 1;
	}

	/**
	 * Placer un nombre spécifique de cellules vacantes sur la grille courante
	 *  
	 * @param nbVacantes Nombre de cellule vacantes à placer sur la grille
	 */
	private void placeCellulesVacantes(int nbVacantes) {
		for(int i=0; i < nbVacantes; i++) {
			this.placeRandomCelluleVacante();
		}
	}

	/**
	 * Remplace une cellule occupée choisie au hasard par une vacante 
	 */
	private void placeRandomCelluleVacante() {
		Cellule c;
		int x, y;
		// On cherche une cellule occupé pour la remplacer
		do {
			x = this.randomGenerator.nextInt(this.getNbColonnes());
			y = this.randomGenerator.nextInt(this.getNbLignes());
			c = super.getCellule(x, y);
		} while (!c.estVivante());
		super.setEtatCourant(x, y, 0);
		super.setEtatOri(x, y, 0);
		this.cellulesVacantes.add(new Cellule(x, y));
	}

	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#majAutomate()
	 * Surchargé pour mettre à jour la liste des cellules vacantes
	 */
	@Override
	public void majAutomate(){
		super.majAutomate();
		// Ajout des nouvelle cellules vacantes dans la liste des cellules vacantes
		this.cellulesVacantes.addAll(this.newCellulesVacantes);
		this.newCellulesVacantes.clear();
	}

	/**
	 * Prend la famille de la cellule c en paramettre et la déplace sur une cellule vacante
	 * Si plus de cellule vacante pour ce step, on ne déplace pas la famille
	 * 
	 * @param c La cellule à déménager
	 */
	private void demenagement(Cellule c) {
		// On cherche une cellule vacante
		if (this.cellulesVacantes.size() == 0) {
			// On ne peut pas déplacer la famille, plus de place libre pour ce step.
			// Elle reste sur place
			this.setEtatSuiv(c.getXInt(), c.getYInt(), c.getEtat());
			return;
		}

		// On prend une place libre au hasart
		int index = this.randomGenerator.nextInt(this.cellulesVacantes.size());
		Cellule cible = this.cellulesVacantes.get(index);
		int x = cible.getXInt();
		int y = cible.getYInt();

		// On supprim la place libre
		this.cellulesVacantes.remove(index);
		// On déplace la famille dans la nouvelle cellule
		this.setEtatSuiv(x, y, c.getEtat());
		this.setEtatSuiv(c.getXInt(), c.getYInt(), 0);
		// On libère donc la place pour le step suivant
		this.newCellulesVacantes.add( new Cellule(c.getXInt(), c.getYInt()));
	}

	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#majCellule(automate.Cellule)
	 */
	@Override
	void majCellule(Cellule c) {
		// Si la cellule est vacante
		if (! c.estVivante()) {
			// Si la cellule vacante n'a pas été prise par une précedente famille, on la recopie sur la grille suivante
			if (this.cellulesVacantes.contains(c) ) { 
				this.setEtatSuiv( c.getXInt(), c.getYInt(), c.getEtat());
				return;
			} else 
				// La cellule vacante à été utilisé par une famille, on ne fait rien
				return;
		}
		// La cellule est habitée
		// Il faut compter le nombre de voisins différents pour s	savoir si on déménage
		int nbPasCommeNous = 0;
		for (int i=1; i<=8; i++) {
			Cellule v = super.getVoisin(c, i);
			if( c.getEtat() != v.getEtat()
					&& v.estVivante()) 
				nbPasCommeNous++;
		}
		// Si une famille de couleur c a plus de K voisins (sur huit) de couleur différente, elle déménage 
		if (nbPasCommeNous > this.k)  
			this.demenagement(c);
		else {
			// La famille se sent bien, elle reste sur place
			this.setEtatSuiv(c.getXInt(), c.getYInt(), c.getEtat());
		}
	}

}
