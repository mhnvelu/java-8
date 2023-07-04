/*
1. forEach is defined in Iterable and Stream interface.
2. It is a default method defined in the Iterable interface.
3. Collection classes which extends Iterable interface can use forEach loop to iterate elements.
4. This method takes a single parameter which is a functional interface.
    So, we can pass lambda expression as an argument.
5. forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code.
 */
package forEach;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> gamesList = new ArrayList<>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hockey");
        System.out.println("------------forEach : Iterating by passing lambda expression--------------");
        gamesList.forEach(game -> System.out.println(game));

        System.out.println("------------forEach : Iterating by passing method reference--------------");
        gamesList.forEach(System.out::println);

        System.out.println("------------forEachOrdered : Iterating by passing lambda expression--------------");
        gamesList.stream().forEachOrdered(game -> System.out.println(game));

        System.out.println("------------forEachOrdered : Iterating by passing method reference--------------");
        gamesList.stream().forEachOrdered(System.out::println);

    }
}
