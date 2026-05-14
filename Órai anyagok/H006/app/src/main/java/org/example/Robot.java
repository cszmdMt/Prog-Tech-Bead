package org.example;

public class Robot {
    int memory;
    int id;

    public Robot(int memory, int id){
        this.memory = memory;
        this.id = id;
    }

    public int getMemory(){
        return memory;
    }

    public int getId() {
        return id;
    }
}
