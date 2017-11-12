package boids;

import java.awt.Color;

import gui.GUISimulator;

public class TestPPSimulator {

	public static void main(String[] args) {

		int height = 1000;
		int width = 1600;
		GUISimulator gui = new GUISimulator(width, height, Color.BLACK);
		PredateursProiesSimulator flockSimu = new PredateursProiesSimulator(gui);
        gui.setSimulable(flockSimu);
		
	}

}
