package automate;
/**
 * @author picardv
 * 
 */

import java.awt.Color;


import gui.GUISimulator;

public class TestImmigrationSimulator {

	public static void main(String[] args) {
		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        gui.setSimulable(new ImmigrationSimulator(gui,4)); // Test avec 4 états
	}

}
