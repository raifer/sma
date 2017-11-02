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
		
		int height = 1500;
		int width = 2000;
		GUISimulator gui = new GUISimulator(height, width, Color.BLACK);
FlockSimulator flockSimu = new FlockSimulator(gui);
        gui.setSimulable(flockSimu);

	}

}
