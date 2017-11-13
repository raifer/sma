

abstract class Event {
	private long date;
	
	public Event(long d) {
		this.setDate(d);
	}
	
	public long getDate() {
		return this.date;
	}
	
	public void setDate(long d) {
		this.date = d;
	}
	
	abstract void execute();
	
	public int compareTo(Event e) {
		if(this.getDate()<e.getDate()) {
			return -1;
		}
		else if(this.getDate() == e.getDate()){
			return 0; 
		}
		else
			return 1;
	}
}
