package com.example.item40;


import java.util.HashSet;
import java.util.Set;

public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }   //객체의 동일성 판단
        if (!(o instanceof Bigram)) {
            return false; //타입을 비교
        }
        Bigram b = (Bigram) o; // 타입 캐스팅
        return b.first == first && b.second == second; //내부 값하나 하나 비교
    }

    //@Override
//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}
