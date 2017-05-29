package com.ping.design.proxy;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhangxiaoping on 17/5/12.
 */
public class CreateObject {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public CreateObject(String name){
        this.name = name;
    }


    public void test01(){
        try {
            CreateObject createObject =  (CreateObject)CreateObject.class.getConstructors()[0].newInstance("xiaping");

            System.out.println(createObject.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new CreateObject("aa").test01();
    }
}
