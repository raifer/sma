package evenements;

/**
 * Evenement de test sous forme de message
 * Ping Pong
 *
 */

public class MessageEvent extends Event {
	private String message;
	
	public MessageEvent(int date, String message) {
		super(date);
		this.message = message;
	}
	
	public void execute() {
		System.out.println(this.getDate() + this.message);
	}

	@Override
	public int compareTo(Event e) {
		return super.compareTo(e);
	}
}
