package com.water.container;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Container2Test {

    private Container2 container;

    @BeforeEach
    void initContainer() {
        container = new Container2();
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

        Container2 container2 = new Container2();
        container.connectTo(container2);

        for (Container2 c: List.of(container, container2)) {
            Assertions.assertEquals(100.0/2, c.getAmount());
            Assertions.assertEquals(2, c.getGroupSize());
        }

        Container2 container3 = new Container2();
        container.connectTo(container3);
        for (Container2 c: List.of(container, container2, container3)) {
            Assertions.assertEquals(100.0/3, c.getAmount());
            Assertions.assertEquals(3, c.getGroupSize());
        }

        for (Container2 c: container.getGroup()) {
            Assertions.assertTrue(container.groupContains(c));
        }

    }





}
