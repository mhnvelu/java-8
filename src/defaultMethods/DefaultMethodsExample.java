/*
1. Methods which are defined inside the interface and tagged with default are known as default methods.
2. These methods are non-abstract methods.
3. We can override default method also to provide more specific implementation for the method.
4. A default method cannot override a method from java.lang.Object
5. Java 8 uses default and static methods heavily in Collection API and default methods are added so that our code remains backward compatible.
 */
package defaultMethods;
interface Printable{
    default void print(){
        System.out.println("Hi, this is default method");
    }

    void colorPrint(); // abstract method
}

public class DefaultMethodsExample implements Printable{
    public static void main(String[] args) {
        DefaultMethodsExample defaultMethodsExample = new DefaultMethodsExample();
        defaultMethodsExample.print();
        defaultMethodsExample.colorPrint();
    }
    @Override
    public void print(){
        System.out.println("Hi, overridden print default method");
    }

    @Override
    public void colorPrint() {
        System.out.println("Hi, this is color print");
    }
}
