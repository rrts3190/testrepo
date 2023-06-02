package org.tutorial;

@FunctionalInterface
public interface MyInterface {
    public void myMethod();
    public default void myDefaultMethod()
    {
        System.out.println("I from interface");
    }

    static void myStaticMethod()
    {
        System.out.println("I am static method");
    }
}
