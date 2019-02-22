package com.ping;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2017/9/15
 * Time:下午7:38
 */
public class InternalClass {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public InternalClass(int age){
        this.age = age;
    }


    public static void main(String[] args){
        InternalClass internalClass = new InternalClass(1);
        InternalClass.Adog adog = internalClass.new Adog("helloWorld");

    }



    class Adog{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public Adog(String name){
            this.name = name;
        }


    }
}
