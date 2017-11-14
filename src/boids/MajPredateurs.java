package boids;

import evenements.Event;

/**
 * Evenement de mise à jour des positions des boids du flock de prédateurs
 * avec ajout à la volée tous les 2 pas de temps
 *
 */

public class MajPredateurs extends Event {

	PredateursProiesSimulator PPSim;
	
	/**
	 * Constructeur par défaut
	 * @param d date de l'évènement créé
	 * @param PPSim le simulateur dans lequel s'éxécutents les évènements MajPrédateurs
	 */
	public MajPredateurs(long d, PredateursProiesSimulator PPSim) {
		super(d);
		this.PPSim=PPSim;
	}

	/**
	 * (non-Javadoc)
	 * @see evenements.Event#execute()
	 */
	@Override
	public void execute() {

		this.PPSim.predateurs.updateBoidsPostion();
		this.PPSim.manager.addEvent(new MajPredateurs(this.PPSim.manager.getCurrentDate()+2,this.PPSim));
		
	}

}
