package com.ping.gc;

import java.util.HashMap;

/**
 * Created by zhangxiaoping on 17/4/22.
 */
public class TestMapGc {

    public static final HashMap<Object,String> hashMap = new HashMap<Object, String>();


    public static  void main(String[] args){
        for(int i=0;i<2;i++){
            new Thread(new MyTask()).start();
        }

        System.gc();
        System.out.println(hashMap.size());
    }



    static class MyTask implements Runnable{

        @Override
        public void run() {

            Object key = new Object();

            hashMap.put(key,Thread.currentThread().getName());
        }
    }
}
