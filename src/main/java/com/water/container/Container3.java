package com.water.container;

import java.util.ArrayList;
import java.util.List;

public class Container3 implements Container<Container3> {

    private double amount;
    private Container3 parent = this;
    private int size = 1;
    private final List<Container3> group;

    public Container3() {
        group = new ArrayList<>();
        group.add(this);
    }

    @Override
    public void addWater(double amount) {

        Container3 root = findRootAndCompress();
        root.amount += amount / root.size;
    }

    @Override
    public void connectTo(Container3 other) {
        // Union Find
        Container3 root1 = findRootAndCompress();
        Container3 root2 = other.findRootAndCompress();

        if (root1 == root2) return;

        int size1 = root1.size;
        int size2 = root2.size;

        double newAmount = ((root1.amount * size1) + (root2.amount * size2)) / (size1 + size2);

        // Join to root2
        if (size1 <= size2) {
            root1.parent = root2;
            root2.amount = newAmount;
            root2.size += size1;
            root2.group.addAll(root1.group);
        } else {
            root2.parent = root1;
            root1.amount = newAmount;
            root1.size += size2;
            root1.group.addAll(root2.group);
        }
    }

    @Override
    public int getGroupSize() {
        Container3 root = findRootAndCompress();
        return root.size;
    }

    @Override
    public List<Container3> getGroup() {
        Container3 root = findRootAndCompress();
        return root.group;
    }

    @Override
    public boolean groupContains(Container3 other) {
        Container3 root = findRootAndCompress();
        return root.group.contains(other);
    }


    private Container3 findRootAndCompress() {
        if (parent != this){
            parent = parent.findRootAndCompress();
        }
        return parent;
    }

    public double getAmount() {
        Container3 root = findRootAndCompress();
        return root.amount;

    }

}
