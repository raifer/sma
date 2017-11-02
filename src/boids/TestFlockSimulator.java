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
		int width = 1500;
		GUISimulator gui = new GUISimulator(height, width, Color.BLACK);
FlockSimulator flockSimu = new FlockSimulator(gui);
        gui.setSimulable(flockSimu);

	}

}
