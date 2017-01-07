package com.ping.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 定时任务线程池执行定时任务
 *
 * Created by zhangxiaoping on 17/1/7.
 */
public class ScheduledThreadPoolTest {

    /**
     * 初始化
     */
    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
            new ScheduledThreadPoolExecutor(5);


    private static AtomicLong atomicLong = new AtomicLong();

    /**
     * 定义线程
     */
    private static class MyTask implements Runnable{

        @Override
        public void run(){
            if(atomicLong.addAndGet(1) >= 10 && !scheduledThreadPoolExecutor.isShutdown()){
                scheduledThreadPoolExecutor.shutdown();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }


    /**
     * 定时执行
     */
    public void runScheduledPool(){
        MyTask myTask = new MyTask();
        //启动6秒后开始执行且每隔5秒再执行一次
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(myTask,6,1, TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        new ScheduledThreadPoolTest().runScheduledPool();
    }
}
