package com.example.item21;

public interface MyInterface {
    default String printHello(){
        return "Hello World";
    }

    String hello();
}
