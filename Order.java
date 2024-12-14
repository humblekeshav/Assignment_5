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
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    // Constructor
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

    // Generates a random order number within the range of 10000 to 90000
    private int generateOrderNumber() {
        return new Random().nextInt(80001) + 10000;
    }

    // Adds a coffee beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    // Adds an alcohol beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size size) {
        boolean isWeekend = (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }

    // Adds a smoothie beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    // Retrieves a beverage at a specific index
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    // Calculates the total amount for this order
    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    // Returns the number of beverages of the same type in the order
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    // Returns true if the order day is a weekend
    @Override
    public boolean isWeekend() {
        return (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
    }

    // Returns the total number of beverages in the order
    public int getTotalItems() {
        return beverages.size();
    }

    // Overrides the compareTo method to compare orders by order number
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    // Overridden toString method to display order details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo)
          .append("\nOrder Time: ").append(orderTime)
          .append("\nOrder Day: ").append(orderDay)
          .append("\nCustomer: ").append(customer.toString())
          .append("\nBeverages:");
        for (Beverage bev : beverages) {
            sb.append("\n  ").append(bev.toString());
        }
        return sb.toString();
    }

    // Getters and Setters
    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy
    }

    public ArrayList<Beverage> getBeverages() {
        return new ArrayList<>(beverages); // Defensive copy
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer); // Deep copy
    }
}