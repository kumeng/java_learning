package A_javabase._basic20designTemplate.construction.proxy_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


/**
 * cglib代理
 * 对指定目标类产生一个子类，通过方法拦截技术拦截所有父类方法的调用。
 * 需要cglib jar包，springAOP通过此方式实现
 * @author Administrator
 *
 */
public class proxycglib implements MethodInterceptor {
	
	
	private Enhancer  enhancer = new Enhancer();
	

	public Object  getproxy(Class<?> c){
		enhancer.setSuperclass(c);
		enhancer.setCallback(this);
		return enhancer.create();
	}	

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("中介cglib代理，监听开始");
		Object invoke = arg3.invokeSuper(arg0, arg2);
		System.out.println("中介cglib代理，监听结束");
		return invoke;
	}

}
