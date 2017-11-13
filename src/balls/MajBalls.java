package balls;
import java.awt.Color;
import java.awt.Point;

import evenements.Event;
import gui.Oval;

public class MajBalls extends Event {

	BallsSimulator BSim;
	
	public MajBalls(long d, BallsSimulator BSim) {
		super(d);
		this.BSim=BSim;
	}
	
	@Override
	public void execute() {
		this.BSim.getNosBalles().translate();
		this.BSim.getGui().reset();
        for (int i=0; i< this.BSim.getNosBalles().getNbBalls(); i++){
            Point ball = this.BSim.getNosBalles().getBall(i);
            this.BSim.getGui().addGraphicalElement(
                    new Oval((int)ball.getX(), (int)ball.getY(),
                            Color.decode("#1f77b4"), Color.decode("#1f77b4"), 
                            25, 25));
        }
        
    	this.BSim.getManager().addEvent(new MajBalls(this.BSim.getManager().getCurrentDate()+1,this.BSim));

	}
	}
