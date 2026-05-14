package org.example;

public class BicikliDisz extends Disz {
    public BicikliDisz(Karacsonyfa kf){
        super(kf);
    }

    @Override
    public double getDiszAr(){
        return 100_000;
    }

    @Override
    public String getDiszKirajzol() {
        return "biciklivel";
    }
}
