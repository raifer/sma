package automate;
/**
 * @author picardv
 * 
 */

import java.awt.Color;


import gui.GUISimulator;

public class TestSchellingSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        gui.setSimulable(new SchellingSimulator(gui,3,4)); // test avec seuil 3 et 4 couleurs
	}

}
