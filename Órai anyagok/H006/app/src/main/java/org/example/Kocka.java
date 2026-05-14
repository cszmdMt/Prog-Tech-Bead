package org.example;

public class Kocka extends Alakzat{
    int elHossz;

    public Kocka(Szin szin, int elhosz){
        super(szin);
        this.elHossz = elhosz;
    }

    @Override
    public int getAr(){
        // Visszadja mennyibe kerülne legesteni
        return (int)(getMeret() * szin.getAr());
    }

    @Override
    public float getMeret(){
        return 6 * elHossz * elHossz;
    }
}
