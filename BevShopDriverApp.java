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

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to BevShop!");
        System.out.println("The current order in process can have at most " + BevShopInterface.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + BevShopInterface.MIN_AGE_FOR_ALCOHOL);

        while (true) {
            System.out.println("\n#------------------------------------#");
            System.out.println("Would you please start a new order? (yes/no)");
            String startOrder = scanner.nextLine().trim().toLowerCase();

            if (!startOrder.equals("yes")) {
                break; // Exit the program if user doesn't want to start a new order
            }

            // Ask for time and validate it
            int time;
            while (true) {
                System.out.print("Please enter the order time (8-23): ");
                time = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (bevShop.isValidTime(time)) {
                    break;
                } else {
                    System.out.println("Invalid time. Please enter a time between 8 and 23.");
                }
            }

            // Ask for day, name, and age
            System.out.print("Please enter the day (e.g., MONDAY, TUESDAY): ");
            Day day = Day.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Please enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            bevShop.startNewOrder(time, day, name, age);

            if (bevShop.isValidAge(age)) {
                System.out.println("Your age is above " + BevShopInterface.MIN_AGE_FOR_ALCOHOL + " and you are eligible to order alcohol.");
            } else {
                System.out.println("Your age is below " + BevShopInterface.MIN_AGE_FOR_ALCOHOL + ". You cannot order alcohol.");
            }

            while (true) {
                System.out.println("\nCurrent order total: " + bevShop.getCurrentOrder().calcOrderTotal());
                System.out.println("What would you like to add to your order?");
                System.out.println("1. Alcohol\n2. Coffee\n3. Smoothie\n4. Finish Order");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) { // Alcohol
                    if (!bevShop.isValidAge(age)) {
                        System.out.println("You are not eligible to order alcohol.");
                    } else if (!bevShop.isEligibleForMore()) {
                        System.out.println("You have reached the maximum alcohol limit for this order.");
                    } else {
                        System.out.print("Enter alcohol name: ");
                        String alcoholName = scanner.nextLine();

                        System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                        Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                        bevShop.processAlcoholOrder(alcoholName, size);
                        System.out.println("Alcohol added. Current number of drinks: " + bevShop.getCurrentOrder().getTotalItems());
                    }
                } else if (choice == 2) { // Coffee
                    System.out.print("Enter coffee name: ");
                    String coffeeName = scanner.nextLine();

                    System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Extra shot? (yes/no): ");
                    boolean extraShot = scanner.nextLine().trim().toLowerCase().equals("yes");

                    System.out.print("Extra syrup? (yes/no): ");
                    boolean extraSyrup = scanner.nextLine().trim().toLowerCase().equals("yes");

                    bevShop.processCoffeeOrder(coffeeName, size, extraShot, extraSyrup);
                    System.out.println("Coffee added. Current number of drinks: " + bevShop.getCurrentOrder().getTotalItems());
                } else if (choice == 3) { // Smoothie
                    System.out.print("Enter smoothie name: ");
                    String smoothieName = scanner.nextLine();

                    System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Enter number of fruits: ");
                    int numOfFruits = scanner.nextInt();

                    if (bevShop.isMaxFruit(numOfFruits)) {
                        System.out.println("You have reached the maximum number of fruits allowed.");
                        continue;
                    }

                    System.out.print("Add protein? (yes/no): ");
                    boolean addProtein = scanner.nextLine().trim().toLowerCase().equals("yes");

                    bevShop.processSmoothieOrder(smoothieName, size, numOfFruits, addProtein);
                    System.out.println("Smoothie added. Current number of drinks: " + bevShop.getCurrentOrder().getTotalItems());
                } else if (choice == 4) { // Finish Order
                    System.out.println("Order finished. Total price: " + bevShop.getCurrentOrder().calcOrderTotal());
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

            System.out.println("\nOrder Summary:");
            System.out.println(bevShop.getCurrentOrder());
        }

        System.out.println("\n#------------------------------------#");
        System.out.println("Monthly Orders Summary:");
        System.out.println(bevShop.toString());
        System.out.println("Total Monthly Sale: " + bevShop.totalMonthlySale());

        scanner.close();
    }
}