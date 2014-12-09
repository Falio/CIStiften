import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Een deck met Cards
 * 
 */
public class Deck {

	static Card[] cardArray;

	/**
	 * Constructor. Maakt een deck met lengte 52.
	 */
	Deck() {
		cardArray = new Card[52];
		
	}
	
	public static void main(String[] args){
		Card card1 = new Card(Number.ZEVEN, Suit.RUITEN);
		Deck d = new Deck();
		d.fill();
		d.insertAt(card1, 51);
		System.out.println(cardArray[51]);
		//d.shuffle();
		//System.out.println(cardArray[40]);
		//d.sort();;
		//System.out.println("gesorteerd");
		//System.out.println(d.isSorted());
		//d.showDeck();
		//System.out.println(d.sequentialSearch(card1));
		//System.out.println(d.binarySearch(card1));

	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fill() {
		int a = 0;
		for (int i = 0; i < Suit.values().length; i++){
			for (int count = 0; count < Number.values().length; count++){			
				Card c  = new Card(Number.values()[count], Suit.values()[i]);
				cardArray[a] = c;
				a++;		
			}
		}	
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
		//gebruiker kan alleen kaarten toevoegen na index 52
		cardArray = Arrays.copyOf(cardArray, cardArray.length+1);
		for (int i = cardArray.length - 1; i < index; i--){
			cardArray[i] = cardArray[i-1];
		}
		cardArray[index] = card;		
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er
	 * in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
		System.arraycopy(cardArray, index + 1, cardArray, index, cardArray.length - 1 - index);		
		cardArray[index] = cardArray[ cardArray.length - 1 ] ;
		
		cardArray = Arrays.copyOf(cardArray, cardArray.length+1);
		for (int i = cardArray.length - 1; i < index; i--){
			cardArray[i] = cardArray[i-1];
		}
		cardArray[index] = card;
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * @return 
	 * 
	 */
	public Card[] shuffle() {
		Random rgen = new Random();  // Random number generator			
		 
		for (int i=0; i<cardArray.length; i++) {
		    int randomPosition = rgen.nextInt(cardArray.length);
		    Card temp = cardArray[i];
		    cardArray[i] = cardArray[randomPosition];
		    cardArray[randomPosition] = temp;
		}
 
		return cardArray;
	}
	
	public void showDeck(){
		int a = 0;
		for (int count = 0; count < cardArray.length; count++){			
			System.out.println(cardArray[a]);	
			a++;
		}
	}

	/**
	 * Utillity method for swapping cards in given indices
	 * 
	 * @param indexA
	 * @param indexB
	 */
	private void cardSwap(int indexA, int indexB) {
		Card temp = cardArray[indexA];
		cardArray[indexA] = cardArray[indexB];
		cardArray[indexB] = temp;	
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
		for (int i=0; i<cardArray.length; i++) { 
			if (cardArray[i].compareTo(card) == 0){
		            return i;
			}			
		}
		int result = -1;
		return result;
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 * @param <T>
	 */
	public void sort() {
		int j;                     // the number of items sorted so far
	     Card key;                // the item to be inserted
	     int i;  
	     for (j = 1; j < cardArray.length; j++)    // Start with 1 (not 0)
	    {
	           key = cardArray[ j ];
	           for(i = j - 1; (i >= 0) && (getIndex(cardArray[ i ]) < getIndex(key)); i--)   // Smaller values are moving up
	          {
	        	   cardArray[ i+1 ] = cardArray[ i ];
	          }
	           cardArray[ i+1 ] = key;    // Put the key in its proper location
	     }
	}
	
	public int getIndex(Card card) {
		for (int i=0; i<cardArray.length; i++) { 
			if (cardArray[i].compareTo(card) == 0){
		            return i;
			}			
		}
		int result = -1;
		return result;
	}

	/**
	 * Vertelt of het deck gesorteerd is.
	 * @return
	 */
	public boolean isSorted(){
		boolean sorted = true;
		for (int i = 1; i < cardArray.length; i++) {
			if (getIndex(cardArray[i]) < getIndex(cardArray[i-1])) {
				sorted =  false;
			}
		}
		return sorted;
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbard p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		
		// POSTCONDITIONS: returns i;
		// if i >= 0, then a[i] == x; otherwise i == -1;
		int lo = 0;
		int hi = cardArray.length;
		while (lo < hi) { // step 1
			// INVARIANT: if a[j]==x then lo <= j < hi; // step 3
			int i = (lo + hi)/2; // step 4
			if (cardArray[i].compareTo(card) == 0) {
				return i; // step 5
			} else if (getIndex(cardArray[i]) < getIndex(card)) {
				lo = i+1; // step 6
			} else {
				hi = i; // step 7
			}
		 }
		int result = -1;
		return result;
	}


	/**
	 * Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";

		return str + "\n";
	}
	
	public int compareTo(Deck d){
		return 0;
	}

}
