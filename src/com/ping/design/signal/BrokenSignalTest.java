package com.ping.design.signal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 破坏单例的几种方法
 * 反射：将private的构造器设置为可以访问
 * 序列化：
 * @author zhangxiaoping
 *
 */
public class BrokenSignalTest {

	/**
	 * 使用反射可以破坏单例模式
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void test01() throws Exception {
		Constructor[] constructors = SigInstanceVolatile.class.getDeclaredConstructors();
		Constructor constructor = constructors[0];
		constructor.setAccessible(true);
		SigInstanceVolatile signalMain0 = (SigInstanceVolatile) constructor
				.newInstance(new Object[0]);
		SigInstanceVolatile signalMain1 = SigInstanceVolatile.getInstance();
		System.out.println(signalMain0.hashCode() == signalMain1.hashCode());// false
	}

	/**
	 * 使用序列化破坏单例模式
	 * 
	 * @throws Exception
	 */
	public void testSerializable() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"/Users/a58/Desktop/tempFile.txt"));
		oos.writeObject(SigInstanceVolatile.getInstance());
		File file = new File("/Users/a58/Desktop/tempFile.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		SigInstanceVolatile newInstance = (SigInstanceVolatile) ois.readObject();
		System.out.println(newInstance == SigInstanceVolatile.getInstance());
	}

	/**
	 * 使用反射破坏使用枚举创建的单例模式
	 * 
	 * @throws Exception
	 */
	public void testEnumSignal() throws Exception {
		Constructor con = SignalEnum.class.getDeclaredConstructors()[0];
		Method[] methods = con.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals("acquireConstructorAccessor")) {
				method.setAccessible(true);
				method.invoke(con, new Object[0]);
			}
		}
		Field[] fields = con.getClass().getDeclaredFields();
		Object ca = null;
		for (Field field : fields) {
			if (field.getName().equals("constructorAccessor")) {
				field.setAccessible(true);
				ca = field.get(con);
			}
		}
		Method method = ca.getClass().getMethod("newInstance",new Class[] { Object[].class });
		method.setAccessible(true);
		SignalEnum spuriousEnum = (SignalEnum) method.invoke(ca,
				new Object[] { new Object[] { "SPURIOUS_INSTANCE", 1 } });
		System.out.println(SignalEnum.INSTANCE == spuriousEnum);
	}

	private static void printInfo(SignalEnum e) {
		System.out.println(e.getClass() + ":" + e.name() + ":" + e.ordinal());
	}

	public static void main(String[] args) {
		try {
			new BrokenSignalTest().testEnumSignal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
