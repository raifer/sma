
public class Grille {
	public static final int NB_LIGNES = 10;
	public static final int NB_COLONNES = 10;
	
	private Cellule[][] cellules = new Cellule[NB_LIGNES][NB_COLONNES];
	//Attention ne contient que des références nulles
	
	//A mettre dans le constructeur avec random
	//Faire une boucle qui copie le tableau : voir balls.Ori
	//Un tableau t un tableau t+1
	
	//Méthode qui initialise la grille en affectant aléatoirement les états des cellules
	public void reInitGrille() {
		for (int i = 0; i < NB_LIGNES-1; i++) {
			for (int j = 0; j < NB_COLONNES-1; j++) {
				this.cellules[i][j].setEtat(e);
				
			}
		}
	}
	
	
	
	
	
}
