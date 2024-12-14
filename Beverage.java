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

abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;

    public Beverage(String n, Type t, Size s) {
        name = n;
        type = t;
        size = s;
    }

    public abstract double calcPrice();

    public String toString() {
        return name + ", " + size;
    }

    public boolean equals(Beverage bev) {
        return name.equals(bev.getBevName()) && type == bev.getType() && size == bev.getSize();
    }

    public String getBevName() { return name; }
    public Type getType() { return type; }
    public Size getSize() { return size; }
    public double getBasePrice() { return BASE_PRICE; }
    public double getSizePrice() { return SIZE_PRICE; }

    public void setName(String n) { name = n; }
    public void setType(Type t) { type = t; }
    public void setSize(Size s) { size = s; }
}
