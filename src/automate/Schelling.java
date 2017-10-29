/**
 * 
 */
package automate;

/**
 * @author Mathieu
 *
 */

public class Schelling extends AutomateCellulaire {

	/** 
	 * Seuil k de la simulation
	 * 
	 * Si une famille de couleur c a plus de K voisins de couleur différente alors la famille déménage, 
	 */
	int k = 3;
	
/**
 * Nombre de couleur pour la simulation 
 */
private int nbCouleur = 3;

	/**
 * @return the k
 */
public int getK() {
	return k;
}

/**
 * @param k the k to set
 */
public void setK(int k) {
	this.k = k;
}

/**
 * @return the nbCouleur
 */
public int getNbCouleur() {
	return nbCouleur;
}

/**
 * @param nbCouleur the nbCouleur to set
 */
public void setNbCouleur(int nbCouleur) {
	this.nbCouleur = nbCouleur;
}

	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#randomEtat()
	 */
	@Override
	EtatS randomEtat() {
		double p;
		p = Math.random() * this.nbCouleur;
		for (int i=1; i<= this.nbCouleur; i++) {
		if (p < i) break;
		}
		return EtatS.valueOf(1);
	}

	/* (non-Javadoc)
	 * @see automate.AutomateCellulaire#majCellule(automate.Cellule)
	 */
	@Override
	void majCellule(Cellule c) {
		// TODO Auto-generated method stub

	}

}
