package com.longforus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XQ Yang on 8/7/2018  1:54 PM.
 * Description :
 */

class SyncTest {


    public static void main(String[] args) {
        //ThreadTest threadTest = new ThreadTest();
        //        //Thread t1 = new Thread(threadTest);
        //        //Thread t2 = new Thread(threadTest);
        //        //t1.start();
        //        //t2.start();
        //Class<ThreadTest> aClass = ThreadTest.class;
        //System.out.println(aClass.getName());

        try {
            Class<?> aClass1 = Class.forName("com.longforus.ThreadTest");
            System.out.println(aClass1.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTest implements Runnable{
    static {
        System.out.println("static init");
    }



    Lock mLock = new ReentrantLock();
    public void run() {
        mLock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+String.valueOf(i));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            mLock.unlock();
        }
    }
}
