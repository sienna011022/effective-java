package com.example.item21;

import java.util.HashSet;
import java.util.Set;

public interface MyInterface {
    default String printHello(){
        return "Hello World";
    }

    String hello();

}
