//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//test
public class Deck {
    static Card[] cardArray;

    Deck() {
        cardArray = new Card[52];
    }

    public static void main(String[] args) {
        int i;
        Scanner in = new Scanner(System.in);
        Deck d = new Deck();
        d.fill();
        System.out.println("Enter a number to see which card is at that position");
        i = in.nextInt();
        System.out.println(cardArray[i]);
    }

    public void fill() {
        int a = 0;

        for (int i = 0; i < Suit.values().length; ++i) {
            for (int count = 0; count < Number.values().length; ++count) {
                Card c = new Card(Number.values()[count], Suit.values()[i]);
                cardArray[a] = c;
                ++a;
            }
        }

    }

    public void insertAt(Card card, int index) {
        cardArray = Arrays.copyOf(cardArray, cardArray.length + 1);

        for (int i = cardArray.length - 1; i < index; --i) {
            cardArray[i] = cardArray[i - 1];
        }

        cardArray[index] = card;
    }

    public void delete(int var1) {
        throw new Error("Unresolved compilation problem: \n\tcard cannot be resolved to a variable\n");
    }

    public Card[] shuffle() {
        Random rgen = new Random();

        for (int i = 0; i < cardArray.length; ++i) {
            int randomPosition = rgen.nextInt(cardArray.length);
            Card temp = cardArray[i];
            cardArray[i] = cardArray[randomPosition];
            cardArray[randomPosition] = temp;
        }

        return cardArray;
    }

    public void showDeck() {
        int a = 0;

        for (int count = 0; count < cardArray.length; ++count) {
            System.out.println(cardArray[a]);
            ++a;
        }

    }

    private void cardSwap(int indexA, int indexB) {
        Card temp = cardArray[indexA];
        cardArray[indexA] = cardArray[indexB];
        cardArray[indexB] = temp;
    }

    public int sequentialSearch(Card card) {
        for (int result = 0; result < cardArray.length; ++result) {
            if (cardArray[result].compareTo(card) == 0) {
                return result;
            }
        }

        byte var3 = -1;
        return var3;
    }

    public void sort() {
        for (int j = 1; j < cardArray.length; ++j) {
            Card key = cardArray[j];

            int i;
            for (i = j - 1; i >= 0 && this.getIndex(cardArray[i]) < this.getIndex(key); --i) {
                cardArray[i + 1] = cardArray[i];
            }

            cardArray[i + 1] = key;
        }

    }

    public int getIndex(Card card) {
        for (int result = 0; result < cardArray.length; ++result) {
            if (cardArray[result].compareTo(card) == 0) {
                return result;
            }
        }

        byte var3 = -1;
        return var3;
    }

    public boolean isSorted() {
        boolean sorted = true;

        for (int i = 1; i < cardArray.length; ++i) {
            if (this.getIndex(cardArray[i]) < this.getIndex(cardArray[i - 1])) {
                sorted = false;
            }
        }

        return sorted;
    }

    public int binarySearch(Card card) {
        int lo = 0;
        int hi = cardArray.length;

        while (lo < hi) {
            int result = (lo + hi) / 2;
            if (cardArray[result].compareTo(card) == 0) {
                return result;
            }

            if (this.getIndex(cardArray[result]) < this.getIndex(card)) {
                lo = result + 1;
            } else {
                hi = result;
            }
        }

        byte result1 = -1;
        return result1;
    }

    public String toString() {
        String str = "";
        return str + "\n";
    }

    public int compareTo(Deck d) {
        return 0;
    }
}
