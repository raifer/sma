/**
 * 
 */
package automate;

import java.awt.Color;

/**
 * @author mathieu
 *
 */

/**
 * Enumération des états et de leurs couleurs pour l'automate cellulaire de Schelling.
 *
 */
public enum EtatS {
	Vacante(0, Color.green),
	Noir(1, Color.black),
	Blanc(2, Color.white),
	Jaune(3, Color.yellow);

	private final int index;
	private final Color couleur;
	
	private EtatS(int index, Color couleur){
		this.index = index;
		this.couleur = couleur;
	}
	
	   /**
	    * Récupérer un état à partir de sonindex
	    * 
	 * @param index Numéro de l'état demandé
	 * @return Retourne l'état EtatS corespondant
	 * @throw IllegalArgument Si l'index n'est pas présent dans l'enum on lève une erreur
	 */
	public static EtatS valueOf(int index) {
		      for (EtatS e : EtatS.values()) {
		          if (e.index == index) return e;
		      }
		      throw new IllegalArgumentException("EtatS not found. Amputated?");
		}
	   
	/**
	 * Obtenir la couleur associée à cette état
	 * 
	 * @return Retourne la couleur à afficher pour cette etat.
	 */
	public Color getCouleur(){
		return this.couleur;
	}
}
