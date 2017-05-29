package com.ping.gc;

/**
 * Created by zhangxiaoping on 17/2/12.
 */
public class TestEden {


    private static final int _1MB = 1024 * 1024;


    /**
     * 将VM参数设置为-Xms20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 即新生代10M，同时Eden:Sur = 8:2
     */
    public void testEden(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //分配6M后Eden已经不能够再次分配则进行Monitor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args){
        new TestEden().testEden();
    }

}
