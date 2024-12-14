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

class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double WEEKEND_FEE = 0.6;

    public Alcohol(String n, Size s, boolean iw) {
        super(n, Type.ALCOHOL, s);
        isWeekend = iw;
    }

    public String toString() {
        String s = getBevName() + ", " + getSize();
        if (isWeekend) s += " Weekend";
        s += ", $" + calcPrice();
        return s;
    }

    public double calcPrice() {
        double price = getBasePrice();
        if (getSize() == Size.MEDIUM) price += getSizePrice();
        else if (getSize() == Size.LARGE) price += 2 * getSizePrice();
        if (isWeekend) price += WEEKEND_FEE;
        return price;
    }

    public boolean getIsWeekend() { return isWeekend; }
    public double getWeekendFee() { return WEEKEND_FEE; }

    public void setIsWeekend(boolean is) { isWeekend = is; }
}
