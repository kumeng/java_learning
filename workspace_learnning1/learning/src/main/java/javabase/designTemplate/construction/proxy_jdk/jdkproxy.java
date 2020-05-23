package javabase.designTemplate.construction.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * jdk动态代理，通过实现接口InvocationHandler来实现代理
 * @author Administrator
 *jdk动态代理，,必须是接口中定义的方法才可以，没有再接口中定义的方法，不能被代理
 *
 */
public class jdkproxy implements InvocationHandler {
	
	private Object tarobj;
	public jdkproxy(Object tarobj1){
		tarobj = tarobj1;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("jdk代理操作之前的操作，也可以理解为监听开始");
		Object invoke = method.invoke(tarobj, args);
		System.out.println("jdk代理操作之后的操作，也可以理解为监听结束");
		return invoke;
	}

}
