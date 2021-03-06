package boids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flock {
	
	/** Largeur et heuteur où va pouvoir évoluer le troupeau*/
	private int width, height;
	
	/** List qui va contenir les boids évoluants au cours de la simu */
	private List<Boid> boids = new ArrayList<Boid>();
	/** Sauvegarde de la liste des boids pour la remise à zéro */
	private List<Boid> boidsOri = new ArrayList<Boid>();
	
	/** Paramètre du Flock */
	private double coefFiltreVelocity = 1;
		
	/**Règle 1 : Déplacement vers le centre du groupe.*/
	private double groupCenterFactor = 800;
	/** Règle 2 : Séparation entre les boids.*/
	private int seperationDistance = 80;
	private double seperationFactor = 20;
	/**Règle 4 : Evite le bord de la fenêtre de simulation*/
	private int boundingDistance = 80;
	private double boundingFactor = 20;
	/** Règle 5 : Attraction vers la nourriture*/
	private double attractionFactor = 2000;
	private Vector food = new Vector(100, 100);
	
	
	/**
	 * Constructeur par défaut avec 5 boids
	 * @param width
	 * @param height
	 */
	public Flock(int width, int height) {
		this(width, height, 5);
	}
	
	/**
	 * Constructeur avec choix de largeur, hauteur et nombre de boids
	 * Coefficient de groupe par défaut réglé à 800
	 * 
	 * @param width
	 * @param height
	 * @param nb_boids
	 */
	public Flock(int width, int height, int nb_boids) {
		this(width,height,5,800);
	}
	
	/**
	 * Constructeur avec choix de la largeur et hauteur de l'environnement,
	 * du nombre de boids et du coefficient GroupFact
	 * 
	 * @param width
	 * @param height
	 * @param nb_boids
	 * @param fact
	 */
	public Flock(int width, int height, int nb_boids, double fact) {
		this.width = width;
		this.height = height;
		this.setGroupFact(fact);
		//Règle 1 : Déplacement vers le centre du groupe.
		groupCenterFactor = 800;
		// Règle 2 : Séparation entre les boids.
		seperationDistance = 80;
		seperationFactor = 20;
		//Règle 4 : Evite le bord de la fenêtre de simulation
		boundingDistance = 80;
		boundingFactor = 20;
		// Règle 5 : Attraction vers la nourriture
		setAttractionFactor(20);
		food = new Vector(500, 100);
		
		//Random numbers scatters boids start positions
		Random randNum = new Random();
		RandomName randName = new RandomName();

		for(int i = 0; i < nb_boids; i++) {
			int  x = randNum.nextInt(this.width) + 1;
			int  y = randNum.nextInt(this.height) + 1;

			boids.add(new Boid(x,y, randName.getName() ));
			boidsOri.add(new Boid(x,y, randName.getName() ));
		}
	}
	
	public void setFood(Vector food) {
		this.food = food;
	}
	
	public void setGroupFact(double fact) {
		this.groupCenterFactor=fact;
	}
	
	public void setCoefVelocity(double coef) {
		this.coefFiltreVelocity=coef;
	}
	
	public void reInit() {
		this.boids.clear();
		this.boids.addAll(this.boidsOri);
	}

	public List<Boid> getBoids() {
		return this.boids;
	}

	/**
	 * Calcul et met à jour la position des boids
	 */
	public void updateBoidsPostion() {
		Vector v1, v2, v3, v4, v5 = new Vector();
		for (Boid cBoid : boids) {

			v1 = groupFlock(cBoid);
			v2 = collisionAvoidance(cBoid);
			v3 = matchFlockVelocity(cBoid);
			v4 = bounding(cBoid);
			v5 = pointAttraction(cBoid);

			Vector sum = new Vector();
			// GroupFlock
			sum = sum.add(v1);
			// Collision avoidance
			sum = sum.add(v2);
			// Match Flock Velocity
		//	sum = sum.add(v3);
			// Bouding Avoidance
			sum = sum.add(v4);
			 // Food attraction
			sum = sum.add(v5);

			cBoid.setVelocity(cBoid.getVelocity().division(this.coefFiltreVelocity).add(sum));
			cBoid.applyVelocity();
		}//end iteration through flock
	}

	/**
	 * Rule 1: Groups the boids together
	 * 
	 * Returns a vector representing the boids perceived centre of the group (Average position of all boids not including the boid itself).
	 * A movement factor is applied to move the boid a percentage of the way towards the center.   
	 * 
	 * @param	cBoid	The boid which the rule is applied to
	 * @return Vector	Grid position moving the boid towards the center of the group
	 * 
	 */
	private Vector groupFlock(Boid cBoid) {
		Vector center = new Vector();

		for (Boid aBoid : boids) {
			if(!aBoid.equals(cBoid)) {
				center = center.add(aBoid.getPosition());
			}
		}
		center = center.division(boids.size() - 1 );
		center = center.subtract(cBoid.getPosition());
		center = center.division(groupCenterFactor);

		return center;   
	}

	/**
	 * Rule 2: Collision Avoidance
	 * 
	 *  Checks to see if the boid is within a specified distance of other boids by comparing the position coordinates of each. If the flock mate 
	 *  is inside the minimum distance,  the vector is updated to move the boid further away by half of the current distance between the two.
	 *  
	 * 	@param	cBoid	The boid which the rule is applied to
	 *  @return	Vector	Grid coordinates of a position that would take the boid away from each flock mate that is too close. 
	 *  
	 */
	private Vector collisionAvoidance(Boid cBoid) {
		Vector correction = new Vector();
		Vector cPosition = new Vector(cBoid.getPosition());

		for (Boid aBoid : boids) {
			if (!aBoid.equals(cBoid)) {
				Vector aPosition = aBoid.getPosition();
				Vector dist = aPosition.distance(cPosition);

				if( dist.abs() < seperationDistance ) {
					correction = correction.subtract(dist);
				}

			}
		}
		correction = correction.division(seperationFactor);
		return correction;
	}

	/**
	 * Rule 3: Match flock velocity
	 * 
	 * Returns a vector representing the boids perceived average velocity of the flock, not including the boid itself. 
	 * 
	 * @param	cBoid	The boid which the rule is applied to
	 *  @return	Vector	Perceived velocity of the flock as a group 
	 */
	private Vector matchFlockVelocity(Boid cBoid) {
		Vector perceivedVelocity = new Vector();

		for(Boid aBoid : boids) {
			if(!aBoid.equals(cBoid)) {
				perceivedVelocity = perceivedVelocity.add(aBoid.getVelocity());
			}
		}
		perceivedVelocity = perceivedVelocity.division(boids.size() - 1);
		perceivedVelocity = perceivedVelocity.subtract(cBoid.getVelocity());
		perceivedVelocity = perceivedVelocity.division(8);
		return perceivedVelocity;
	}

	/**
	 * Rule 4: Bounding the position.
	 * 
	 * Encourages the boid to remain in the view frame. 
	 * 
	 * 	@param	cBoid	The boid which the rule is applied to 
	 * 	@return	Vector	A grid position moving the boid towards the view frame.
	 */
	private Vector bounding(Boid cBoid) {
		Vector bound = new Vector();
		int border = 100;
		int xMin = border, xMax = this.width- border; 
		int yMin = border, yMax = this.height- border;

		Vector cPos = cBoid.getPosition();
		double  x = cPos.getX();
		double  y = cPos.getY();
		double xD=0, yD=0;
		
		if (x < xMin) {
			xD = xMin - x;;
		} else if (x > xMax){
			xD = xMax - x;;
		}
		if (y < yMin) {
			yD = yMin - y;;
		} else if (y > yMax){
			yD = yMax - y;
		}

		bound.translate(xD, yD);

		bound = bound.division(boundingFactor);

		return bound;
	}

	/**
	 * Rule 5: Tend towards Position
	 * 
	 * Draws the boids towards points of attraction. Acts as a goal for boids helping to provide more predictable group behaviour.
	 * 
	 * @param cBoid	The boid which the rule is applied to
	 * @return	Vector	A grid position moving the boid towards points of attraction
	 */
	private Vector pointAttraction(Boid cBoid) {

		Vector tend = new Vector();
		tend = this.food.distance(cBoid.getPosition());
		int max = 20;
		if (tend.getX() > max) tend.setX(max);;
		if (tend.getX() < -max) tend.setX(-max);;
		if (tend.getY() > max) tend.setY(max);;
		if (tend.getY() < -max) tend.setY(-max);;
		tend = tend.division(this.getAttractionFactor());
		return tend;
	}
	
	public String toString() {
		String s = new String();
		for (Boid b : this.boids) {
			s += b.toString();
			s += "\n";
		}
		return s;
	}

	public double getAttractionFactor() {
		return attractionFactor;
	}

	public void setAttractionFactor(double attractionFactor) {
		this.attractionFactor = attractionFactor;
	}
	
}
