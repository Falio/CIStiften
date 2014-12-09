//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Card implements Comparable<Card> {
	Number number;
	Suit suit;

	Card(Number num, Suit suit) {
		this.number = num;
		this.suit = suit;
	}

	public String toString() {
		return this.number + " van " + this.suit;
	}

	public int compareTo(Card card) {
		return card.number == this.number && card.suit == this.suit?0:-1;
	}
}
