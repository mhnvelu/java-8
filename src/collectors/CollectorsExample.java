/*
1. Collectors is a final class that extends Object class.
2. It provides reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria.
 */
package collectors;

import java.util.ArrayList;
import java.util.List;
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
}

public class CollectorsExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        //Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        // collecting as List
        List<Float> priceList1 = productsList.stream().map(product -> product.price).collect(Collectors.toList());
        List<Float> priceList2 = productsList.stream().map(product -> product.price).toList();
        System.out.println(priceList1);
        System.out.println(priceList2);

        // sum method
        Double totalPrice = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
        System.out.println("totalPrice : " + totalPrice);
        Integer sumId = productsList.stream().collect(Collectors.summingInt(product -> product.id));
        System.out.println("sumId : " + sumId);

        // average method
        Double averagePrice = productsList.stream().collect(Collectors.averagingDouble(product -> product.price));
        System.out.println("averagePrice : " + averagePrice);

        // counting method
        Long totalElements1 = productsList.stream().count();
        System.out.println("totalElements1 : " + totalElements1);
        Long totalElements2 = productsList.stream().collect(Collectors.counting());
        System.out.println("totalElements2 : " + totalElements2);

    }
}
