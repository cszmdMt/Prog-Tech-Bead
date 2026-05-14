package org.example;

public class Robot2Ember extends Ember {
    Robot robi;

    public Robot2Ember(Robot robot){
        super(robot.memory, robot.id);
        robi = robot;
    }
}
