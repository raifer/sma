/**
 * 
 */
package boids;

/**
 * @author Mathieu
 *
 */
public class TestFlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
Flock flock = new Flock(200, 100, 2);
System.out.println(flock);
System.out.println("Step 1");
flock.updateBoidsPostion();
System.out.println(flock);
	}

}
