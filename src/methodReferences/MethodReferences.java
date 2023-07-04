/*
1. Method reference is used to refer method of functional interface.
2. It is compact and easy form of lambda expression.
3. Each time when we are using lambda expression to just referring a method,
   we can replace the lambda expression with method reference
4. There are following types of method references in java:
    4.1 Reference to a static method.
    4.1 Reference to an instance method.
    4.3 Reference to a constructor.
    4.4 Reference to an Instance Method of an Object of a Particular Type
        ContainingType::methodName
        String::isEmpty

 */
package methodReferences;

import java.util.function.BiFunction;

interface Printable {
    void print();
}

interface Messagable {
    void getMessage(String message);
}

public class MethodReferences {

    MethodReferences() {
    }

    MethodReferences(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        // Reference to a static method
        Printable printable = MethodReferences::printStaticMethod;
        printable.print();

        // predefined functional interface Runnable to refer static method.
        Thread t1 = new Thread(MethodReferences::ThreadStatus);
        t1.start();

        // Predefined functional interface to refer static method
        BiFunction<Integer, Integer, Integer> adder = MethodReferences::add;
        int result = adder.apply(10, 20);
        System.out.println(result);

        // Referring non-static methods
        MethodReferences obj = new MethodReferences();
        Printable printable1 = obj::printInstanceMethod;
        printable1.print();

        // Referring constructor with  functional interface.
        Messagable messagable = MethodReferences::new;
        messagable.getMessage("Reference to construtor");
    }

    public void printInstanceMethod() {
        System.out.println("Hello, This is instance method");
    }

    public static void printStaticMethod() {
        System.out.println("Hello, This is static method");
    }

    public static void ThreadStatus() {
        System.out.println("Thread is running...");
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

