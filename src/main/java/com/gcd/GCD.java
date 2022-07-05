package com.gcd;

import javax.management.relation.RelationNotFoundException;
import java.util.Random;

public class GCD {

    public static void main(String[] args) {
        final Random random = new Random();
        final int ITERATIONS = 1000;
        final int LOWER = -1000;
        final int UPPER = 1000;


        for (int i=0; i<ITERATIONS; i++) {
            int a = randomInt(LOWER, UPPER);
            int b = randomInt(LOWER, UPPER);
            int g = GCD.greatestCommonDivisor(a, b);
            System.out.println(String.format("GCD: %d, %d -> %d", a, b, g));
        }
    }


    public static int greatestCommonDivisor(int u, int v) {

        final int originalu = u;
        final int originalv = v;

        if (u == 0 || v == 0) {
            if (u == Integer.MIN_VALUE || v == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }

            int result = Math.abs(u) + Math.abs(v);
            assert isGCD(result, originalu, originalv): "Not gcd";
            return result;
        }

        if (Math.abs(u) == 1 || Math.abs(v) == 1) {
            int result = 1;
            assert isGCD(result, originalu, originalv): "Not gcd";
            return result;
        }

        if (u > 0) u =-u;
        if (v > 0) v = -v;

        int k = 0;
        while ((u & 1) == 0 && (v & 1) == 0 && k < 31) {
            u /= 2;
            v /= 2;
            k++;
        }

        if (k == 31) {
            throw new ArithmeticException("overflow: gcd is 2^31");
        }

        int t = (u & 1) == 1 ? v : -(u / 2);
        do {
            while ((t & 1) == 0) { t /= 2; }
            if (t > 0) { u = -t; }
            else { v = t; }
            t = (v-u) / 2;
        } while (t != 0);


        int result = -u * (1 << k);

        // postcondition assertions
        assert result >= 0: "result >= 0";
        assert isGCD(result, originalu, originalv): "Not gcd";

        return result;
    }

    private static boolean isGCD(int gcd, int u, int v) {
        System.out.println(String.format("running assertion: %d, %d -> %d", u, v, gcd));

        if (u == 0 && v == 0) return gcd == 0;

        if (u % gcd != 0 || v % gcd != 0) return false;

        for (int i=gcd+1; i<=u && i<=v; i++) {
            if (u % i == 0 && v % i == 0) return false;
        }

        return true;
    }

    private static int randomInt(int lower, int upper) {
        final Random random = new Random();
        int i = random.nextInt(upper - lower) + lower;
        return i;
    }
}
