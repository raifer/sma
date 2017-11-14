package boids;

import evenements.Event;

public class MajPredateurs extends Event {

	PredateursProiesSimulator PPSim;
	
	public MajPredateurs(long d, PredateursProiesSimulator PPSim) {
		super(d);
		this.PPSim=PPSim;
	}

	@Override
	public void execute() {

		this.PPSim.predateurs.updateBoidsPostion();
		this.PPSim.drawFlock();
		this.PPSim.manager.addEvent(new MajPredateurs(this.PPSim.manager.getCurrentDate()+2,this.PPSim));
		
	}

}
