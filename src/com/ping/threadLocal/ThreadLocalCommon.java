package com.ping.threadLocal;

/**
 * Created by zhangxiaoping on 17/4/21.
 */
public class ThreadLocalCommon {


    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     *
     * @return
     */
    public static ThreadLocal<String> getThreadLocal(){
        return threadLocal;
    }


    /**
     * setValue
     * @param value
     */
    public static void setValue(String value){
        threadLocal.set(value);
    }

    /**
     *
     * @return
     */
    public static String getValue(){
        return threadLocal.get();
    }

    /**
     * 移除
     */
    public static void remove(){
        threadLocal.remove();
    }


}
