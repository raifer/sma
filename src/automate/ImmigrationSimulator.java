package automate;
import gui.GUISimulator;
/**
 * @author Mathieu Picardv
 *
 */
public class ImmigrationSimulator extends AutomateSimulator<Immigration> {

	/**
	 * Créer un Automate de l'immigration et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 * @param nbEtat Le nombre d'état du jeu
	 */
	public ImmigrationSimulator(GUISimulator gui, int nbEtat) {
		super( new Immigration(nbEtat), gui);
	}
}
