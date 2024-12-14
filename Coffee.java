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

class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double SHOT_COST = 0.5;
    private final double SYRUP_COST = 0.5;

    public Coffee(String n, Size s, boolean shot, boolean syrup) {
        super(n, Type.COFFEE, s);
        extraShot = shot;
        extraSyrup = syrup;
    }

    public String toString() {
        String s = getBevName() + ", " + getSize();
        if (extraShot) s += " Extra shot";
        if (extraSyrup) s += " Extra syrup";
        s += ", $" + calcPrice();
        return s;
    }

    public double calcPrice() {
        double price = getBasePrice();
        if (getSize() == Size.MEDIUM) price += getSizePrice();
        else if (getSize() == Size.LARGE) price += 2 * getSizePrice();
        if (extraShot) price += SHOT_COST;
        if (extraSyrup) price += SYRUP_COST;
        return price;
    }

    public boolean getExtraShot() { return extraShot; }
    public boolean getExtraSyrup() { return extraSyrup; }
}