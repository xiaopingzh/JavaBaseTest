//package com.ping.design.proxy;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.text.DecimalFormat;
//
////import javassist.ClassPool;
////import javassist.CtClass;
////import javassist.CtField;
////import javassist.CtNewConstructor;
////import javassist.CtNewMethod;
////import javassist.util.proxy.MethodHandler;
////import javassist.util.proxy.ProxyFactory;
////import javassist.util.proxy.ProxyObject;
////import net.sf.cglib.proxy.Enhancer;
////import net.sf.cglib.proxy.MethodInterceptor;
////import net.sf.cglib.proxy.MethodProxy;
////
////import org.objectweb.asm.ClassWriter;
////import org.objectweb.asm.FieldVisitor;
////import org.objectweb.asm.MethodVisitor;
////import org.objectweb.asm.Opcodes;
//

//动态代理性能分析
//public class DynamicProxyPerformanceTest {
//
//	public static void main(String[] args) throws Exception {
//		BookFacade delegate = new BookFacadeImpl();
//		
//		long time = System.currentTimeMillis();
//		BookFacade jdkProxy = createJdkDynamicProxy(delegate);
//		time = System.currentTimeMillis() - time;
//		System.out.println("Create JDK Proxy: " + time + " ms");
//		
//		time = System.currentTimeMillis();
//		BookFacade cglibProxy = createCglibDynamicProxy(delegate);
//		time = System.currentTimeMillis() - time;
//		System.out.println("Create CGLIB Proxy: " + time + " ms");
//		
//		time = System.currentTimeMillis();
//		BookFacade javassistProxy = createJavassistDynamicProxy(delegate);
//		time = System.currentTimeMillis() - time;
//		System.out.println("Create JAVAASSIST Proxy: " + time + " ms");
//		
//		time = System.currentTimeMillis();
//		BookFacade javassistBytecodeProxy = createJavassistBytecodeDynamicProxy(delegate);
//		time = System.currentTimeMillis() - time;
//		System.out.println("Create JAVAASSIST Bytecode Proxy: " + time + " ms");
//		
//		time = System.currentTimeMillis();
//		BookFacade asmBytecodeProxy = createAsmBytecodeDynamicProxy(delegate);
//		time = System.currentTimeMillis() - time;
//		System.out.println("Create ASM Proxy: " + time + " ms");
//		System.out.println("================");
//		
//		for (int i = 0; i &lt; 3; i++) {
//			test(jdkProxy, "Run JDK Proxy: ");
//			test(cglibProxy, "Run CGLIB Proxy: ");
//			test(javassistProxy, "Run JAVAASSIST Proxy: ");
//			test(javassistBytecodeProxy, "Run JAVAASSIST Bytecode Proxy: ");
//			test(asmBytecodeProxy, "Run ASM Bytecode Proxy: ");
//			System.out.println("----------------");
//		}
//	}
//
//	private static void test(BookFacade service, String label)
//			throws Exception {
//		service.count(); // warm up
//		int count = 10000000;
//		long time = System.currentTimeMillis();
//		for (int i = 0; i &lt; count; i++) {
//			service.count();
//		}
//		time = System.currentTimeMillis() - time;
//		System.out.println(label + time + " ms, " + new DecimalFormat().format(count * 1000 / time) + " t/s");
//	}
//
//	private static BookFacade createJdkDynamicProxy(final BookFacade delegate) {
//		BookFacade jdkProxy = (BookFacade) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
//				new Class[] { BookFacade.class }, new JdkHandler(delegate));
//		return jdkProxy;
//	}
//	
//	private static class JdkHandler implements InvocationHandler {
//
//		final Object delegate;
//
//		JdkHandler(Object delegate) {
//			this.delegate = delegate;
//		}
//
//		public Object invoke(Object object, Method method, Object[] objects)
//				throws Throwable {
//			return method.invoke(delegate, objects);
//		}
//	}
//
//	private static BookFacade createCglibDynamicProxy(final BookFacade delegate) throws Exception {
//		Enhancer enhancer = new Enhancer();
//		enhancer.setCallback(new CglibInterceptor(delegate));
//		enhancer.setInterfaces(new Class[] { BookFacade.class });
//		BookFacade cglibProxy = (BookFacade) enhancer.create();
//		return cglibProxy;
//	}
//
//	private static class CglibInterceptor implements MethodInterceptor {
//		
//		final Object delegate;
//
//		CglibInterceptor(Object delegate) {
//			this.delegate = delegate;
//		}
//
//		public Object intercept(Object object, Method method, Object[] objects,
//				MethodProxy methodProxy) throws Throwable {
//			return methodProxy.invoke(delegate, objects);
//		}
//	}
//
//	private static BookFacade createJavassistDynamicProxy(final BookFacade delegate) throws Exception {
//		ProxyFactory proxyFactory = new ProxyFactory();
//		proxyFactory.setInterfaces(new Class[] { BookFacade.class });
//		Class&lt;?&gt; proxyClass = proxyFactory.createClass();
//		BookFacade javassistProxy = (BookFacade) proxyClass.newInstance();
//		((ProxyObject) javassistProxy).setHandler(new JavaAssitInterceptor(delegate));
//		return javassistProxy;
//	}
//
//	private static class JavaAssitInterceptor implements MethodHandler {
//
//		final Object delegate;
//
//		JavaAssitInterceptor(Object delegate) {
//			this.delegate = delegate;
//		}
//
//		public Object invoke(Object self, Method m, Method proceed,
//				Object[] args) throws Throwable {
//			return m.invoke(delegate, args);
//		}
//	}
//
//	private static BookFacade createJavassistBytecodeDynamicProxy(BookFacade delegate) throws Exception {
//		ClassPool mPool = new ClassPool(true);
//		CtClass mCtc = mPool.makeClass(BookFacade.class.getName() + "JavaassistProxy");
//		mCtc.addInterface(mPool.get(BookFacade.class.getName()));
//		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
//		mCtc.addField(CtField.make("public " + BookFacade.class.getName() + " delegate;", mCtc));
//		mCtc.addMethod(CtNewMethod.make("public int count() { return delegate.count(); }", mCtc));
//		Class&lt;?&gt; pc = mCtc.toClass();
//		BookFacade bytecodeProxy = (BookFacade) pc.newInstance();
//		Field filed = bytecodeProxy.getClass().getField("delegate");
//		filed.set(bytecodeProxy, delegate);
//		return bytecodeProxy;
//	}
//	
//	private static BookFacade createAsmBytecodeDynamicProxy(BookFacade delegate) throws Exception {
//		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
//		String className = BookFacade.class.getName() +  "AsmProxy";
//		String classPath = className.replace('.', '/');
//		String interfacePath = BookFacade.class.getName().replace('.', '/');
//		classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, classPath, null, "java/lang/Object", new String[] {interfacePath});
//		
//		MethodVisitor initVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "&lt;init&gt;", "()V", null, null);
//		initVisitor.visitCode();
//		initVisitor.visitVarInsn(Opcodes.ALOAD, 0);
//		initVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "&lt;init&gt;", "()V");
//		initVisitor.visitInsn(Opcodes.RETURN);
//		initVisitor.visitMaxs(0, 0);
//		initVisitor.visitEnd();
//		
//		FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PUBLIC, "delegate", "L" + interfacePath + ";", null, null);
//		fieldVisitor.visitEnd();
//		
//		MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "count", "()I", null, null);
//		methodVisitor.visitCode();
//		methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
//		methodVisitor.visitFieldInsn(Opcodes.GETFIELD, classPath, "delegate", "L" + interfacePath + ";");
//		methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, interfacePath, "count", "()I");
//		methodVisitor.visitInsn(Opcodes.IRETURN);
//		methodVisitor.visitMaxs(0, 0);
//		methodVisitor.visitEnd();
//		
//		classWriter.visitEnd();
//		byte[] code = classWriter.toByteArray();
//		BookFacade bytecodeProxy = (BookFacade) new ByteArrayClassLoader().getClass(className, code).newInstance();
//		Field filed = bytecodeProxy.getClass().getField("delegate");
//		filed.set(bytecodeProxy, delegate);
//		return bytecodeProxy;
//	}
//	
//	private static class ByteArrayClassLoader extends ClassLoader {
//
//		public ByteArrayClassLoader() {
//			super(ByteArrayClassLoader.class.getClassLoader());
//		}
//
//		public synchronized Class&lt;?&gt; getClass(String name, byte[] code) {
//			if (name == null) {
//				throw new IllegalArgumentException("");
//			}
//			return defineClass(name, code, 0, code.length);
//		}
//
//	}
//}
//
