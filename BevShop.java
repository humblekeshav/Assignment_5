/*
 * Class: CMSC203 21955
 * Instructor:Gary Thai
 * Description: (Give a brief description for each Class)
 * Due: 12/13/24
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Keshav Mehta-Harwitz
*/
package bevshop;

import java.util.ArrayList;
import java.util.Comparator;

public class BevShop implements BevShopInterface {
    private int numOfAlcoholInOrder;
    private int currentOrderIdx;
    private ArrayList<Order> orders;

    public BevShop() {
        orders = new ArrayList<>();
    }

    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public boolean isEligibleForMore() {
        return numOfAlcoholInOrder < MAX_ORDER_FOR_ALCOHOL;
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(time, day, customer);
        orders.add(order);
        currentOrderIdx = orders.indexOf(order);
        numOfAlcoholInOrder = 0;
    }

    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        orders.get(currentOrderIdx).addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        orders.get(currentOrderIdx).addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    public void processAlcoholOrder(String bevName, Size size) {
        orders.get(currentOrderIdx).addNewBeverage(bevName, size);
        numOfAlcoholInOrder++;
    }

    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        for (Order o : orders) {
            if (o.getOrderNo() == orderNo) {
                return o.calcOrderTotal();
            }
        }
        return 0;
    }

    public double totalMonthlySale() {
        double totalSale = 0;
        for (Order o : orders) {
            totalSale += o.calcOrderTotal();
        }
        return totalSale;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public void sortOrders() {
        orders.sort(Comparator.comparingInt(Order::getOrderNo));
    }

    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public Order getCurrentOrder() {
        return orders.get(currentOrderIdx);
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getNumOfAlcoholDrink() {
        return numOfAlcoholInOrder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Monthly Orders:\n");
        for (Order o : orders) {
            sb.append(o.toString()).append("\n");
        }
        sb.append("Total Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}