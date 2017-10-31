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
		int k = 3;
		int nbCouleurs = 4;
		int nbVacantes = 20;
		int nbLignes = 10;
		int nbColonnes = 10;
		
		//SchellingSimulator cS = new SchellingSimulator(gui, k, nbCouleurs, nbVacantes);
		SchellingSimulator cS = new SchellingSimulator(gui, k, nbCouleurs, nbVacantes, nbLignes, nbColonnes);
        gui.setSimulable(cS); // test avec seuil 3 et 4 couleurs
	}

}
