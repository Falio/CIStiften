public class Card implements Comparable<Card> {


	/**
	 * Constructor
	 * 
	 * @param number
	 * @param suit
	 */
	Card(Number num, Suit suit) {
	}


	/**
	 * Pretty-print deze Card als string
	 */
	public String toString() {
		return "Aas" + " van " + "Ruiten";
	}

	/**
	 * Vergelijk twee kaarten.
	 */
	public int compareTo(Card card) {
		return 0;
	}

}
