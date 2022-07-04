package com.powergrid;

public class Grid {

    private int power;

    public Grid(int power) {
        this.power = power;
    }


    public int residualPower() {
        return power;
    }

    public synchronized boolean drawPower(int p) {
        if (power >= p) {
            power -= p;
            return true;
        }
        return false;
    }

    public synchronized void releasePower(int p) {
        power += p;
    }
}