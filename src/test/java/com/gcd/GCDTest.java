package com.gcd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class GCDTest {


    @Test
    void iterations() {
        GCD.main(new String[0]);
    }

    @Test
    void test1() {
        int x = GCD.greatestCommonDivisor(2, 2);
        Assertions.assertEquals(2, x);
    }

    @Test
   void test2() {
        int x = GCD.greatestCommonDivisor(0, 2);
        Assertions.assertEquals(2, x);
    }

    @Test
    void test3() {
        int x = GCD.greatestCommonDivisor(1, 2);
        Assertions.assertEquals(1, x);
    }

    @Test
    void test4() {
        int x = GCD.greatestCommonDivisor(4, 6);
        Assertions.assertEquals(2, x);
    }

    @Test
    void test5() {
        int x = GCD.greatestCommonDivisor(0, 0);
        Assertions.assertEquals(0, x);
    }

    @Test
    void test6() {
        int x = GCD.greatestCommonDivisor(36, 14);
        Assertions.assertEquals(2, x);
    }
}

