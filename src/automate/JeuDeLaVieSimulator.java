package automate;
import gui.GUISimulator;

/**
 * Classe qui permet la simulation de l'automate Jeux de la vie
 *
 */
public class JeuDeLaVieSimulator extends AutomateSimulator<JeuDeLaVie> {

	/**
	 * Création de l'automate JeuDeLaVie puis création de la grille
	 * @param gui Interface graphique pour afficher notre simulation
	 * @param nombre de lignes
	 * @param nombre de colonnes
	 */
		
	public JeuDeLaVieSimulator(GUISimulator gui, int nbLignes, int nbColonnes) {
		super(new JeuDeLaVie(nbLignes,nbColonnes), gui);
	}


}
