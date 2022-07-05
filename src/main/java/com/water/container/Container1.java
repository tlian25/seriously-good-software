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

        if (this.amount + amountPerContainer < 0) {
            throw new IllegalArgumentException("Not enough water to match the addWater request");
        }

        double oldTotal = 0;
        assert (oldTotal = groupAmount()) >= 0;
        for (Container1 c: group) { c.amount += amountPerContainer; }

        assert postAddWater(oldTotal, amount) : "addWater failed its postcondition!";
    }

    private double groupAmount() {
        double total = 0;
        for (Container1 c: group) total += c.amount;
        return total;

    }

    // Check that total Amount of water is oldAmount + addedAmount
    private boolean postAddWater(double oldTotal, double addedAmount) {
        return isGroupBlanced() && almostEqual(groupAmount(), oldTotal + addedAmount);
    }

    private static boolean almostEqual(double x, double y) {
        final double EPSILON = 1E-4;
        return Math.abs(x-y) < EPSILON;
    }

    // Check that every container in the group has the same amount as this container
    private boolean isGroupBlanced() {
        for (Container1 c: group) {
            if (c.amount != amount) return false;
        }
        return true;
    }

    private static class ConnectPostData {
        Set<Container1> group1, group2;
        double amount1, amount2;
    }

    public void connectTo(Container1 other) {

        Objects.requireNonNull(other, "Cannot connect to a null container");
        if (group == other.group) return;

        ConnectPostData postData = null;


        int size1 = group.size();
        int size2 = other.group.size();

        double tot1 = amount * size1;
        double tot2 = other.amount * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        UtilityMethods.connectGroups(group, other.group, newAmount);
    }


    private ConnectPostData saveConnectPostData(Container1 other) {
        ConnectPostData data = new ConnectPostData();
        data.group1 = new HashSet<>(group);
        data.group2 = new HashSet<>(other.group);

        data.amount1 = amount;
        data.amount2 = other.amount;
        return data;
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
