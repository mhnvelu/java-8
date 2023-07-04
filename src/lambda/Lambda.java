/*
1. The Lambda expression is used to provide the implementation of an interface which has functional interface.
2. An interface which has only one abstract method is called Functional interface.
3. Java provides an annotation @FunctionalInterface, which is used to declare an interface as Functional interface.
4. Syntax : (args) -> {body}
 */
package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {

        // Lambda with no args
        Sayhello sayhello = () -> System.out.println("Say hello");
        sayhello.say();

        // Lambda with args
        Printable printable = (arg) -> "Hi " + arg;
        System.out.println(printable.print("one arg Lambda..."));

        // Lambda in for each loop
        List<String> names = new ArrayList<>();
        names.add("dev1");
        names.add("dev2");
        names.add("dev3");
        names.add("dev4");
        names.add("dev5");
        names.forEach((name) -> System.out.println(name));

    }
}

@FunctionalInterface // optional
interface Sayhello {
    void say();
}

interface Printable {
    String print(String arg);
}