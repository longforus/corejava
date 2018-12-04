package com.longforus;

/**
 * @author longforus
 * @describe
 * @date 11/19/2018  6:49 PM
 */
public class NullIns {
    public static void main(String... args) {
        String str = null;
        System.out.println(str instanceof String);//instanceof的参数1可以为null
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
