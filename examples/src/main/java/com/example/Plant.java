package com.example;

import java.util.*;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }
        List<Plant> garden = new ArrayList<>(); // 편의상 빈 리스트로 초기화 했다.
        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }
        System.out.println(plantsByLifeCycle);
    }

//    public static void main(String[] args) {
//        //집합을 세개 만든 다음에
//        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
//        for (int i = 0; i < plantsByLifeCycle.length; i++) {
//            // 0 : set
//            plantsByLifeCycle[i] = new HashSet<>();
//        }
//
//        //집합하나당[0].add(plant)//리스트를 넣음 원래는 [식물1,식물2]
//        List<Plant> garden = new ArrayList<>(); // 편의상 빈 리스트로 초기화 했다. =>원래는 식물 모음
//         for (Plant plant : garden) {
//            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
//        }
//
//        // 결과 출력
//        for (int i = 0; i < plantsByLifeCycle.length; i++) {
//            System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
//        }
//    }
}
