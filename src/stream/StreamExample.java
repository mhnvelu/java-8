/*
1. Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
2. Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
3. Stream is lazy and evaluates code only when required.
4. The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
5. We can use stream to filter, collect, print, and convert from one data structure to other.
6. Collection interface has been extended with stream() and parallelStream() default methods to get the Stream for sequential and parallel execution
 */

package stream;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class StreamExample {
    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        // Filtering, Mapping,  Collect
        List<Float> productPriceList = productsList.stream().filter(p -> p.price > 30000).map(p -> p.price).collect(Collectors.toList());
        System.out.println(productPriceList);

        // Filtering and Iterating Collection
        productsList.stream().filter(p -> p.price > 30000).forEach(System.out::println);

        // reduce
        float totalPrice1 = productsList.stream().map(p -> p.price).reduce(0.0f, (sum, price) -> sum + price);
        System.out.println(totalPrice1);

        float totalPrice2 = productsList.stream().map(p -> p.price).reduce(0.0f, Float::sum);
        System.out.println(totalPrice2);

        // using collectors
        double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(p -> p.price));
        System.out.println(totalPrice3);

        Map<Integer, String> productMap = productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println(productMap);

        // min and max
        Product maxProduct = productsList.stream().max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println(maxProduct);

        Product minProduct = productsList.stream().min((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println(minProduct);

        // count
        long count = productsList.stream().count();
        System.out.println(count);

        // Method reference in Stream
        productsList.stream().filter(product -> product.price > 25000).map(Product::getName).forEach(System.out::println);
    }
}