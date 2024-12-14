package bevshop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {
    private Alcohol alcohol1, alcohol2, alcohol3;

    @Before
    public void setUp() {
        alcohol1 = new Alcohol("Wine", Size.SMALL, false);
        alcohol2 = new Alcohol("Beer", Size.LARGE, true);
        alcohol3 = new Alcohol("Beer", Size.LARGE, true);
    }

    @Test
    public void testConstructor() {
        assertEquals("Wine", alcohol1.getBevName());
        assertEquals(Size.SMALL, alcohol1.getSize());
        assertFalse(alcohol1.getIsWeekend());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(2.0, alcohol1.calcPrice(), 0.01);
        assertEquals(3.6, alcohol2.calcPrice(), 0.01); // Large size + weekend fee
    }

    @Test
    public void testEquals() {
        assertFalse(alcohol1.equals(alcohol2));
        assertTrue(alcohol2.equals(alcohol3));
    }
}
