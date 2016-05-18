package com.ping.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class StringTest {
	
	/**
	 * final 关键字 数据、Method、Class
	 */
	public final static  Map<String,String> map = new HashMap<String,String>();
	
	public void test08(){
		BigDecimal bg=new BigDecimal("8.3010442E10"); 
		System.out.println(Long.parseLong(bg.toPlainString())/10000/60/24);
		
		long nowSec = Long.parseLong(bg.toPlainString()) + 500480937;
		System.out.println(nowSec);
		
		
//		System.out.println((Long.parseLong(bg.toPlainString()) - 4980605390000L)/(1000*60));
	}
	
	
	/**
	 * 截取小数点后2为
	 */
	public void test001(){
		String x= "23.8778"; 
		NumberFormat ddf1=NumberFormat.getNumberInstance() ;
		ddf1.setMaximumFractionDigits(2); 
		String s= ddf1.format(Double.valueOf(x)) ; 
		System.out.print(s); 
	}
	
	
	public void replace(){
		Object object = new Object();
	}
	
	
	public void test01(){
		String paramsStr = "aa,bba,cc";
		System.out.println(paramsStr.contains("aa,"));
		
		System.out.println(paramsStr.contentEquals("aa"));
	}
	
	public void test02(){
		String pcode = "18311088989";
		System.out.println(pcode.substring(0, 3) + "****" + pcode.substring(7));
	}
	
	
	public void testlength(){
		System.out.println("/zhaoren/demand/n_v1bl2lwxwawimfmkgvojfq.jpg,/zhaoren/demand/n_v1bl2lwtoawimfmnjnneda.jpg,/zhaoren/demand/n_v1bl2lwtobwimfmh43pbtq.jpg".length()*3);
	}
	
	/**
	 * 左移四位
	 */
	public static void test03(){
		System.out.println(32<<4);
	}
	
	/**
	 * 方法重载，仅仅是返回值不同则是不能区分
	 * @param a
	 */
	public static void test03(int a){
		System.out.println(a);
	}
	
	
	public void getMethodsInfo(){
		Method[] methods = StringTest.class.getMethods();
		for(Method method:methods){
			if(method.getName().equals("testlength")){
				try {
					method.invoke(new StringTest(), new Object[]{});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//test final对象是否可以修改
	private final long[] arrays = new long[10];
	
	public void updateMap(){
		Runtime.getRuntime().gc();
		for(int i=0;i<arrays.length;i++){
			arrays[i]=1;
		}
		
//		for(int i=0;i<1000;i++){
//			map.put(i+"", "a");
//		}
//		System.out.println(map.size());
		System.out.println(arrays[1]);
		Object object = new Object();
	}
	
	
	public void test09(){
		char[] chars  = "abc".toCharArray();
		for(char mychar:chars){
			int n = mychar;
			System.out.println(mychar + " " + n);
		}
		System.out.println("b".compareTo("abc"));
		System.out.println(Integer.valueOf("123"));
	}
	
	public void test10(){
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hel" + "lo";
		String s4 = "Hel" + new String("lo");
		String s5 = new String("Hello");
		String s6 = s5.intern();
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;
		          
		System.out.println(s1 == s2);  // true
		System.out.println(s1 == s3);  // true
		System.out.println(s1 == s4);  // false
		System.out.println(s1 == s9);  // false
		System.out.println(s4 == s5);  // false
		System.out.println(s1 == s6);  // true
	}
	
	
	public void test11(){
		Integer a = new Integer(100);
        Integer b = 100;
        Integer c = 100;
        System.out.println(a == b); //false
        System.out.println(b == c); //true
        Integer d = 129;
        Integer e = 129;
        System.out.println(d == e);  //false
	}
	
	public static void main(String[] args){
		new StringTest().test11();
//		System.out.println(mymap.size());
		
	}
}
