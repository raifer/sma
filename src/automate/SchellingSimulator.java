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
	public SchellingSimulator(GUISimulator gui,int seuil, int nbCouleurs) {
		super( new Schelling(seuil,nbCouleurs), gui);
	}
}
