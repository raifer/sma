package automate;
import java.awt.Color;
import java.util.Scanner;

import gui.GUISimulator;

public class TestSchellingSimulator {


	private static Scanner scL;
	private static Scanner scCoul;
	private static Scanner scC;
	private static Scanner scK;

	public static void main(String[] args) {
		
		scCoul = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de couleurs :");
		int nbCouleurs = scCoul.nextInt();
		
		scK = new Scanner(System.in);
		System.out.println("Veuillez saisir le seuil de déménagement :");
		int k = scK.nextInt();
		
		scL = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de lignes de cette grille :");
		int nbLignes = scL.nextInt();
		
		scC = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de colonnes de cette grille :");
		int nbColonnes = scC.nextInt();
		

		System.out.println("");
		System.out.println("Vous avez initialisé un grille de jeu de Schelling"
				+ " de "+nbLignes+"x"+nbColonnes+" contenant "+nbCouleurs+" couleurs.");

		int nbVacantes = (3*nbLignes*nbColonnes)/10;
		
		GUISimulator gui = new GUISimulator(700,600, Color.BLACK);
        gui.setSimulable(new SchellingSimulator(gui,nbCouleurs,k,nbLignes,nbColonnes,nbVacantes));
		
	}

}
