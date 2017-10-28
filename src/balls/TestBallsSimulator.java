package balls;
import gui.GUISimulator;
import java.awt.Color;

public class TestBallsSimulator {

    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        gui.setSimulable(new BallsSimulator(gui));
        /*
        for (int i = 100 ; i < 500 ; i += 100) {
            gui.addGraphicalElement(
                    new Oval(i, 250,
                            Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10)) ;
        }
         */
    }

}
