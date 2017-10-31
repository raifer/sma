/**
 * 
 */
package automate;

import gui.GUISimulator;

/**
 * @author Mathieu Picardv
 *
 */
public class SchellingSimulator extends AutomateSimulator<Schelling> {

	/**
	 * Créer un Automate de Schelling et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 *@param seuil du jeu
	 *@param nombre de couleurs du jeu
	 */
	public SchellingSimulator(GUISimulator gui,int seuil, int nbCouleurs, int nbVacantes) {
		super( new Schelling(seuil, nbCouleurs, nbVacantes), gui);
	}
	
	public SchellingSimulator(GUISimulator gui,int seuil, int nbCouleurs, int nbVacantes, int nbLignes, int nbColonnes) {
		super( new Schelling(seuil, nbCouleurs, nbVacantes, nbLignes, nbColonnes), gui);
	}
}
