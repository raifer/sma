import java.awt.Point;

public class Balls {
    private Point p1; 
    private Point p2; 
    private Point p3; 
    private Point p4;
    
	public Balls(){
	    p1 = new Point(5,8);
		p2 = new Point(21,1);
		p3 = new Point(0,4);
		p4 = new Point(4,8);
	}
	
	public void translate(int dx, int dy) {
		p1.translate(dx, dy);
		p2.translate(dx, dy);
		p3.translate(dx, dy);
		p4.translate(dx, dy);
	}
	
	public void reInit() {
		p1.setLocation(5, 8);
		p2.setLocation(21, 1);
		p3.setLocation(0, 4);
		p4.setLocation(4, 8);
	}
	
	@Override
	public String toString() {
		return "p1("+p1.getX()+";"+p1.getY()+"), p2("+p2.getX()+";"+p2.getY()+"), p3("+p3.getX()+";"+p3.getY()+"), p4("+p4.getX()+";"+p4.getY()+")";
	}
	
	
	
}
