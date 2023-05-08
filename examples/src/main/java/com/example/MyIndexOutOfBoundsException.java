package com.example;

public class MyIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public MyIndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
        super(String.format("최솟값: %d, 최댓값: %d, 인덱스: %d", lowerBound, upperBound, index));
    }
}
