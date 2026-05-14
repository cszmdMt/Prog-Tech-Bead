package org.example;

public class GirlandDisz extends Disz {
    public GirlandDisz(Karacsonyfa kf){
        super(kf);
    }

    @Override
    public double getDiszAr(){
        return 400;
    }

    @Override
    public String getDiszKirajzol(){
        return "girlanddal";
    }
}
