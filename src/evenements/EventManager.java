package evenements;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Gestionnaire d'évènement utilisé dans balls, boids et evenements
 *
 */

public class EventManager {

	/** Date courrante du manager */
	private long currentDate;
	
	/** File des évènements triée par priorité = par date*/
	Queue<Event> EventQueue = new PriorityQueue<Event> ();
	
	
	/**
	 * Constructeur du manager par défaut sans évènements
	 * @param d
	 */
	public EventManager(long d) {
		this.setCurrentDate(d);
	}
	
	/**
	 * Constructeur de manager 
	 * @param d la date courrante du manager
	 * @param e un évènement à ajouter à l'EventQueue
	 */
	public EventManager(long d, Event e) {
		this.setCurrentDate(d);
		this.EventQueue.add(e);
	}
	
	public long getCurrentDate() {
		return this.currentDate;
	}
	public void setCurrentDate(long d) {
		this.currentDate=d;
	}
	
	/**
	 * Ajoute un évènement à l'EventQueue
	 * 
	 * @param e évènement à ajouté
	 */
	public void addEvent(Event e) {
		this.EventQueue.add(e);
	}
	
	/**
	 * Incrémente la date courante du manager
	 * de 1 et réalise les évènements de l'EventQueue 
	 * jusqu'à cette nouvelle date courante
	 */
	public void next() {
		//
		Event currEvent = this.EventQueue.remove();
		this.setCurrentDate(this.getCurrentDate()+1);
		while (currEvent.getDate()<=this.currentDate){
			currEvent.execute();
			currEvent = this.EventQueue.remove();
		}
		this.addEvent(currEvent);
	}
	
	/**
	 * 
	 * @return true si il n'y a plus d'évènements
	 * à traiter
	 */
	public boolean isFinished() {
		if(this.EventQueue.isEmpty()) {
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Réinitialise le manager à la date 0
	 */
	public void restart() {
		this.setCurrentDate(0);
	}
	
	
}
