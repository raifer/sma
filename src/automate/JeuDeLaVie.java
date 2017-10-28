package automate;

public class JeuDeLaVie extends AutomateCellulaire{
	
	EtatJ randomEtat () {
		double p;
		p = Math.random();
		if (p>0.5) {
			return EtatJ.Vivant;
		}
		else
			return EtatJ.Mort;
	}


	/**
	 *Calcule le future état de la cellule c et le stoque dans la grille suivante.
	 *
	 * @param c La cellule à mettre à jour.
	 */
	protected void majCellule(Cellule c){
		int x = c.getXInt();
		int y = c.getYInt();
		int nbVoisinsVivants = 0;
		 EtatJ etat = EtatJ.Mort;

		// On compte le nombre de voisin vivant
		for(int i=1; i<9; i++){
			if (getVoisin(c, i).estVivante()) nbVoisinsVivants++;
		}

		switch (nbVoisinsVivants){
		case 0: case 1: case 4: case 5: case 6: case 7: case 8:
			etat = EtatJ.Mort;
			break;
		case 3:
			etat = EtatJ.Vivant;
			break;
		case 2:
			etat = (EtatJ)c.getEtat();
			break;
		}

		this.grilleSuiv[x][y].setEtat(etat);
	}
}
