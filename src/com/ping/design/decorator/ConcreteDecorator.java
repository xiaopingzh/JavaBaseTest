package com.ping.design.decorator;

/**
 * 具体装饰角色
 * @author 
 *
 * 2016年2月26日 下午2:43:24
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        this.addBehavior();
    }

    private void addBehavior(){
        System.out.println("ok");
    }
}
