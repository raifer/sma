package boids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 
 * 
 * @author Mathieu
 *
 */
public class Flock {
	
	/** Largeur et heuteur où va pouvoir évoluer le troupeau*/
	private int width, height;
	/** List qui va contenir les boids évoluants au cours de la simu */
	private List<Boid> boids = new ArrayList<Boid>();
	/** Sauvegarde de la liste des boids pour la remise à zéro */
	private List<Boid> boidsOri = new ArrayList<Boid>();
	
	// Paramètre de la simu
	private final double movementFactor = 1000; 		//Used in rule 1
	private final int seperationDistance = 80;		//Used in rule 2
	private final double seperationFactor = 20; 	//Used in rule 2
	private final double boundingFactor = 20; 		//Used in rule 4
	private final double attractionFactor = 2000;
	
	private Vector food = new Vector(100, 100);
	
	public Flock(int width, int height) {
		this(width, height, 5);
	}
	
	public Flock(int width, int height, int nb_boids) {
this.width = width;
		this.height = height;
		//Random numbers scatters boids start positions
		Random randNum = new Random();
		RandomName randName = new RandomName();

		for(int i = 0; i < nb_boids; i++) {
			// Je ne comprend pas le +1 qui était là
			int  x = randNum.nextInt(this.width) + 1;
			int  y = randNum.nextInt(this.height) + 1;

			boids.add(new Boid(x,y, randName.getName() ));
			boidsOri.add(new Boid(x,y, randName.getName() ));
		}
	} // end constructor

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
			sum = sum.add(v1);
			sum = sum.add(v2);
//			sum = sum.add(v3);
			sum = sum.add(v4);
			sum = sum.add(v5);

			
			cBoid.setVelocity(cBoid.getVelocity().add(sum));
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
				center.translate(aBoid.getPosition());
			}
		}
		center = center.division(boids.size() - 1 );
		center = center.subtract(cBoid.getPosition());
		center = center.division(movementFactor);

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
		tend = tend.division(this.attractionFactor);
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
	
}
