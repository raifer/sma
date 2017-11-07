package boids;

public abstract class Event {
	
	private long date;
	
	/*
	 * Les getters setters de la date
	 */
	public long getDate() {
		return this.date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	/*
	 * L'éxecution de l'évènement à définir
	 *  dans les sous-classes
	 */
	public void execute() {
		
	}
	
	/*
	 * Le constructeur
	 */
	public void Event(long date) {
		setDate(date);
	}
}
