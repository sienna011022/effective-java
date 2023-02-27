package com.example.item35;

public enum Ensemble {
    SOLO,DUET,TRIO,QUARTET,QUINTET;

    public i
    nt numberOfMusicans(){
        return ordinal() + 1;
    }



}
