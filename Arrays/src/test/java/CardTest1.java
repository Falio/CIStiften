import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest1 {

    @Test
    public void testCompareTo() {
        Card c1 = new Card(Number.AAS, Suit.HARTEN);
        //Card c2 = new Card(Number.TWEE, Suit.SCHOPPEN);

        assertTrue(c1.compareTo(c1) == 0);

    }

}