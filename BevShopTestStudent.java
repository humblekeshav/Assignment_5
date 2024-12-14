package bevshop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {
    private BevShop shop;

    @Before
    public void setUp() {
        shop = new BevShop();
    }

    @Test
    public void testStartNewOrder() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(10, shop.getCurrentOrder().getOrderTime());
        assertEquals("John", shop.getCurrentOrder().getCustomer().getName());
    }

    @Test
    public void testProcessOrders() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testConstraints() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processAlcoholOrder("Wine", Size.SMALL);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processAlcoholOrder("Vodka", Size.SMALL);

        assertFalse(shop.isEligibleForMore());
    }
}
