package balls;
import java.awt.Point;
import java.util.Random;


/**
 * @author raifer
 *
 */
public class Balls {
    private Point [] balls, ballsOri;
    private int nbBalls;
	private int dy[];
	private int dx[];
	private final int vitesseMax = 40;
	
	private Random randomGenerator;

    /**
     * Constructeur par défaut (créer 10 balles)
     */
    public Balls(){
    	this(10);
    }
    
    public Balls(int nbBalls){
    	this.randomGenerator = new Random();
    	this.setNbBalls(nbBalls);
    	this.generateDxDy();
    	
        this.balls = new Point[this.getNbBalls()];
        this.ballsOri = new Point[this.getNbBalls()];
        
        for(int i=0;i<this.getNbBalls();i++){
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
    
    /**
     * Créer le tableau dx et dy et le complette 
     * en générant une vitesse et direction aléatoire pour chaque balles.
     */
    private void generateDxDy() {
    	this.dx = new int [this.getNbBalls()];
    	this.dy = new int [this.getNbBalls()];
    	
    	for (int i=0;i<nbBalls;i++){
			this.dx[i]=randomGenerator.nextInt(this.vitesseMax+1)-this.vitesseMax/2;
			this.dy[i]=randomGenerator.nextInt(this.vitesseMax+1)-this.vitesseMax/2;
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
    		double  x = this.balls[i].getX();
    		double  y = this.balls[i].getY();
    		if ( x > 700) {
    			x = 1400 - x;
    			dx[i] = -dx[i];
        	} else if (x < 0){
    			x = -x;
    			dx[i] = -dx[i];
    		}
    		if (y > 600) {
        		y = 1200 -y;
        		dy[i] = -dy[i];
        	} else if (y < 0){
        		y = -y;
        		dy[i] = -dy[i];
    		}
    		
    		this.balls[i].setLocation(x, y);
    			this.balls[i].translate(this.dx[i], this.dy[i]);
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
