package evenements;

/**
 * Classe de Test pour vérifier le fonctionnement
 * des classes Event et EventManager
 * grâce à l'Event MessageEvent
 */

public class TestEventManager {

	public static void main(String[] args) {

		EventManager manager = new EventManager(0);
		
		
		for (int i = 2; i<= 10; i+=2) {
			manager.addEvent(new MessageEvent(i, "[PING]"));
		}
		for (int i = 3; i<= 9; i+=3) {
			manager.addEvent(new MessageEvent(i, "[PONG]"));
		}
		
		while (!manager.isFinished()) {
			manager.next();
		}
	}

}
