
public class TestEventManager {

	public static void main(String[] args) {

		EventManager manager = new EventManager();
		
		Event e1 = new MessageEvent(1,"hello");
		Event e2 = new MessageEvent(2, "hola");
		
		if(e1<e2) {
			System.out.println("1<2");
		}
		else 
			System.out.println("2<1");
	}

}
