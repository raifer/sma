package boids;

/**
 * @author Mathieu
 *
 */
public class Vector {
	
    /**
     *X position 
     */
    public double x;
    
    /**
     *Y position 
     */
    public double y;

    /**
     * New vector at position x=0, y=0
     * 
     */
    public Vector(){
    	this.x = 0;
    	this.y = 0;
    }

    /**
     * New vector at the same position as v
     * @param v
     */
    public Vector(Vector v){
    	this.x = v.x;
    	this.y = v.y;
    }
    
    /**
     * New vector at the position x, y
     * @param x
     * @param y
     */
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
    	return this.x;
    }
    
    public double getY() {
    	return this.y;
    }
    
    public void setX( double x) {
    	this.x = x;
    }
    
    public void setY( double y) {
    	this.y = y;
    }
    
    public void translate(Vector vD) {
    	this.setX(this.getX() + vD.getX());
    	this.setY(this.getY() + vD.getY());
    }
    
    public void translate(double xD, double yD) {
    	this.setX( this.getX() + xD);
    	this.setY( this.getY() + yD);
    }
    
    /**
     * Performs addition of two vector.
     * 
     * @param addVector
     * @return A vector holding the product
     */
    public Vector add(Vector addVector){
    	return new Vector(this.x += addVector.x, this.y += addVector.y );
    }
    
    /**
     * Add the given integer values
     * 
     * @param x	coordinate
     * @param y	coordinate
     * @return A vector holding the product
     */
    public Vector add(double x, double y){
    	return new Vector(this.x += x, this.y += y );
    }
    
    /**
     * subtracts the given integer values
     * 
     * @param x	coordinate
     * @param y	coordinate
     * @return A vector holding the product
     */
    public Vector subtract(double x, double y){
    	return new Vector(this.x += x, this.y += y );
    }
    
    /**
     * Performs subtraction of two vectors 
     * @param addVector
     */
    public Vector subtract(Vector subVector){
    	return new Vector(this.x = (this.x - subVector.x), this.y = (this.y - subVector.y));
    }
    
    public Vector division(double divider) {
    	return new Vector(this.x =( x / divider), this.y =( y / divider));
    }
    
    public double absX() {
    	return Math.sqrt(Math.pow(this.x, 2));
    }
    
    public double absY() {
    	return Math.sqrt(Math.pow(this.y, 2));
    }
    
    public double abs() {
    	return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

public Vector distance( Vector other) {
	 return new Vector(
			 this.getX() - other.getX(), 
			 this.getY() - other.getY());
}

}