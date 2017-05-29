package com.ping.classload;

/**
 * Created by zhangxiaoping on 17/5/13.
 */
public class Dog {

    static{
        System.out.println(Thread.currentThread().getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Dog(){

    }

    public Dog(String name){
        this.name = name;
    }
}
