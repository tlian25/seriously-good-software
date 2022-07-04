package com.water.container;

import java.util.*;

public interface Container<T> {

    void addWater(double amount);

    void connectTo(T other);

    int getGroupSize();

    List<T> getGroup();

    boolean groupContains(T other);


}
