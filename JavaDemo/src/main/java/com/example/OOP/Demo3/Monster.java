package com.example.OOP.Demo3;

public class Monster {
    private double hitPoints;
    private double speed;

    protected double getHitPoints() {
        return hitPoints;
    }

    protected void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

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
