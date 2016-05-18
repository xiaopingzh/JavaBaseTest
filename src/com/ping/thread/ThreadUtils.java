package com.ping.thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtils {
	public static LinkedList<Object> mylist = new 	LinkedList<Object>();
	
	public static int num = 10;
	
	public static AtomicInteger sum = new AtomicInteger(0);
}
