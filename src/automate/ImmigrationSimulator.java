package automate;
import gui.GUISimulator;

public class ImmigrationSimulator extends AutomateSimulator<Immigration> {

	/**
	 * Créer un Automate de l'immigration et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 * @param nbEtat Le nombre d'état du jeu
	 * @param nombre de lignes
	 * @param nombre de colonnes
	 */
	public ImmigrationSimulator(GUISimulator gui, int nbEtat, int nbLignes, int nbColonnes) {
		super( new Immigration(nbEtat,nbLignes,nbColonnes), gui);
	}
}
