package com.example.item14;


import java.util.Comparator;

public class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;
    private int weight;

    public Fruit(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

//    @Override
//    public int compareTo(Fruit o) {
//        int result = Integer.compare(this.price,o.price); // 가장 중요한 필드부터 비교
//        if(result == 0){
//            Integer.compare(this.weight , o.weight);
//        }
//        return result;
//    }


    private static final Comparator<Fruit> COMPARATOR =
        Comparator.comparingInt((Fruit target) -> target.weight)
            .thenComparingInt(target -> target.price);

    @Override
    public int compareTo(Fruit fruit){
        return COMPARATOR.compare(this,fruit);
    }


}
