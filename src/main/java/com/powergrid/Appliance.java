package com.powergrid;

public class Appliance {

    private int power;
    private Grid grid;
    private boolean powerOn = false;


    public Appliance(int power) {
        this.power = power;
    }

    public void plugInto(Grid grid) {
        this.grid = grid;
    }

    public void on() throws ArithmeticException {
        if (powerOn) return;

        powerOn = grid.drawPower(power);

        if (!powerOn) {
            throw new ArithmeticException("Not enough power on grid to turn on");
        }
    }

    public void off() {
        if (!powerOn) return;

        grid.releasePower(power);
        powerOn = false;
    }

    public boolean getState() {
        return powerOn;
    }
}
