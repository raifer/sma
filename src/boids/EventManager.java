package boids;

class EventManager {
	//Variables
	private long currentDate;
	private Event[] EventSequence; 
	
	//Get/Set
	public long getCurrentDate() {
		return this.currentDate;
	}
	public void setCurrentDate(long date) {
		this.currentDate = date;
	}
	
	//Constructeur
	public EventManager(long date) {
		setCurrentDate(date);
	}
	
	public void addEvent(e : Event) {
		
	}
	public void next() {
		
	}
	public boolean isFinished() {
		
	}
	public void restart() {
		
	}
}
