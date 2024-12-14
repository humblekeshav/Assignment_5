package bevshop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {
    private Order order;

    @Before
    public void setUp() {
        order = new Order(10, Day.MONDAY, new Customer("Dan", 35));
    }

    @Test
    public void testAddNewBeverage() {
        order.addNewBeverage("Latte", Size.SMALL, false, false);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Latte", Size.SMALL, false, false);
        order.addNewBeverage("Detox", Size.MEDIUM, 3, true);
        assertEquals(7.5, order.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Latte", Size.SMALL, false, false);
        order.addNewBeverage("Detox", Size.MEDIUM, 3, true);
        order.addNewBeverage("Wine", Size.SMALL);

        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
    }
}
