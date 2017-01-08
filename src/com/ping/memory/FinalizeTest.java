package com.ping.memory;

/**
 * 使用Finalize方法来进行垃圾回收
 * @author 
 *
 * 2016年3月7日 下午10:57:09
 */
public class FinalizeTest {
	private static FinalizeTest SAVE_HOOK = null;


	public void isAlive(){
		System.out.println("is alive");
	}


	/**
	 * 重写finalize()方法
	 */
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize method executed");
		//在finalize方法中重新创建引用
		FinalizeTest.SAVE_HOOK = this;
	}
	public static void main(String[] args) throws Throwable{
		SAVE_HOOK = new FinalizeTest();
		//引用不可达到，GC，但是finalize()方法中将SAVE_HOOK重新建立了引用，因此该次不会被GC
		SAVE_HOOK = null;
		System.gc();
		//finalize方法优先级很低，因此等待
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("is dead");
		}
		
		//第二次GC能够执行成功，JVM规定任何一个对象的finalize方法只能执行一次，
		//如果该对象面临下一次GC，则finalize()方法不会被执行
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("is dead");
		}
	}
}
