package automate;
import gui.GUISimulator;

/**
 * Classe qui permet la simulation de l'automate de Schelling
 *
 */
public class SchellingSimulator extends AutomateSimulator<Schelling> {

	/**
	 * Créer un Automate de Schelling et l'utilise pour la simulation.
	 * @param gui L'interface qui sera utilisée pour la simulation
	 * @param le nombre de couleurs du jeu
	 *@param seuil du jeu
	 *@param nombre de lignes du jeu
	 *@param nombre de colonnes du jeu
	 *@param le nombre de places vacantes
	 */
	
	public SchellingSimulator(GUISimulator gui, int nbCouleurs,int seuil, int nbLignes, int nbColonnes, int nbVacantes) {
		super( new Schelling(seuil, nbCouleurs, nbVacantes, nbLignes, nbColonnes), gui);
	}
}
