    
public class JeuDeLaVie {
	private static final int NB_LIGNES = 10;
	private static final int NB_COLONNES = 10;
	
	private Cellule[][] grilleCour = new Cellule[NB_LIGNES][NB_COLONNES];
	private Cellule[][] grilleSuiv = new Cellule[NB_LIGNES][NB_COLONNES];
	private Cellule[][] grilleOri = new Cellule[NB_LIGNES][NB_COLONNES];
	
	public int getNbLignes() {
		return JeuDeLaVie.NB_LIGNES;
	}
	public int getNbColonnes() {
		return JeuDeLaVie.NB_COLONNES;
	}
	
	//Constructeur
	public JeuDeLaVie() {
		double p;
		for (int i=0; i<NB_LIGNES; i++) {
			for (int j=0; j<NB_COLONNES; j++){
				p = Math.random();
				if (p>0.5) {
					this.grilleCour[i][j].setEtat(Etat.VIVANT);
				}
				else
					this.grilleCour[i][j].setEtat(Etat.MORT);
			}
		}
		
		//Copie 
		for (int i=0; i<NB_LIGNES; i++) {
			for (int j=0; j<NB_COLONNES; j++){
				this.grilleOri[i][j].setEtat(this.grilleCour[i][j].getEtat());
			}
		}
	}
		
	
 
	
	
	
	
	
	
}
