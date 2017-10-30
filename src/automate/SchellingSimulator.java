/**
 * 
 */
package automate;

import gui.GUISimulator;

/**
 * @author Mathieu
 *
 */
public class SchellingSimulator extends AutomateSimulator<Schelling> {

	/**
	 * Créer un Automate de Schelling et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 */
	public SchellingSimulator(GUISimulator gui) {
		super( new Schelling(), gui);
	}
}
