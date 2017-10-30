/**
 * 
 */
package automate;

import gui.GUISimulator;

/**
 * @author Mathieu
 *
 */
public class ImmigrationSimulator extends AutomateSimulator<Immigration> {

	/**
	 * Créer un Automate de l'immigration et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 */
	public ImmigrationSimulator(GUISimulator gui) {
		this(gui, 4);
	}
		
	public ImmigrationSimulator(GUISimulator gui, int nbEtat) {
		super( new Immigration(nbEtat), gui);
	}
}
