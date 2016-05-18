package com.ping.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * @author zhangxiaoping
 *
 * 2015年5月17日 下午4:40:47
 */
public class LockTest {
	
	ReentrantLock reetranLock =  new ReentrantLock();
	private Condition codition = reetranLock.newCondition();
//	private Condition lockCondition = reetranLock.newCondition();
	
	public void testReetranLock(){
		try {
			
			//提供可轮询的获取方式
//			if(reetranLock.tryLock()){
//				......
//			}
			
			
			
			reetranLock.lock();
			//释放锁
			codition.await();
			//
			codition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reetranLock.unlock();
		}
	}
	
	public static void main(String[] args){
		new LockTest().testReetranLock();
	}
}
