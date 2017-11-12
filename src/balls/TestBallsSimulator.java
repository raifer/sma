/**
 * @author picardv
 */

package balls;
import gui.GUISimulator;
import java.awt.Color;

public class TestBallsSimulator {

    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(600, 700, Color.BLACK);
        gui.setSimulable(new BallsSimulator(gui));
    }

}
