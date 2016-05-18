package com.ping.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 判断一个实例对象所占的内存大小
 * 抽象类
 * @author zhangxiaoping
 *
 * 2015年7月12日 下午2:36:45
 */
public abstract class SizeOf {
	
	
	public static void getinf(){
		
	};
	
	
	public static int getinf(int a){
		return a;
	}

	private final Runtime s_runtime = Runtime.getRuntime();

	/**
	 *
	 * 子类负责覆盖该方法以提供被测试类的实例
	 *
	 * @return 被测试类的实例
	 */
	protected abstract Object newInstance();

	/**
	 *
	 * 计算实例的大小（字节数）
	 *
	 * @return 实例所占内存的字节数
	 * @throws Exception
	 */
	public int size() throws Exception {
		// 垃圾回收
		runGC();
		// 提供尽可能多（10万）的实例以使计算结果更精确
		final int count = 100000;
		Object[] objects = new Object[count];
		// 实例化前堆已使用大小
		long heap1 = usedMemory();
		// 多实例化一个对象
		for (int i = -1; i < count; ++i) {
			Object object = null;
			// 实例化对象
			object = newInstance();
			if (i >= 0) {
				objects[i] = object;
			} else {
				// 释放第一个对象
				object = null;
				// 垃圾收集
				runGC();
				// 实例化之前堆已使用大小
				heap1 = usedMemory();
			}
		}

		runGC();
		// 实例化之后堆已使用大小
		long heap2 = usedMemory();
		//635520 2235880
		System.out.println(heap1  + " " + heap2);
		final int size = Math.round(((float) (heap2 - heap1)) / count);
		
		// 释放内存,并计算释放内存后的内存使用量  
//		636888 236872
		for (int i = 0; i < count; ++i) {
			objects[i] = null;
		}
		//400000 + 16字节，即10000个对象引用（每个四字节）
		objects = null;
		runGC();
		long size2 = usedMemory();
		System.out.println(size2);
		
		return size;
	}
	
	
	public long sizemap1() throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		// 垃圾回收
		runGC();
		long heap1 = usedMemory();
		final int count = 100000;
		Object object = null;
		for(int i=0;i<count;++i){
			object = newInstance();
			map.put(i+"", object);
		}
		runGC();
		//计算创建MAP后的使用内存
		long heap2 = usedMemory();
		System.out.println(heap1 + " " + heap2);
		final long  size = (heap2 - heap1);
		
		//计算clear后的使用内存, 没有使用clear前为11607872 ，使用clear后为1288256，将map=null后239616，因此clear是将对应的Entry对应的内存释放，
		map.clear();
		//map的引用；
//		map = null;
		runGC();
		System.out.println(usedMemory());
		
		return size;
	}
	
	
	
	/**
	 * 执行GC
	 * @throws Exception
	 */
	private void runGC() throws Exception {
		// 执行多次以使内存收集更有效
		for (int r = 0; r < 4; ++r) {
			_runGC();
		}
	}

	private void _runGC() throws Exception {
		long usedMem1 = usedMemory();
		long usedMem2 = Long.MAX_VALUE;
		for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i) {
			s_runtime.runFinalization();
			s_runtime.gc();
			Thread.currentThread();
			Thread.yield();
			usedMem2 = usedMem1;
			usedMem1 = usedMemory();
		}
	}

	/**
	 * 堆中已使用内存
	 * @return 堆中已使用内存
	 */
	private long usedMemory() {
		return s_runtime.totalMemory() - s_runtime.freeMemory();
	}
}
