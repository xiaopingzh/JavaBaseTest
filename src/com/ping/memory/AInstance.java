package com.ping.memory;

import com.ping.classload.A;
import con.ping.thread.MyThreadFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2017/9/13
 * Time:上午10:33
 */
public class AInstance {

    private static ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool
            (3);

    public AInstance(){
        scheduExec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            new AInstance();
        }
    }
}
