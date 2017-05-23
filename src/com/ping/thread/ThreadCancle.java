package com.ping.thread;

import com.ping.thread.future.MyThread;

/**
 * Created by zhangxiaoping on 17/4/15.
 */
public class ThreadCancle {


    public static void main(String[] args){

        Thread thread = new MyTask();

        thread.start();


    }


    static class MyTask extends Thread {

        @Override
        public  void run(){
            System.out.println();
        }
    }

}
