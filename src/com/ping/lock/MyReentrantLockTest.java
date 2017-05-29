package com.ping.lock;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhangxiaoping on 17/5/16.
 */
public class MyReentrantLockTest extends AbstractQueuedSynchronizer {


    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    /**
     * 创建TryLock
     * @param var1
     * @return
     */
    public boolean tryLock(int var1){
        int var2 = this.getState();
        Thread thread = Thread.currentThread();
        if( var2 == 0){
            if(this.compareAndSetState(var2,var1)){
                setExclusiveOwnerThread(thread);
                return true;
            }
        }
        if(thread == getExclusiveOwnerThread()){
            setState(var2 + var1);
            return true;
        }
        return false;
    }

    public void test(){
        reentrantReadWriteLock.readLock().tryLock();
        reentrantReadWriteLock.writeLock().tryLock();
        reentrantReadWriteLock.writeLock().unlock();
    }

}
