package org.example;

public abstract class Disz implements Karacsonyfa {
    Karacsonyfa alapfa;
    public Disz(Karacsonyfa kf){
        this.alapfa = kf;
    }

    public abstract double getDiszAr();
    public abstract String getDiszKirajzol();

    @Override
    public double GetAr(){
        return alapfa.GetAr() + getDiszAr();
    }

    @Override
    public String Kirajzolas() {
        return alapfa.Kirajzolas() + getDiszKirajzol();
    }
}
