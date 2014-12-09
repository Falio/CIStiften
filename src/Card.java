public class Card implements Comparable<Card> {
	Number number;
	Suit suit;


	/**
	 * Constructor
	 * 
	 * @param number
	 * @param suit
	 */
	Card(Number num, Suit suit) {
		this.number = num;
		this.suit = suit;
	}
	/**
	 * Pretty-print deze Card als string
	 */
	public String toString() {
		return number + " van " + suit;
	}

	/**
	 * Vergelijk twee kaarten.
	 */
	public int compareTo(Card card) {
		if (card.number == this.number && card.suit == this.suit){
		return 0;
		}
		return -1;
	}

}
