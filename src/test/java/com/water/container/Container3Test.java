package com.water.container;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Container3Test {

    private Container3 container;

    @BeforeEach
    void initContainer() {
        container = new Container3();
    }

    @Test
    @DisplayName("Create new container")
    void shouldCreateNewContainer() {
        Assertions.assertEquals(0, container.getAmount());
        Assertions.assertEquals(1, container.getGroupSize());
    }

    @Test
    @DisplayName("Add water into container")
    void shouldAddWater() {
       container.addWater(100);
       Assertions.assertEquals(100, container.getAmount());
    }


    @Test
    @DisplayName("Connect containers")
    void shouldConnectContainers() {
        container.addWater(100);

        Container3 container2 = new Container3();
        container.connectTo(container2);

        for (Container3 c: List.of(container, container2)) {
            Assertions.assertEquals(100.0/2, c.getAmount());
            Assertions.assertEquals(2, c.getGroupSize());
        }

        Container3 container3 = new Container3();
        container3.addWater(100);
        container.connectTo(container3);
        for (Container3 c: List.of(container, container2, container3)) {
            Assertions.assertEquals(200.0/3, c.getAmount());
            Assertions.assertEquals(3, c.getGroupSize());
        }

        for (Container3 c: container.getGroup()) {
            Assertions.assertTrue(container.groupContains(c));
        }

    }





}
