package boids;

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
		this.setCurrentDate(this.getCurrentDate()+5);
		while (!this.isFinished()){
			this.EventQueue.remove().execute();
		}
	}
	
	public boolean isFinished() {
		if(this.EventQueue.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	public void restart() {
		this.setCurrentDate(0);
	}
	
	
}
