package com.ping.design.decorator;

/**
 * 具体构建角色
 * @author 
 *
 * 2016年2月26日 下午2:41:18
 */
public class ConcreteComponent implements Component{

	@Override
	public void operation() {
		System.out.println("具体的功能");
	}
}
