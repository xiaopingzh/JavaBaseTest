package com.ping.consumer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangxiaoping on 17/5/15.
 *
 * 使用Wait/notify实现生产者、消费者
 */
public class WaitAndNotifyTest {


    private final static int MAX  =2;
    private volatile AtomicInteger atomicInteger = new AtomicInteger(MAX);
    private static final Object prolock = new Object();
    private static final Object conlock = new Object();



    public void testThread(){
        for(int i=0;i<5;i++){
            new Consumer().start();
            new Producer().start();
        }
    }



    public static void main(String[] args){
        new WaitAndNotifyTest().testThread();
    }


    /**
     * 生产者
     */
    class Producer extends Thread{
        public void run(){
            int c ;
            synchronized (prolock){
                while(atomicInteger.get() == MAX){
                    try {
                        prolock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c = atomicInteger.getAndIncrement();
                System.out.println("producer: " + c);
                prolock.notify();
            }

            //如果Increment之前原值为0则生产任务后通知消费者可以消费
            if(c == 0){
                synchronized (conlock){
                    conlock.notify();
                }
            }

        }
    }

    /**
     * 消费者
     */
    class Consumer extends Thread{
        public void run(){
            int c = 0;
            synchronized (conlock){
                while (atomicInteger.get() == 0){
                    try {
                        conlock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c = atomicInteger.getAndDecrement();
                System.out.println("consumer:" + c);
                conlock.notify();
            }

            //表明之前是满的即生产者阻塞，再次唤醒生产者
            if(c == MAX){
                synchronized (prolock){
                    prolock.notify();
                }
            }
        }
    }

}
