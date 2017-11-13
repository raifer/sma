package automate;



public class Immigration extends AutomateCellulaire {

	private int n ; // Nombre d'états
	
	/**
	 * Constructeur par défaut
	 * Le nombre d'état du jeu est de 4
	 */
	public Immigration(){
		this.setN(4);
	}
	
	/**
	 * Constructeur
	 * @param Le nombre d'état du jeu
	 * @param Le nombre de lignes
	 * @param Le nombre de colonnes
	 */
	public Immigration(int n,int nbLignes,int nbColonnes){
		super(nbLignes,nbColonnes);
		this.setN(n);
		this.InitEtat();
	}
	
	/**
	 * Get
	 * @return nombres d'états du jeu
	 */
	public int getN(){
		return this.n;
	}
	
	/**
	 * Set
	 * @param nombre d'états du jeu
	 */
	public void setN(int n){
		if (n>9|| n < 1){
			throw new IllegalArgumentException("Le jeu ne peut contenir que de 1 à 9 états");
//			return Color.red;
		}
		else {
			this.n=n;
		}
	}
	
	/**
	 * Trouve un entier alétoire compris entre 0 et n-1
	 * Où n est le nombre d'états du jeu
	 */
	@Override
	int randomEtat() {
		return randomGenerator.nextInt(this.n);
	}

	/**
	 * Mise à jour des cellules selon les règles du jeu de l'immigration.
	 */
	@Override
	void majCellule(Cellule c) {
		int x = c.getXInt();
		int y = c.getYInt();
		int etatSuiv = ((c.getEtat()+1)%this.n);
		int cpt = 0;
		Cellule cVoisin;

		// On compte le nombre de voisin dans l'état supérieur
		for (int i=1;i<9;i++){
			cVoisin = getVoisin(c, i);
			if (cVoisin.getEtat()==etatSuiv) cpt++;
		}
		
		if (cpt>=3){
			this.setEtatSuiv(x, y, etatSuiv); // S'il y a 3 voisins ou plus dans l'état supérieur, on passe dans celui-ci.
		}
		else {
			this.setEtatSuiv(x, y, c.getEtat()); // Sinon on reste dans le même état.
		}
	}
}
