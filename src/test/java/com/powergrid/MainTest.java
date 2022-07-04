package com.powergrid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void defaultTest() {
        Appliance tv = new Appliance(150);
        Appliance radio = new Appliance(30);

        Grid grid = new Grid(3000);

        tv.plugInto(grid);
        radio.plugInto(grid);
        Assertions.assertEquals(3000, grid.residualPower());

        tv.on();
        Assertions.assertEquals(2850, grid.residualPower());

        radio.on();
        Assertions.assertEquals(2820, grid.residualPower());

        tv.off();
        Assertions.assertEquals(2970, grid.residualPower());


        Appliance datacenter = new Appliance(100000);
        datacenter.plugInto(grid);

        Assertions.assertThrows(ArithmeticException.class, datacenter::on);
        Assertions.assertFalse(datacenter.getState());
        Assertions.assertEquals(2970, grid.residualPower());

    }
}
