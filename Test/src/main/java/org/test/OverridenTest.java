package org.test;

class A
{
  public static int x = 0;
}

class B extends A
{

    public static void methodB()
    {
      System.out.println("I am from B");
    }
}
public class OverridenTest {
    public static void main(String[] args)
    {
        A a = new B();
        a.x = 1;
        System.out.println(a.x);
        ((B) a).methodB();
    }
}
