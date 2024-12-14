package bevshop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {
    private Coffee coffee1, coffee2, coffee3;

    @Before
    public void setUp() {
        coffee1 = new Coffee("Espresso", Size.SMALL, false, false);
        coffee2 = new Coffee("Latte", Size.MEDIUM, true, true);
        coffee3 = new Coffee("Latte", Size.MEDIUM, true, true);
    }

    @Test
    public void testConstructor() {
        assertEquals("Espresso", coffee1.getBevName());
        assertEquals(Size.SMALL, coffee1.getSize());
        assertFalse(coffee1.getExtraShot());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(2.0, coffee1.calcPrice(), 0.01);
        assertEquals(3.5, coffee2.calcPrice(), 0.01); // Medium + extras
    }

    @Test
    public void testEquals() {
        assertFalse(coffee1.equals(coffee2));
        assertTrue(coffee2.equals(coffee3));
    }
}
