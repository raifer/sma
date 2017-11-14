package automate;
import java.awt.Color;
import java.util.Scanner;

import gui.GUISimulator;


/**
 * Permet de tester la simulation de l'automate du jeux de la vie.
 *
 */
public class TestJDLVSimulator {
	private static Scanner scL;
	private static Scanner scC;

	public static void main(String[] args) {

	scL = new Scanner(System.in);
	System.out.println("Veuillez saisir le nombre de lignes de cette grille :");
	int nbLignes = scL.nextInt();
	
	scC = new Scanner(System.in);
	System.out.println("Veuillez saisir le nombre de colonnes de cette grille :");
	int nbColonnes = scC.nextInt();
	

	System.out.println("");
	System.out.println("Vous avez initialisé un grille de jeu de la vie"
			+ " de "+nbLignes+"x"+nbColonnes);
	
	GUISimulator gui = new GUISimulator(700,600, Color.BLACK);
    gui.setSimulable(new JeuDeLaVieSimulator(gui,nbLignes,nbColonnes));
	}

}
