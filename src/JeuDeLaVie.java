    
public class JeuDeLaVie {
	private static final int NB_LIGNES = 10;
	private static final int NB_COLONNES = 10;
	
	private Cellule[][] grilleCour = new Cellule[NB_LIGNES][NB_COLONNES];
	private Cellule[][] grilleSuiv = new Cellule[NB_LIGNES][NB_COLONNES];
	
	public JeuDeLaVie() {
		
	}
		
	//A mettre dans le constructeur avec random
	//Faire une boucle qui copie le tableau : voir balls.Ori
	//Un tableau t un tableau t+1
	//Claire : Faire le constructeur 
	
 
	
	
	
	

	private Cellule getVoisin(Cellule c, int position){
		
		int x=0, y=0;
		switch (position) {
		case 1:
			x = c.getX()+1;
			y = c.getY()-1;
			break;
		case 2:
			x = c.getX()+1;
			y = c.getY();
			break;
		case 3:
			x = c.getX()+1;
			y = c.getY()+1;
			break;
		case 4:
			x = c.getX();
			y = c.getY()+1;
			break;
		case 5:
			x = c.getX()-1;
			y = c.getY()+1;
			break;
		case 6:
			x = c.getX()-1;
			y = c.getY();
			break;
		case 7:
			x = c.getX()-1;
			y = c.getY()-1;
			break;
		case 8:
			x = c.getX();
			y = c.getY()-1;
			break;
		default:
			throw new IllegalArgumentException("La position du voisin doit être compris entre 1 et 8");
			break;
		}
		if (x< 0) x = NB_LIGNES-1;
		if (x == NB_LIGNES) x = 0;
if (y < 0) y = NB_COLONNES-1;
if (y == NB_COLONNES) y = 0;

	return this.getCellule(x, y);
	}
	
	public Cellule getCellule(int x, int y){
		return this.grilleCour[x][y];
	}
}
