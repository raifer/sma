package balls;
import java.awt.Color;
import java.awt.Point;

import evenements.Event;
import evenements.EventManager;
import gui.GUISimulator;
import gui.Oval;

public class MajBalls extends Event {

	Balls lesBalles;
    private GUISimulator gui;
    EventManager manager;
	
	public MajBalls(long d, Balls balles, GUISimulator gui, EventManager manager) {
		super(d);
		this.lesBalles=balles;
		this.gui=gui;
		this.manager=manager;
	}
	
	@Override
	public void execute() {
		this.lesBalles.translate();
		this.gui.reset();
        for (int i=0; i< this.lesBalles.getNbBalls(); i++){
            Point ball = this.lesBalles.getBall(i);
            gui.addGraphicalElement(
                    new Oval((int)ball.getX(), (int)ball.getY(),
                            Color.decode("#1f77b4"), Color.decode("#1f77b4"), 
                            25, 25));
        }
        
    	this.manager.addEvent(new MajBalls(this.manager.getCurrentDate()-1,this.lesBalles,this.gui, this.manager));

	}
	}
