package com.ping.memory;


/**
 * 在开通指针压缩后即：-XX:+UseCompressedOops
 * 只包含 一个int属性 其实例化对象占 12(head) +4(int)  =16byte
 * @author zhangxiaoping
 *
 * 2015年7月12日 下午5:58:55
 */
public class NewObject {
	int a;
	int c;
	Integer b;
}
