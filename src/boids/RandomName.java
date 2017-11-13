package boids;
import java.util.ArrayList;
import java.util.Random;


public class RandomName {
	private Random randomGenerator;
	private ArrayList<Integer> usedList;
	private String[] nameBank =  { "Alpha",
			"Bravo",
			"Charlie",
			"Delta",
			"Echo",
			"Foxtrot",
			"Golf",
			"Hotel",
			"India",
			"Juliet",
			"Kilo",
			"Lima",
			"Mike",
			"November",
			"Oscar",
			"Papa",
			"Quebec",
			"Romeo",
			"Sierra",
			"Tango",
			"Uniform",
			"Victor",
			"Whiskey",
			"X-ray",
			"Yankee",
			"Zulu" };
	
	public RandomName() {
		randomGenerator = new Random();
		usedList = new ArrayList<Integer>();
	}

	/**
	 * Returns a name from the stored list
	 * 
	 * @return	String
	 */
	public String getName() {
		return nameBank[getIndex()];
	}

	/**
	 * Returns a random int representing a index for name that does not appear in the used list
	 * @return	int
	 */
	private int getIndex() {
		int i = randomGenerator.nextInt(nameBank.length);
		
		while(usedList.contains(i)) {
			if(usedList.size() >= nameBank.length ) {
				usedList.clear();
			}
			
			i = randomGenerator.nextInt(nameBank.length);
		}
		
		usedList.add(i);
		
		return i;
	}
	
	/**
	 * Adds a single string to the end of the bank of stored names
	 * 
	 * @param add	New string to be added
	 */
	public void addName(String add) {
		nameBank[nameBank.length+1+1] = add;	
	}
	
	/**
	 * Adds a string array to the bank of stored names
	 * 
	 * @param add	New string to be added	
	 */
	public void addName(String[] add) {
		for(int i = 0; i < add.length; i++) {
			nameBank[nameBank.length+1] = add[i];			
		}
		
	
	}
}
