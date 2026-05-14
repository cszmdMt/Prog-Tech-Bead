package org.example;

public class Gomb extends Alakzat{
    int sugar;

    public Gomb(Szin szin, int sugar){
        super(szin);
        this.sugar = sugar;
    }

    @Override
    public int getAr(){
        // Visszadja mennyibe kerülne legesteni
        return (int)(getMeret() * szin.getAr());
    }

    @Override
    public float getMeret(){
        return 4 * sugar * sugar * (float)Math.PI;
    }
}


