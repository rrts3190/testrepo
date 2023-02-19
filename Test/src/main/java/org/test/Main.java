package org.test;

//import java.util.stream.Stream;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .takeWhile(x -> x <= 5)
                .forEach(System.out::println);

        /*Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .filter(x -> x <= 5)
                .forEach(System.out::println);*/
    }
}