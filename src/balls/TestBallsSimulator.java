

package balls;
import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;

import evenements.EventManager;

public class TestBallsSimulator {

	private static Scanner scN;

    public static void main(String[] args) {
    	
    	scN = new Scanner(System.in);
    	System.out.println("Veuillez saisir le nombre de Balles que vous souhaitez voir s'animer:");
    	int nbBalls = scN.nextInt();

    	System.out.println("");
    	System.out.println("Vous avez choisi de voir "+ nbBalls +" balles s'annimer !");
    	
    	EventManager manager = new EventManager(0);
    	
        GUISimulator gui = new GUISimulator(600, 700, Color.BLACK);
        gui.setSimulable(new BallsSimulator(gui,nbBalls,manager));
    }

}
