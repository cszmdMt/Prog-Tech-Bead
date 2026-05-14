package org.example;

public abstract class Alakzat {
    Szin szin;

    Alakzat(Szin szin){
        this.szin = szin;
    }

    public abstract int getAr();
    public abstract float getMeret();
}