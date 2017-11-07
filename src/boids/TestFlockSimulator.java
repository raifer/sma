/**
 * 
 */
package boids;

import java.awt.Color;

import gui.GUISimulator;

/**
 * @author Mathieu
 *
 */
public class TestFlockSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int height = 1000;
		int width = 1600;
		int nb_boids = 3;
		GUISimulator gui = new GUISimulator(width, height, Color.BLACK);
FlockSimulator flockSimu = new FlockSimulator(gui, nb_boids);
        gui.setSimulable(flockSimu);

	}

}
