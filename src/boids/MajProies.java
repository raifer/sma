package boids;

import evenements.Event;

public class MajProies extends Event {

	PredateursProiesSimulator PPSim;
	
	public MajProies(long d, PredateursProiesSimulator PPSim) {
		super(d);
		this.PPSim=PPSim;
	}

	@Override
	public void execute() {

		this.PPSim.proies.updateBoidsPostion();
		this.PPSim.drawFlock();
		this.PPSim.manager.addEvent(new MajProies(this.PPSim.manager.getCurrentDate()+1,this.PPSim));
		
	}

}
