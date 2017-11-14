package boids;

import evenements.Event;

public class MajFlock extends Event {

	FlockSimulator FlockSim;
	
	public MajFlock(long d, FlockSimulator FSim) {
		super(d);
		this.FlockSim=FSim;
	}

	@Override
	public void execute() {
		
		this.FlockSim.flock.updateBoidsPostion();
		this.FlockSim.drawFlock();
		this.FlockSim.manager.addEvent(new MajFlock(this.FlockSim.manager.getCurrentDate()+1,this.FlockSim));
		
	}
	
}
