package automate;
import java.awt.Color;
import java.util.Scanner;

import gui.GUISimulator;

/**
 * Teste de l'automate Immigration.
 *
 */
public class TestImmigrationSimulator {

	private static Scanner scL;
	private static Scanner scE;
	private static Scanner scC;

	public static void main(String[] args) {
		
		scE = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre d'état :");
		int nbEtat = scE.nextInt();
		
		scL = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de lignes de cette grille :");
		int nbLignes = scL.nextInt();
		
		scC = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de colonnes de cette grille :");
		int nbColonnes = scC.nextInt();
		

		System.out.println("");
		System.out.println("Vous avez initialisé un grille de jeu de l'immigrtion"
				+ " de "+nbLignes+"x"+nbColonnes+" contenant "+nbEtat+" états.");
		
		GUISimulator gui = new GUISimulator(700,600, Color.BLACK);
        gui.setSimulable(new ImmigrationSimulator(gui,nbEtat,nbLignes,nbColonnes));
	}

}
