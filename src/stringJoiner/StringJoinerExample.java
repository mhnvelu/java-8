/*
1. Java added a new final class StringJoiner in java.util package.
2. It is used to construct a sequence of characters separated by a delimiter.
3. Now, we can create string by passing delimiters like comma(,), hyphen(-) etc.
4. We can also pass prefix and suffix to the char sequence.
 */

package stringJoiner;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter
        joinNames.add("first name");
        joinNames.add("middle name");
        joinNames.add("last name");
        System.out.println(joinNames);

        StringJoiner joinNames1 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter
        joinNames1.add("first name");
        joinNames1.add("middle name");
        joinNames1.add("last name");
        System.out.println(joinNames1);

        StringJoiner joinNames2 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter
        joinNames2.add("Hello");
        joinNames2.add("World");

        // Creating StringJoiner with :(colon) delimiter
        StringJoiner joinNames3 = new StringJoiner(":", "[", "]");  // passing colon(:) and square-brackets as delimiter
        joinNames3.add("Java");
        joinNames3.add("StringJoiner");

        StringJoiner mergedString = joinNames2.merge(joinNames3);
        System.out.println(mergedString);

        // length of StringJoiner
        System.out.println(mergedString.length());

        //toString()
        System.out.println(mergedString.toString());

    }
}
