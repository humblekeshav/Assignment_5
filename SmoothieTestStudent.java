package bevshop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {
    private Smoothie smoothie1, smoothie2;

    @Before
    public void setUp() {
        smoothie1 = new Smoothie("Detox", Size.SMALL, 2, false);
        smoothie2 = new Smoothie("Power", Size.LARGE, 5, true);
    }

    @Test
    public void testConstructor() {
        assertEquals("Detox", smoothie1.getBevName());
        assertEquals(2, smoothie1.getNumOfFruits());
        assertFalse(smoothie1.hasProtein());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.0, smoothie1.calcPrice(), 0.01); // Base + 2 fruits
        assertEquals(7.0, smoothie2.calcPrice(), 0.01); // Large + max fruits + protein
    }

    @Test
    public void testConstraints() {
        assertTrue(smoothie2.getNumOfFruits() <= BevShopInterface.MAX_FRUIT);
    }
}