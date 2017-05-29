package com.ping.queue;

import java.sql.Time;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangxiaoping on 17/5/13.
 */
public class QueueTest {


    private static LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(20);


    public void testQueue(){

        try {
            linkedBlockingQueue.offer("aaa",100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            linkedBlockingQueue.put("bbb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            linkedBlockingQueue.take();
            String ss = linkedBlockingQueue.poll(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(){

    }
}
