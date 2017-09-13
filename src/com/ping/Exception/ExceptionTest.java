package com.ping.Exception;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2017/9/13
 * Time:下午8:17
 */
public class ExceptionTest {


    public void test() {
        throw new NullPointerException("is wrong");
    }


    public static void main(String[] args){
        new ExceptionTest().test();
    }
}
