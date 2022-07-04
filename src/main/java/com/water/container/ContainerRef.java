package com.water.container;

import java.util.HashSet;
import java.util.List;

public class ContainerRef implements Container<ContainerRef> {

    private double amount;
    private HashSet<ContainerRef> group;


    @Override
    public void addWater(double amount) {

    }

    @Override
    public void connectTo(ContainerRef other) {

    }

    @Override
    public int getGroupSize() {
        return 0;
    }

    @Override
    public List<ContainerRef> getGroup() {
        return null;
    }

    @Override
    public boolean groupContains(ContainerRef other) {
        return false;
    }
}
