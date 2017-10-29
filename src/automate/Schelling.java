/**
 * 
 */
package automate;

/**
 * @author Mathieu
 *
 */

import java.util.LinkedList;
import java.util.List;
//import java.util.Iterator;
import java.util.Random;


public class Schelling extends AutomateCellulaire {

	/** 
	 * Seuil k de la simulation
	 * 
	 * Si une famille de couleur c a plus de K voisins de couleur différente alors la famille déménage, 
	 */
	int k;
	
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
 * 
 * Choix d'd'une liste chaîné car :
 * - Pas d'accès concurant;
 * - Besoin d'accès par indice.
 */
List<Cellule> cellulesVacantes = new LinkedList<Cellule>();


/**
 *List qui va contenir les nouvelles cellules vaccantes 
 */
List<Cellule> newCellulesVacantes = new LinkedList<Cellule>();

private Random randomGenerator;

public Schelling() {
	super();
	this.setK(3);
	this.setNbCouleurs(3);
	this.setNbCellulesVacantes(20);
	this.randomGenerator = new Random();
	this.placeCellulesVacantes(nbCellulesVacantes);
}

/**
 * @param k the k to set
 */
private void setK(int k) {
	this.k = k;
}

/**
 * @return the nbCouleur
 */
public int getNbCouleurs() {
	return nbCouleurs;
}

/**
 * @param nbCouleur the nbCouleur to set
 */
private void setNbCouleurs(int nbCouleur) {
	this.nbCouleurs = nbCouleur;
}

	public int getNbCellulesVacantes() {
	return nbCellulesVacantes;
}

private void setNbCellulesVacantes(int nbCellulesVacantes) {
	this.nbCellulesVacantes = nbCellulesVacantes;
}

	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#randomEtat()
	 */
	@Override
	EtatS randomEtat() {
		int index = this.randomGenerator.nextInt(this.nbCouleurs-1)+1; // On ne veut pas 0 (vacante)
		return EtatS.valueOf(index);
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
	super.setEtatCourant(x, y, EtatS.Vacante);
	this.cellulesVacantes.add(new Cellule(x, y, EtatS.Vacante));
	}
	
	private void demenagement(Cellule c) {
		// On cherche une cellule vacante
		int index = this.randomGenerator.nextInt(this.cellulesVacantes.size());
		Cellule cible = this.cellulesVacantes.get(index);
		int x = cible.getXInt();
		int y = cible.getYInt();
		// On supprim la place libre
this.cellulesVacantes.remove(index);
// On déplace la famille
super.setEtatSuiv(x, y, c.getEtat());
// On libère une cellule pour le tour suivant
this.newCellulesVacantes.add(new Cellule(c.getXInt(), c.getYInt(), EtatS.Vacante));
	}
		
	
	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#majCellule(automate.Cellule)
	 */
	@Override
	void majCellule(Cellule c) {
		// TODO Auto-generated method stub

	}

}
