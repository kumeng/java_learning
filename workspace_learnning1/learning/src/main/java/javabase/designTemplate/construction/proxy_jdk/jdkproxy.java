package javabase.designTemplate.construction.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * jdk动态代理，只能代理实现了接口InvocationHandler的类
 * @author Administrator
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
