/*
1.  Type inference is a feature of Java which provides ability to compiler to look at each method invocation and corresponding declaration to determine the type of arguments.
2.  Java provides improved version of type inference in Java 8
3.  Java 5 :
        List<Integer> list1 = new ArrayList<Integer>();
4.  Java 7 :
        List<Integer> list2 = new ArrayList<>();
5.  java 8 :
        new ArrayList<>();
 */
package typeInference;

import java.util.ArrayList;
import java.util.List;

public class TypeInferenceExample {
    public static void showList(List<Integer> list) {
        if (!list.isEmpty()) {
            list.forEach(System.out::println);
        } else System.out.println("list is empty");
    }

    public static void main(String[] args) {
        // An old approach(prior to Java 7) to create a list
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(11);
        showList(list1);

        // Java 7
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        showList(list2);

        // Compiler infers type of ArrayList, in Java 8
        showList(new ArrayList<>());
    }
}
