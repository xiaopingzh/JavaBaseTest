package com.ping.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by zhangxiaoping on 17/5/1.
 */
public class AtomicIntegerTest {

    public static void main(String[] args){

        AtomicInteger atomicInteger = new AtomicInteger(100);
        atomicInteger.getAndIncrement();


        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<Integer>(100,2);
    }
}
