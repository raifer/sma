package balls;
import evenements.Event;

/**
 * Evenement de mise à jour de la position des balles 
 */

public class MajBalls extends Event {

	BallsSimulator BSim;
	
	/**
	 * Constructeur 
	 * @param d la date de l'évènement à créer
	 * @param BSim le simulateur dans lequel se produit l'évènement
	 */
	public MajBalls(long d, BallsSimulator BSim) {
		super(d);
		this.BSim=BSim;
	}
	
	/**
	 * Execute l'évènement MajBalls. Réalise leur déplacement
	 * puis ajoute un nouvel évènement MajBalls à la volée.
	 */
	@Override
	public void execute() {
		this.BSim.getNosBalles().translate();       
    	this.BSim.getManager().addEvent(new MajBalls(this.BSim.getManager().getCurrentDate()+1,this.BSim));

	}
	}
