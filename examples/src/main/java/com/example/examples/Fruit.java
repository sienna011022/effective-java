package com.example.examples;


public class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;
    private int weight;

    public Fruit(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public int compareTo(Fruit o) {
      return Integer.compare(this.price,o.price);
    }

//    private static final Comparator<Fruit> COMPARATOR =
//        Comparator.comparingInt((Fruit target) -> target.weight)
//            .thenComparingInt(target -> target.price);
//
//    @Override
//    public int compareTo(Fruit fruit){
//        return COMPARATOR.compare(this,fruit);
//    }
//

}
