//package com.ping.concurrent.cyclicBarrier;
//
//import java.util.concurrent.CyclicBarrier;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * java.util.concurrent.CyclicBarrier
// * 并发计算
// * @author zhangxiaoping
// *
// */
//public class CyclicBarrierTest {
//
//	private static final int size = 10;
//
//
//	private static AtomicInteger integer = new AtomicInteger(0);
//
//	public void getConValue(){
//		CyclicBarrier cyclicBarrier = new CyclicBarrier(size);
//		//
//		for(int i=0;i<size;i++){
//			new Thread(){
//				public void run(){
//					try {
//						cyclicBarrier.await();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					integer.getAndIncrement();
//					System.out.println(Thread.currentThread().getName());
//				}
//			}.start();
//		}
//
//	}
//}
