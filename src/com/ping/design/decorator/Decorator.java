package com.ping.design.decorator;

/**
 * 装饰角色
 * @author 
 *
 * 2016年2月26日 下午2:42:16
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}
