//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    public CardTest() {
    }

    @Test
    public void testCompareTo() {
        Card c1 = new Card(Number.AAS, Suit.HARTEN);
        Card c2 = new Card(Number.TWEE, Suit.SCHOPPEN);
        Assert.assertTrue(c1.compareTo(c1) == 0);
        Assert.assertTrue(c1.compareTo(c2) > 0);
        Assert.assertTrue(c2.compareTo(c1) < 0);
    }
}
