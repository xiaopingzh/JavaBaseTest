package com.ping.thread;

import java.util.concurrent.Callable;


/**
 * 创建一个县城
 * @author 
 *
 * 2016年2月29日 下午1:23:45
 */
public class ThreadTets implements Callable<Integer>{
	
	@Override
	public Integer call(){
		System.out.println(Thread.currentThread().getId());
		
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
	}
}
