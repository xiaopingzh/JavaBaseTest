package com.ping.test;

/**
 * cpu sy 高
 * 线程频繁切换
 * @author zhangxiaoping
 *
 * 2015年5月16日 下午7:06:02
 */
public class Spike {
	 
    public static void main(String[] args) throws Exception{
        new Spike().go();
    }
 
    public void go(){
        for (int i = 0; i < 200; i++) {
            new Thread(new Yield()).start();
        }
    }
 
    class Yield implements Runnable{
 
        public void run() {
            while(true){
                Thread.yield();
                try {
                    Thread.sleep(1);
                } 
                catch (InterruptedException e) {
                    // IGNORE
                }
            }   
        }
 
    }
}
