

package evenements;

/**
 * La classe mère pour tous les évènements
 *
 */

public abstract class Event implements Comparable<Event> {
	
	private long date;
	
	/**
	 * Constructeur initialisant la date de l'évenement à d
	 * @param d
	 **/
	public Event(long d) {
		this.setDate(d);
	}
	
	/**
	 * Renvoie la date de l'évènement
	 * @return date
	 */
	public long getDate() {
		return this.date;
	}
	
	/**
	 * Initialisation de la date d'un évènement
	 * @param date de l'évènement
	 */
	public void setDate(long d) {
		this.date = d;
	}
	
	/**
	 *Execute l'évènement 
	 */
	public abstract void execute();
	
	/**
	 * Implément la relation d'ordre entre les évènements
	 * en fonction de leur date
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Event e) {
		if(this.getDate()<e.getDate()) {
			return -1;
		}
		else if(this.getDate() == e.getDate()){
			return 0; 
		}
		else
			return 1;
	}
}
