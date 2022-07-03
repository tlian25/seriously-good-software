package com.water;

import com.water.model.Container;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void shouldCreateNewContainer() {
        Container container = new Container();
        Assertions.assertEquals(0, container.getAmount());
    }
}
