package org.example;

public class Kacsa {
    private HapogasStrategia hapogasStrategia;
    private RepulesStrategia repulesStrategia;
    private EvesStrategia evesStrategia;
    
    // sTRATÉGIÁNAK ÉRTÉKET ADUNK: injektálás

    public Kacsa(HapogasStrategia hapogas,
                RepulesStrategia repules,
                EvesStrategia eves) {
                    this.hapogasStrategia = hapogas;
                    this.repulesStrategia = repules;
                    this.evesStrategia = eves;
                }

    public void hapog() {
        // delegálás: Delegáljuk a stratégiának, hogy végezze el a feladatot
        hapogasStrategia.hapog();
    }

    public void repul() {
        repulesStrategia.repul();
    }

    public void eszik() {
        evesStrategia.eszik();
    }

    public void setHapogasStrategia(HapogasStrategia strategia){
        this.hapogasStrategia = strategia;
    }

    public void setRepulesStrategia(RepulesStrategia strategia){
        this.repulesStrategia = strategia;
    }

    public void setEvesStrategia(EvesStrategia strategia) {
        this.evesStrategia = strategia;
    }
}