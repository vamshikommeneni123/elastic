package com.example.OOP.Demo4;

public class Monster {
    public double hitPoints;
    public double speed;

    public void attack() {

        System.out.println("I'm attacking from Monster class");
    }

    public Monster() {
        System.out.println("I'm DEFAULT constructor from Monster class");
    }

    public Monster(double hitPoints, double speed) {
        this.hitPoints = hitPoints;
        this.speed = speed;
        System.out.println("I'm constructor from Monster class with 2 arguments");
    }
}
