package org.example;

public class CsillagDisz extends Disz{
    public CsillagDisz(Karacsonyfa kf){
        super(kf);
    }

    @Override
    public double getDiszAr(){
        return 500;
    }

    @Override
    public String getDiszKirajzol(){
        return "csillag dísszel";
    }
}
