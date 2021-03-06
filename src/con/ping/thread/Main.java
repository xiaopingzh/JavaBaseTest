package con.ping.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 
 * @author 
 *
 * 2016年1月19日 下午5:07:11
 */
public class Main {

	/**
	 * 使用单例模式创建的实例执行线程
	 * 并获取返回值
	 */
	public void test01(){
		Future<String> future = ThreadPoolInstance.getInstance().submit(new TestCallable());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	public void testMyThreadPoolExecutor(){
		Future<String> future = MyThreadPoolExecutor.getInstance().submit(new TestCallable());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}




	public static void main(String[] args){
		System.out.println(Main.class.getClassLoader().toString());
		new Main().test01();
		System.exit(0);
	}
}
