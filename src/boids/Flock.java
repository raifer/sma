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
	private double movementFactor = 1000; 		//Used in rule 1
	private double boundingFactor = 10; 		//Used in rule 1
	private int seperationDistance = 13;		//Used in rule 2
	private double seperationFactor = 50; 	//Used in rule 2

	public Flock(int width, int height) {
this.width = width;
		this.height = height;
		//Random numbers scatters boids start positions
		Random randNum = new Random();
		RandomName randName = new RandomName();

		for(int i = 0; i < 25; i++) {
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
	 * Updates the position coordinates of each boid in the flock. By applying the rules that govern 
	 * the behaviour of the group to each one in turn.
	 */
	public void updateBoidsPostion() {
		Vector v1, v2, v3, v4, v5 = new Vector();
		for (Boid cBoid : boids) {

			v1 = groupFlock(cBoid);
			v2 = collisionAvoidance(cBoid);
			v3 = matchFlockVelocity(cBoid);
			v4 = bounding(cBoid);
			v5 = positionTend(cBoid);

			Vector sum = new Vector();
			sum = sum.add(v1);
			sum = sum.add(v2);
			sum = sum.add(v3);
			sum = sum.add(v4);
			//sum = sum.add(v5);

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
				Vector xD = aPosition.distance(cPosition);

				if( xD.abs() < seperationDistance ) {
					correction = correction.subtract(xD).division(seperationFactor);
				}

			}
		}
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
		int xMin = 0, xMax = 1200, yMin = 0, yMax = 900;

		Vector cPos = cBoid.getPosition();
		int xD=0, yD=0;
		if (cPos.getX() < xMin) {
			xD = 1;
		} else if (cPos.getX() > xMax){
			xD = -1;
		}
		if (cPos.getY() < yMin) {
			yD = 1;
		} else if (cPos.getY() > yMax){
			yD = -1;
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
	private Vector positionTend(Boid cBoid) {
		Vector place = new Vector(600,450);	//Sample coordinates in the centre of the screen
		Vector tend = new Vector();

		tend = new Vector(place.subtract(cBoid.getPosition()));
		tend.division(100);		//Movement factor moving the boid a percentage of the distance to the attration point

		return tend;
	}
}
