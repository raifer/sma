package automate;
/**
 * @author picardv
 * 
 */

import java.awt.Color;


import gui.GUISimulator;

public class TestImmigrationSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        gui.setSimulable(new ImmigrationSimulator(gui));
	}

}
