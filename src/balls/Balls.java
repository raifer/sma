package balls;
import java.awt.Point;
import java.util.Random;

/**
 * Balls est la class qui permet de gérer des balles
 **
 * @author Claire Mathieu Picardv
 *
 */
public class Balls {
    private Point [] balls, ballsOri;
    private int nbBalls;
	private int dy[];
	private int dx[];
	
	private Random randomGenerator;

    /**
     * Constructeur par défaut (créer 4 balles)
     */
    public Balls(){
    	this(10);
    }
    public Balls(int nbBalls){
    	this.randomGenerator = new Random();
    	
    	this.setNbBalls(nbBalls);
    	this.setDxDy(nbBalls);
    	
        this.balls = new Point[this.getNbBalls()];
        this.ballsOri = new Point[this.getNbBalls()];
        
        for(int i=0;i<this.getNbBalls();i++){
        	System.out.println(""+i);
	        this.balls[i] = new Point(325,325);
            this.ballsOri[i] = this.balls[i].getLocation();
        }
    }

   
	public void setNbBalls(int nbBalls) {
		if (nbBalls>10|| nbBalls < 1){
			throw new IllegalArgumentException("On ne peut avoir qu'entre 1 et 10 balles");
//			return Color.red;
		}
		else {
			this.nbBalls=nbBalls;
		}
	}
    
    public int getNbBalls(){
    	return this.nbBalls;
    }
    
    private void setDxDy(int nbBalls) {
    	this.dx = new int [nbBalls];
    	this.dy = new int [nbBalls];
    	
    	for (int i=0;i<nbBalls;i++){
			this.dx[i]=(randomGenerator.nextInt(nbBalls+1))-(nbBalls/2);
			this.dy[i]=(randomGenerator.nextInt(nbBalls+1))-(nbBalls/2);
    	}
	}

	/**
     * Déplacer toutes les balles
     ** 
     * @param dx Déplacement sur x
     * @param dy Déplacement sur y
     */
    public void translate() {
    	for (int i=0;i<this.getNbBalls();i++){
    		if (this.balls[i].getX() > 700) {
        		this.balls[i].setLocation(0,this.balls[i].getY()+this.dy[i]);	
        	}
    		else if (this.balls[i].getX() < 0){
        		this.balls[i].setLocation(700,this.balls[i].getY()+this.dy[i]);
    		}
        	else{
    			this.balls[i].translate(this.dx[i], this.dy[i]);
        	}
    		
    		if (this.balls[i].getY() > 600) {
        		this.balls[i].setLocation(this.balls[i].getX()+this.dx[i],0);	
        	}
    		else if (this.balls[i].getY() < 0){
        		this.balls[i].setLocation(this.balls[i].getX()+this.dx[i],600);
    		}
        	else{
    			this.balls[i].translate(this.dx[i], this.dy[i]);
        	}
    	}
    	
    }

    /**
     * Replace toutes les balles à leurs positions d'origine
     * 
     */
    public void reInit() {
        for(int i=0; i< this.getNbBalls(); i++){
            this.balls[i] = this.ballsOri[i].getLocation();
        }
    }

    /**
     * Permet de récupérer la balle à partir de son numéro
     *** 
     * @param ballNum Le numéro de la balle que l'on veut récupérer
     * @return Retourne la balle demandé si il existe
     *** 
     * @throw IllegalArgumentException Lève une exception si la balle n'existe pas
     */
    public Point getBall(int ballNum){
        if (ballNum >= 0 && ballNum < this.getNbBalls()){
            return balls[ballNum];
        } else throw new IllegalArgumentException("Numéro de balle incorecte.");
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Il y a " + this.getNbBalls()+" balles : \n");
        for(Point ball:balls){
            sb.append(ball.getX() + ", ");
            sb.append(ball.getY() + "\n");
        }
        return sb.toString(); 
        //return "p1("+p1.getX()+";"+p1.getY()+"), p2("+p2.getX()+";"+p2.getY()+"), p3("+p3.getX()+";"+p3.getY()+"), p4("+p4.getX()+";"+p4.getY()+")";
    }


}
