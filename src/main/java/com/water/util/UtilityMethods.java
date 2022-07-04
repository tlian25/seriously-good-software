package com.water.util;

import com.water.container.Container1;

import java.util.Set;

public class UtilityMethods {

    public static void connectGroups(Set<Container1> group1, Set<Container1> group2, double newAmount) {
        // Merge the two groups
        group1.addAll(group2);

        //Update group of containers connected with other
        for (Container1 c: group2) { c.setGroup(group1); }

        //Update amount of all newly connected containers
        for (Container1 c: group1) {c.setAmount(newAmount); }
    }
}
