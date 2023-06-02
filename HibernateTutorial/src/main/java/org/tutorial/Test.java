package org.tutorial;

class MyClass implements MyInterface
{

    @Override
    public void myMethod() {
        System.out.println("I am override method");
    }

    public void myDefaultMethod()
    {
       // MyInterface.super.myDefaultMethod();
        System.out.println("I from class");
    }
    static void myStaticMethod()
    {
        System.out.println("I am static method from class");
    }
}
public class Test {
    public static void main(String[] args) {
         /* MyClass obj = new MyClass();
          obj.myDefaultMethod();
        MyInterface.myStaticMethod();*/

        int x = 1;
        int y = 1;
        while (x < 25)
        {
            int  z = x;
            x = x + y;
            y = z;
        }

        System.out.println(x);

    }
}
