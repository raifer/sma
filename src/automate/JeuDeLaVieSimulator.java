package automate;
import gui.GUISimulator;
/**
 * @author Mathieu
 *
 */
public class JeuDeLaVieSimulator extends AutomateSimulator<JeuDeLaVie> {

	/**
	 * Création de l'automate JeuDeLaVie puis création de la grille
	 * @param gui Interface graphique pour afficher notre simulation
	 */
	public JeuDeLaVieSimulator(GUISimulator gui) {
		super(new JeuDeLaVie(), gui);
	}

}
