package com.water.container;

// Circular Linked List implementation
// Constant time connects
// O(n) time to getAmount()
// Lazy evaluation in getting amount

import java.util.ArrayList;
import java.util.List;

public class Container2 implements Container<Container2> {

    private double amount;
    private Container2 next = this;

    @Override
    public void addWater(double amount) {
        this.amount += amount;
    }

    @Override
    public void connectTo(Container2 other) {
        Container2 oldNext = next;
        next = other.next;
        other.next = oldNext;
    }

    public double getAmount() {
        updateGroup();
        return amount;
    }


    private void updateGroup() {
        Container2 current = this;
        double totalAmount = 0;
        int groupSize = 0;

        // First pass to collect amount and count
        do {
            totalAmount += current.amount;
            groupSize++;
            current = current.next;
        } while (current != this);

        double newAmount = totalAmount / groupSize;

        // Second pass to update amounts
        current = this;
        do {
            current.amount = newAmount;
            current = current.next;
        } while (current != this);
    }

    @Override
    public int getGroupSize() {
        Container2 current = this;
        int groupSize = 0;

        do {
            groupSize++;
            current = current.next;
        } while (current != this);

        return groupSize;
    }


    @Override
    public boolean groupContains(Container2 other) {
        Container2 current = this;

        do {
            if (current == other) {
                return true;
            }
            current = current.next;
        } while (current != this);

        return false;
    }

    @Override
    public List<Container2> getGroup() {
        List<Container2> group = new ArrayList<>();

        Container2 current = this;

        do {
            group.add(current);
            current = current.next;
        } while (current != this);

        return group;
    }

}
