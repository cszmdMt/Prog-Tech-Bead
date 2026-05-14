package org.example;

public class Jatekos {
    public int x;
    public int y;
    private JatekosAllapot aktualisAllapot;

    public Jatekos(JatekosAllapot allapot){
        aktualisAllapot = allapot;
        x = 0;
        y = 0;
    }

    // definiáljuk a funciókat, amiket lehet csinálni

    public void ugras() {
        aktualisAllapot.ugras();
    }

    public void balraMozog() {
        aktualisAllapot.balraMozog();
    }

    public void jobbraMozog() {
        aktualisAllapot.jobbraMozog();
    }

    public void esni() {
        aktualisAllapot.esni();
    }

    public void allapotValtas(JatekosAllapot ujAllapot) {
        this.aktualisAllapot = ujAllapot;
    }
}