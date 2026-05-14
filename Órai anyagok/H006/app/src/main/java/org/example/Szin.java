package org.example;

interface Szin {
    String getSzin();
    int getAr();
}

class Zold implements Szin{
    @Override
    public String getSzin(){
        return "Zöld";
    }

    @Override
    public int getAr(){
        return 500;
    }
}

class Rozsaszin implements Szin {
    @Override
    public String getSzin(){
        return "Rózsaszín";
    }

    @Override
    public int getAr(){
        return 600;
    }
}