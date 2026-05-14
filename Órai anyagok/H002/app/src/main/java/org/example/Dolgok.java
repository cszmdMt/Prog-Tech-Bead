package org.example;

//vékony interface: 0 vagy 1 függvény van benne csak

interface HapogasStrategia {
    void hapog();
}

interface RepulesStrategia {
    void repul();
}

interface EvesStrategia {
    void eszik();
}

class SimaHapogas implements HapogasStrategia {
    @Override
    public void hapog(){
        System.out.println("Háp háp!");
    }
}

class JolRepul implements RepulesStrategia {
    @Override
    public void repul() {
        System.out.println("Jól repül!");
    }
}

class Fecser implements EvesStrategia {
    @Override
    public void eszik() {
        System.out.println("Csipeget!");
    }
}

class NemaHapogas implements HapogasStrategia {
    @Override
    public void hapog() {
        System.out.println("...");
    }
}