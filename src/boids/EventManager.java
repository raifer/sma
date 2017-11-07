package boids;

class EventManager {
	//Variables
	private long currentDate;
	private int pas;
	private Event[] eventSequence; 
	
	//Get/Set
	public long getCurrentDate() {
		return this.currentDate;
	}
	public void setCurrentDate(long date) {
		this.currentDate = date;
	}
	public int getPas() {
		return this.pas;
	}
	public void setPas(int p) {
		this.pas = p;
	}
	
	//Constructeur
	public EventManager(long date) {
		setCurrentDate(date);
	}
	
	public void addEvent(Event e) {
		//this.eventSequence[e.getDate()]=e; Comment indexer un tableau en long et non en int ?
	}
	
	/*
	 * On exécut les évènements à réaliser en un pas de temps
	 */
	public void next() {
		
	}
	public boolean isFinished() {
		return true;
	}
	public void restart() {
		
	}
}
