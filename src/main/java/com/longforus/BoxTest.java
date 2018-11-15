package com.longforus;

/**
 * @author longforus
 * @describe
 * @date 11/12/2018  6:47 PM
 */
public class BoxTest {
    public static void main(String... args) {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("time = " + (System.currentTimeMillis() - start));
    }


}

