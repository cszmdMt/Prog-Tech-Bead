package org.example;

interface JatekosAllapot {
    void ugras();
    void jobbraMozog();
    void balraMozog();
    void esni();
}

class SetalasAllapot implements JatekosAllapot {

    private Jatekos jatekos;

    public SetalasAllapot(Jatekos jatekos){
        this.jatekos = jatekos;
    }

    @Override
    public void ugras() {
        jatekos.y -= 2;
    }

    @Override
    public void jobbraMozog() {
        jatekos.x += 2;
    }

    @Override
    public void balraMozog() {
        jatekos.x -= 2;
    }

    @Override
    public void esni() {
        jatekos.y += 2;
        jatekos.allapotValtas(new EsniAllapot(jatekos));
    }
}

class EsniAllapot implements JatekosAllapot {

    private Jatekos jatekos;

    public EsniAllapot(Jatekos jatekos){
        this.jatekos = jatekos;
    }

    @Override
    public void ugras() {
        jatekos.y -= 1;
        jatekos.allapotValtas(new SetalasAllapot(jatekos));
    }

    @Override
    public void jobbraMozog() {
        jatekos.x += 1;
    }

    @Override
    public void balraMozog() {
        jatekos.x -= 1;
    }

    @Override
    public void esni() {
        jatekos.y += 1;
    }

}