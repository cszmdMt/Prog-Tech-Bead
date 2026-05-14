package org.example;

public abstract class ForroItal {
    // Fontos: Ez TEmplateMethod társa: A Factory method
    // a visszatérési típus az nem void
    // FactoryMethod esetén a gyártó metódust create-el szoktok prefixelni

    public String CreateForroItal() {
        
        String forralas = vizForralas();
        String koffeinBele = koffeinBele();
        String kitolt = kitolt();
        String izesites = izesites();

        return forralas + koffeinBele + kitolt + izesites;
    }

    //kötelező és közös
    private String vizForralas(){
        return "Felforralom a vizet \n";
    }

    //kötelező és nem közös léps
    protected abstract String koffeinBele();
    protected abstract String kitolt();

    //opcionális -- hook metódus
    // virtuális metódus, aminek van törzse de az üres, vagy csak return
    // ha return van benne, akkor 'átlátszó ' értékkel tér vissza -> nem számít
    protected String izesites() {
        return "";
    } 
}

class TeaFozes extends ForroItal{
    @Override
    protected String koffeinBele(){
        return "Tea filter-t lógatok bele\n";
    }

    @Override
    protected String kitolt() {
        return "Kitöltök egy csésze teát\n";
    }
}

class RumosTeaFozes extends TeaFozes{
    @Override
    protected String izesites(){
        return " Egy kis rumot teszek bele\n";
    }
}

class KaveFozes extends ForroItal{
    @Override
    protected String koffeinBele(){
        return "Kávé babot darálunk rakunk a vízbe\n";
    }

    @Override 
    protected String kitolt(){
        return "Kitöltök egy csésze kávét\n";
    }
}

class KaramellasCsokisIrKave extends KaveFozes {
    @Override
    protected String izesites(){
        return "Rakok bele egy kis karamellát, meg csokit, meg ír Whiskeyt";
    }
}