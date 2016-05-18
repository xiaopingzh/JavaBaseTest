package con.ping.thread;

import java.util.concurrent.Callable;

/**
 * 继承Callable
 * @author 
 *
 * 2016年1月19日 下午5:07:18
 */
public class TestCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		return this.getClass().getName();
	}
	
}
