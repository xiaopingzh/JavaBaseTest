package com.ping.sort;

import java.util.Stack;

/**
 * 字符串反转
 * @author 
 *
 * 2016年3月15日 下午1:26:01
 */
public class StringReversal {
	
	/**
	 * 只需要遍历该字符串的二分之一部分即可
	 * @param str
	 * @return
	 */
	public String reversalStr(String str){
		if(str == null || str.length() ==0 || str.length() ==1){
			return str;
		}
		char[] mychars = str.toCharArray();
		int end = str.length() -1;
		int middle = end >> 1;
		for(int i=0;i<middle;i++){
			char temp = mychars[end-i];
			mychars[end-i] = mychars[i];
			mychars[i] = temp;
		}
		return String.valueOf(mychars);
	}
	
	
	
	/**
	 * 使用Stack实现
	 * @param str
	 * @return
	 */
	public String reverse5(String str) {
	    if (str == null || str.length() <= 1) {
	        return str;
	    }
	    String result = "";
	    char[] arr = str.toCharArray();
	    Stack<Character> stack = new Stack<Character>();
	    for (char a : arr) {
	        stack.push(a);
	    }
	    int length = stack.size();
	    //注意这个地方必须要先把length暂存起来，因为在遍历的过程中，pop()堆的时候，会改变堆的大小。
	    for (int i = 0; i < length; i++) {
	        result += stack.pop();
	    }
	    return result;
	}
	
	/**
	 * 使用StringBuffer/StringBuilder自带的reverse(),二者均是调用同一个抽象类AbstractStringBuilder的方法
	 * 使用String递归
	 * 使用Stack实现即堆栈，先进后出
	 * @param args
	 */
	public static void main(String[] args){
		String str = "abc";
		System.out.println(new StringBuilder(str).reverse().toString());
		StringReversal test = new StringReversal();
		System.out.println(test.reversalStr("12345678"));
		
	}
	
}
