package com.example.item35;

public enum Ensemble {
    SOLO,DUET,TRIO,QUARTET,QUINTET;

    public int numberOfMusicans(){
        return ordinal() + 1;
    }



}
