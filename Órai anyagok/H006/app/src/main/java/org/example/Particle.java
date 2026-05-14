package org.example;

public class Particle {
    String color;
    String sprite;

    public Particle(String color, String sprite){
        this.color = color;
        this.sprite = sprite;
    }

    public String getColor(){
        return color;
    }

    public String getSprite(){
        return sprite;
    }
}
