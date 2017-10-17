import java.awt.Point;

public class Balls {
    private Point [] balls, ballsOri;
    
	public Balls(){
	    this.balls = new Point[4];
	    this.ballsOri = new Point[4];
	    
	    this.balls[0] = new Point(5,8);
	    this.balls[1] = new Point(21,1);
	    this.balls[2] = new Point(0,4);
	    this.balls[3] = new Point(4,8);
	    
	    for(int i=0; i < balls.length; i++){
		//this.ballsOri[i] = (Point)this.balls[i].clone();
		this.ballsOri[i] = this.balls[i].getLocation();
	    }
	}
	
	public void translate(int dx, int dy) {
	    for (Point ball:balls){
		ball.translate(dx, dy);
	    }
	}
	
	public void reInit() {
	    for(int i=0; i< balls.length; i++){
		this.balls[i] = this.ballsOri[i].getLocation();
	    }
	}
	
	@Override
	public String toString() {
	    StringBuffer sb = new StringBuffer();
	        sb.append("Il y a " + balls.length +" balles : \n");
	        for(Point ball:balls){
	            sb.append(ball.getX() + ", ");
	            sb.append(ball.getY() + "\n");
	        }
	    return sb.toString(); 
		//return "p1("+p1.getX()+";"+p1.getY()+"), p2("+p2.getX()+";"+p2.getY()+"), p3("+p3.getX()+";"+p3.getY()+"), p4("+p4.getX()+";"+p4.getY()+")";
	}
	
	
}
