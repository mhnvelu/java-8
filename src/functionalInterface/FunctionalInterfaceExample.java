/*
1. An Interface that contains exactly one abstract method is known as functional interface.
2. It can have any number of default, static methods but can contain only one abstract method.
3. It can also declare methods of object class.
4. Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
5. It is a new feature in Java, which helps to achieve functional programming approach.
6. This Annotation is a facility to avoid the accidental addition of abstract methods in the functional interfaces
7. One of the major benefits of the functional interface is the possibility to use lambda expressions to instantiate them.
    We can instantiate an interface with an anonymous class but the code looks bulky.
 */
package functionalInterface;

@FunctionalInterface
interface Printable {
    void print(String message); // abstract method
}

/*
Invalid Functional Interface
A functional interface can extend another interface only when it does not have any abstract method.
 */
//@FunctionalInterface
//interface ColorPrintable extends Printable {
//    void colorPrint(String message); // abstract method, so this is invalid functional interface
//}

/*
A functional interface is extending  a non-functional interface.
 */
interface Shape {
    default void draw() {
        System.out.println("Shape interface");
    }
}

@FunctionalInterface
interface Square extends Shape {
    void draw(int side); // abstract method
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Printable printable = (message -> System.out.println(message));
        printable.print("Functional interface example");

        Square square = (side -> System.out.println("Square : " + side * side));
        square.draw(10);
    }
}
