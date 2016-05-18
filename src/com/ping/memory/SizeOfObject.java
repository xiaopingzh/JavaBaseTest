package com.ping.memory;

/**
 * 判断一个实例对象所占用的内存大小
 * @author zhangxiaoping
 *
 * 压缩指针是否开启
 * 对象头： 8byte + 指向方法区Class对象的指针(开启指针压缩==4byte 未开启==8byte)
 * 2015年7月12日 下午2:36:21
 */
public class SizeOfObject extends SizeOf {

	@Override
	protected Object newInstance() {
		/**
		 * 基本对象
		 */
		return new Object();   //16个字节
//		return new Integer(0); //12 + 4
//		return new Long(0);	//12 + 8
//		return new Double(0.00);
		/**
		 * 自定义对象所占
		 */
//		return new TestLong();
//		return new NewObject();
		
		/**
		 * 数组所占
		 */
//		return new Integer[0]; //16byte
//		return new Integer[1]; //24byte
//		return new Integer[2];// 16 + 2*4
		
		
//		return new Long[3];
//		return new Long[10]; // 16 + 10*4byte + 4byte() = 56byte
		
	}

	public static void main(String[] args) throws Exception {
		SizeOf sizeOf = new SizeOfObject();
		System.out.println("所占内存：" + sizeOf.size() + "字节");
		System.exit(0);
	}
}
