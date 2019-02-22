package com.ping.consumer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangxiaoping on 17/5/15.
 */
public class LockWaitAndNotifyTest {

    private static final int MAX = 2;
    private static final AtomicInteger atomicInteger = new AtomicInteger(MAX);


    private static final ReentrantLock takeLock = new ReentrantLock();
    public Condition takeCondition = takeLock.newCondition();

    private static final ReentrantLock putLock = new ReentrantLock();
    public Condition putCondition = putLock.newCondition();

    class Producer implements Runnable{
        @Override
        public void run() {
            int c;
            putLock.tryLock();
            try{
                while(atomicInteger.get() == MAX){
                    try {
                        putCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                putLock.unlock();
            }
            c = atomicInteger.getAndIncrement();
            if(c == 0){
                takeCondition.signal();
            }
        }
    }


    class Consumer implements Runnable{

        @Override
        public void run() {
            int c;


        }
    }

}
