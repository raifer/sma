package boids;



public class Boid {
	/**
	 * Le vector position représente la position du boids  
	 */
	protected Vector position;
    
	
	/**
	 *Vector représentant la velocité du boid 
	 */
	protected Vector velocity;
    
	/**
	 *Angle en degré du boid 
	 */
	protected double angle;
	
	/**
	 * Vitesse maximale du boid
	 * 
	 */
	protected final double speedMax = 3;
    
	protected String name;

    /**
     * Init le boid à la position donnée
     * 
     * @param x X Position
     * @param y	Y Position
     */
	public Boid(int x, int y, String n) {
		this.position = new Vector(x, y);
		this.velocity = new Vector(0,0);
		
		if( n != null) {
			this.name = n;
		}
    }
	
	/**
	 * Returns a Vector object with the boids x, y position coordinates
	 * 
	 * @return	Vector
	 * 
	 */
	public Vector getPosition() {
		return new Vector(position.x, position.y);
	}
	 
    public Vector getVelocity() {
		return velocity;
	}

    /**
     * Set the boid velocity
     *  
     * @param velocity a Vector object with the boids x, y coordinates
     * 
     */
	public void setVelocity(Vector velocity) {		
		if ( velocity.x > speedMax) {
			velocity.x = speedMax;
		}
		if ( velocity.x < -speedMax) {
			velocity.x = -speedMax;
		}
		if ( velocity.y > speedMax) {
			velocity.y = speedMax;
		} 
		if ( velocity.y < -speedMax) {
			velocity.y = -speedMax;
		}
		
		this.velocity = velocity;
	}
	
	/**
	 * Set the position of the boid.
	 * 
	 * @param position	A Vector object with a grid position
	 */
	public void setPosition(Vector pos) {
		setAngle(this.position, pos);
		this.position = pos;
	}
	
	/**
	 * Returns an 360 degree angle representing the boids direction of travel.
	 * 
	 * The cartesian coordinates accepted as arguments are converted to 
	 * polar coordinates and converted to an angle. Based on the boids current 
	 * and next position. 
	 * 
	 * @param current position of the boid
	 * @param next position the boid will be moving too
	 */
	public void setAngle(Vector current, Vector next) {
		// calc the deltas as next minus current
		double delta_x = next.x - current.x;
		double delta_y = next.y - current.y;
		Double theta = Math.atan2(delta_y, delta_x);	

		// Change this.angle is into degrees
		this.angle = theta*180/Math.PI;
		
	}
	
	public String getName() {
		return this.name;
	}

	public void applyVelocity() {
		this.position.translate(this.velocity);
	}
	
	public String toString() {
		String s = new String();
		s += this.getName();
		s += " ";
		s += this.getPosition().toString();
		s += " - ";
		s += this.getVelocity();
		return s;
	}
	
}
