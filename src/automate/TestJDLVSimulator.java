package automate;

import java.awt.Color;


import gui.GUISimulator;

public class TestJDLVSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
		JeuDeLaVie monAuto = new JeuDeLaVie();
        gui.setSimulable(new AutomateSimulator<JeuDeLaVie>(monAuto,  gui));
	}

}
