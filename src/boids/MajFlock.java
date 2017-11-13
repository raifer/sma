package boids;

import balls.BallsSimulator;
import evenements.Event;

public class MajFlock extends Event {

	FlockSimulator FlockSim;
	
	public MajFlock(long d, FlockSimulator FSim) {
		super(d);
		this.FlockSim=FSim;
	}

	@Override
	public void execute() {
		
		this.FlockSim.getFlock().updateBoidsPostion();
		this.FlockSim.drawFlock();
		this.FlockSim.getManager().addEvent(new MajFlock(this.FlockSim.getManager().getCurrentDate()+1,this.FlockSim));
		
	}
	
}
