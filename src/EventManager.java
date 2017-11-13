

import java.util.PriorityQueue;
import java.util.Queue;

public class EventManager {

	private long currentDate;
	Queue<Event> EventQueue = new PriorityQueue<Event> ();
	
	public long getCurrentDate() {
		return this.currentDate;
	}
	public void setCurrentDate(long d) {
		this.currentDate=d;
	}
	
	public void addEvent(Event e) {
		this.EventQueue.add(e);
	}
	
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
	
	public boolean isFinished() {
		if(this.EventQueue.isEmpty()) {
			return true;
		}
		else 
			return false;
	}
	
	public void restart() {
		this.setCurrentDate(0);
	}
	
	
}
