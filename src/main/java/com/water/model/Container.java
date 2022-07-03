package com.water.model;

import java.util.*;

public class Container {

    private Set<Container> group;
    private double amount;

    public Container() {
        this.amount = 0;
        this.group = new HashSet<>();
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<Container> getGroup() {
        return group;
    }

    public void setGroup(Set<Container> group) {
        this.group = group;
    }
}
