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

public class Customer {
    private String name;
    private int age;

    // Parameterized constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor for deep copy
    public Customer(Customer other) {
        if (other != null) {
            this.name = other.name;
            this.age = other.age;
        }
    }

    // Overridden toString method
    @Override
    public String toString() {
        return name + ", " + age + "y/o";
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}