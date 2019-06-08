package com.example.GenericType.OOP9;

public class OOP9 {


    public static void main(String[] args) {
        A outer = new A();

        A.B whatever = outer.new B();

        A.C whatever2 = new A.C();
    }

}

class A {
    A() {
        System.out.println("I'm from outer class A");
        B b = new B();
    }

    class B {
        B() {
            System.out.println("I'm from inner class B");
            tmp = 5;
        }
        double sample;
    }

    static class C {
        static double PI = 3.14;
    }

    private int tmp;
}