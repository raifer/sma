package boids;

import evenements.Event;

/**
 * Evenement de mise à jour des positions des boids du flock de proies
 * avec ajout à la volée tous les pas de temps
 *
 */

public class MajProies extends Event {

	PredateursProiesSimulator PPSim;
	
	
	/**
	 * Constructeur par défaut
	 * @param d date de l'évènement MajProies
	 * @param PPSim simulateur dans lequel s'éxécutent les évènements
	 * 		  de MajProies
	 */
	public MajProies(long d, PredateursProiesSimulator PPSim) {
		super(d);
		this.PPSim=PPSim;
	}

	/**
	 * (non-Javadoc)
	 * @see evenements.Event#execute()
	 */
	@Override
	public void execute() {

		this.PPSim.proies.updateBoidsPostion();
		this.PPSim.manager.addEvent(new MajProies(this.PPSim.manager.getCurrentDate()+1,this.PPSim));
		
	}

}
