package com.ping.threadLocal;

/**
 * Created by zhangxiaoping on 17/4/21.
 * 是用ThreadLocal
 */
public class ThreadLocalMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        ThreadLocalCommon.setValue(Thread.currentThread().getName());

        for (int  i=0;i<2;i++){
            new Thread(new MyTask()).start();
        }
        ThreadLocalCommon.remove();
        System.out.println(ThreadLocalCommon.getValue());
    }


    /**
     * 自定义线程
     *
     */
    static class  MyTask implements Runnable{
        public MyTask(){

        }

        @Override
        public void run(){
            ThreadLocalCommon.setValue(Thread.currentThread().getName());
            System.out.println(ThreadLocalCommon.getValue());
            ThreadLocalCommon.remove();
        }
    }
}
