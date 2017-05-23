package com.ping.concurrent.countDownLatch;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangxiaoping on 17/4/22.
 */
public class GcForCountLatchDown {


    public static final int countDownValue = 10;

    public static final ExecutorService executor = Executors.newFixedThreadPool(countDownValue);

    public final HashMap<Object,String> hashMap = new HashMap<Object, String>();

    public void test01() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(countDownValue);
        for(int i=0;i<countDownValue;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Object obj = new Object();
                    hashMap.put(obj,Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.gc();
        System.out.println(hashMap.size());
    }


    public static void main(String[] args){
        try {
            GcForCountLatchDown latchDown = new GcForCountLatchDown();
            latchDown.test01();
            System.out.println(latchDown.hashMap.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
