import gui.Simulable;

public class BallsSimulator implements Simulable {
	
	Balls nosBalles;
	
	@Override
	public void next() {
		nosBalles.translate(10, 10);
	}
	
	@Override
	public void restart() {
		nosBalles.reInit();
	}
}
