package automate;
/**
 * @author picarv mathieu claire
 *
 */
public class JeuDeLaVie extends AutomateCellulaire{
	
	/**
	 * Constructeur
	 */
	public JeuDeLaVie (){
		super();
		this.InitEtat();
	}
	
	/**
	 * Génère un état aléatoire
	 */
	int randomEtat () {
		double p;
		p = Math.random();
		if (p>0.5) {
			return 1;
		}
		else
			return 0;
	}

	/**
	 *Calcule le future état de la cellule c et le stoque dans la grille suivante.
	 * @param c La cellule à mettre à jour.
	 */
	protected void majCellule(Cellule c){
		int x = c.getXInt();
		int y = c.getYInt();
		int nbVoisinsVivants = 0;
		 int etat = 0;

		// On compte le nombre de voisin vivant
		for(int i=1; i<9; i++){
			if (getVoisin(c, i).estVivante()) nbVoisinsVivants++;
		}

		switch (nbVoisinsVivants){
		case 0: case 1: case 4: case 5: case 6: case 7: case 8:
			etat = 0;
			break;
		case 3:
			etat = 1;
			break;
		case 2:
			etat = c.getEtat();
			break;
		}

		this.setEtatSuiv(x, y, etat);
	}
}
