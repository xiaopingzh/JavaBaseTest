package com.ping.design.decorator;

public class TestMain {
	
	
	public static void main(String[] args){
        Component component = new ConcreteComponent();
        Component component2 = new ConcreteDecorator(component);
        component2.operation();
	}
}
