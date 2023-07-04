/*
1. Optional is a public final class and used to deal with NullPointerException in Java application.
2. We must import java.util package to use this class.
3. It provides methods which are used to check the presence of value for particular variable.
4. To avoid the abnormal termination, we use Optional class.
 */
package optional;

import java.util.Optional;
import java.util.StringJoiner;

public class OptionalExample {
    public static void main(String[] args) {
        //empty optional
        Optional<String> empty1 = Optional.empty();
        System.out.println(empty1);

        String str[] = new String[10];
//        Optional<String> empty2 = Optional.of(str[5]); // str[5] is null, throws NPE

        Optional<String> checkNull = Optional.ofNullable(str[5]); // str[5] is null, returns empty optional
        if(checkNull.isPresent()){
            System.out.println(checkNull.get());
        }else{
            System.out.println("Value not present");
        }

        System.out.println(checkNull.orElse("orElse : Value is not present"));
//        System.out.println(checkNull.orElseThrow(()->new RuntimeException("or Else Throw")));

        str[5] = "Optional class example";
        checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){
            System.out.println(new StringJoiner(" : ").add("Value is present").add(checkNull.get()));
        }else{
            System.out.println("Value not present");
        }

        // using method reference
        checkNull.ifPresent(System.out::println);

        //using filter
        System.out.println(checkNull.filter(value -> value.contains("class")).get());

    }
}
