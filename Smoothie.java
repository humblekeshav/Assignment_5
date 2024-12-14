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

public class Smoothie extends Beverage {
    private int numOfFruits; // Number of fruits in the smoothie
    private boolean addProtein; // Whether protein powder is added
    private final double FRUIT_COST = 0.5; // Cost per fruit
    private final double PROTEIN_COST = 1.5; // Cost of protein powder

    // Constructor
    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    // Calculate price of the smoothie
    @Override
    public double calcPrice() {
        double price = getBasePrice();

        // Add size price upcharge
        if (getSize() == Size.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == Size.LARGE) {
            price += 2 * getSizePrice();
        }

        // Add fruit upcharge
        price += numOfFruits * FRUIT_COST;

        // Add protein upcharge
        if (addProtein) {
            price += PROTEIN_COST;
        }

        return price;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBevName()).append(", ").append(getSize()).append(", ").append(numOfFruits).append(" Fruits");
        if (addProtein) {
            sb.append(", Protein powder");
        }
        sb.append(", $").append(calcPrice());
        return sb.toString();
    }

    // Checkequality
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Smoothie) {
            Smoothie other = (Smoothie) obj;
            return super.equals(other) && numOfFruits == other.numOfFruits && addProtein == other.addProtein;
        }
        return false;
    }

    // Getters
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean hasProtein() {
        return addProtein;
    }

    public double getFruitCost() {
        return FRUIT_COST;
    }

    public double getProteinCost() {
        return PROTEIN_COST;
    }

    // Setters
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}