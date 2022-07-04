package com.water.container;

import com.water.util.UtilityMethods;

import java.util.*;

public class Container1 implements Container<Container1> {

    private Set<Container1> group;
    private double amount;

    public Container1() {
        this.amount = 0;

        this.group = new HashSet<>();
        group.add(this);
    }

    public void addWater(double amount) {

        double amountPerContainer = amount / group.size();
        for (Container1 c: group) { c.amount = amountPerContainer; }

    }

    public void connectTo(Container1 other) {

        if (group == other.group) return;

        int size1 = group.size();
        int size2 = other.group.size();

        double tot1 = amount * size1;
        double tot2 = other.amount * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        UtilityMethods.connectGroups(group, other.group, newAmount);
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Container1> getGroup() {
        return group.stream().toList();
    }

    public void setGroup(Set<Container1> group) {
        this.group = group;
    }

    public int getGroupSize() {
        return group.size();
    }

    public boolean groupContains(Container1 other) {
        return group.contains(other);
    }


}
