package boids;

import evenements.Event;

public class MajFlock extends Event {

	FlockSimulator FlockSim;
	
	/**
	 * Constructeur par défaut
	 * @param d date de l'évènement MajFlock créé
	 * @param FSim le Simulateur de Flock dans lequel s'éxécutent les évènements
	 */
	public MajFlock(long d, FlockSimulator FSim) {
		super(d);
		this.FlockSim=FSim;
	}

	/**
	 * (non-Javadoc)
	 * @see evenements.Event#execute()
	 */
	@Override
	public void execute() {
		
		this.FlockSim.flock.updateBoidsPostion();
		this.FlockSim.drawFlock();
		this.FlockSim.manager.addEvent(new MajFlock(this.FlockSim.manager.getCurrentDate()+1,this.FlockSim));
		
	}
	
}
