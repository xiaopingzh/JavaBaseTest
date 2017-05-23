package com.ping.disLock;

import java.util.HashSet;

/**
 * Created by zhangxiaoping on 17/4/22.
 * 分布式锁Common Class
 * 模拟使用Tair.put方法
 * 另外可以使用incr + 初始值方式实现，针对特定的业务场景
 */
public class DisLockCommon {

    //重试次数
    private static final int TRY_TIME = 3;

    private static final HashSet<String> lockValueSet = new HashSet<String>();


    /**
     * 尝试获取分布式锁
     *
     * @return boolean
     */
    public boolean tryLock() {
        String curThreadLockValue = createUniqueValue();
        if (get(curThreadLockValue)) {
            return true;
        }
        return put(curThreadLockValue);
    }

    /**
     * 解锁
     * @return
     */
    public boolean unLock() {
        return lockValueSet.remove(createUniqueValue());
    }


    /**
     * 分布式锁实现
     * 分布式锁要设置超时时间
     * if exits false
     * else
     *   put
     * @param value
     * @return
     */
    private boolean put(String value) {
        if(lockValueSet.contains(value)){
            return false;
        }
        //如果是是用分布式KV缓存实现则存在add操作成功，但是缓存服务器超时导致Client端感知不到操作成功
        return lockValueSet.add(value);

    }

    /**
     * 判断该线程是否已经加锁成功
     *
     * @param key
     * @return
     */
    private boolean get(String key) {
        return lockValueSet.contains(key);
    }

    /**
     * 以当前线程创建唯一标示
     *
     * @return
     */
    public String createUniqueValue() {
        return Thread.currentThread().getName() + "," + Thread.currentThread().getId();
    }


    public static void main(String[] args) {
        DisLockCommon disLockCommon = new DisLockCommon();
        System.out.println(disLockCommon.createUniqueValue());
    }

}
