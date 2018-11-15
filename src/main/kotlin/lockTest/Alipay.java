package lockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XQ Yang on 10/24/2018  3:43 PM.
 * Description :
 */

public class Alipay {
    private final Object        oLock;
    private       double[]      accounts;
    private       ReentrantLock mLock;
    private       Condition     mCondition;

    public Alipay(int size, double initMoney) {
        accounts = new double[size];
        mLock = new ReentrantLock();
        oLock = new Object();
        mCondition = mLock.newCondition();
        for (int i = 0; i < size; i++) {
            accounts[i] = initMoney;
        }
    }

    public static void main(String... args) {
        Alipay alipay = new Alipay(10, 500);
        Thread t1 = new Thread(() -> {
            try {
                alipay.transferV3(0, 1, 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                alipay.transferV3(3, 0, 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        //延迟启动t2,凸显等待效果.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    public void transfer(int from, int to, double money) throws InterruptedException {
        mLock.lock();//获得锁
        System.out.println(Thread.currentThread().getName() + " enter");
        try {
            while (accounts[from] < money) {
                System.out.println("accounts[from] < money await " + Thread.currentThread().getName());
                //条件不达到,阻塞当前线程,并放弃锁
                mCondition.await();
            }
            accounts[from] -= money;
            accounts[to] += money;
            System.out.println("success form = " + accounts[from] + " " + Thread.currentThread().getName());
            System.out.println("success to = " + accounts[to] + " " + Thread.currentThread().getName());
            //解除等待线程的阻塞， 以便这些线程能
            //够在当前线程退出同步方法后， 通过竞争实现对对象的访问
            mCondition.signalAll();
        } finally {
            System.out.println(Thread.currentThread().getName() + " exit");
            mLock.unlock();//在这里释放锁是必须的,防止运行中出现异常没有放弃锁,导致死锁.
        }
    }

    public synchronized void transferV2(int from, int to, double money) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " enter");
        while (accounts[from] < money) {
            System.out.println("accounts[from] < money await " + Thread.currentThread().getName());
            //条件不达到,阻塞当前线程,并放弃锁
            wait();
        }
        accounts[from] -= money;
        accounts[to] += money;
        System.out.println("success form = " + accounts[from] + " " + Thread.currentThread().getName());
        System.out.println("success to = " + accounts[to] + " " + Thread.currentThread().getName());
        //解除等待线程的阻塞， 以便这些线程能
        //够在当前线程退出同步方法后， 通过竞争实现对对象的访问
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " exit");
    }

    public void transferV3(int from, int to, double money) throws InterruptedException {
        synchronized (oLock) {
            System.out.println(Thread.currentThread().getName() + " enter");
            while (accounts[from] < money) {
                System.out.println("accounts[from] < money await " + Thread.currentThread().getName());
                //条件不达到,阻塞当前线程,并放弃锁
                oLock.wait();
            }
            accounts[from] -= money;
            accounts[to] += money;
            System.out.println("success form = " + accounts[from] + " " + Thread.currentThread().getName());
            System.out.println("success to = " + accounts[to] + " " + Thread.currentThread().getName());
            //唤醒使用这个锁wait的其他线程
            oLock.notifyAll();
            System.out.println(Thread.currentThread().getName() + " exit");
        }
    }
}
