package javabase.designTemplate.construction.proxy_jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

import javabase.designTemplate.construction.proxy_static.house;
import javabase.designTemplate.construction.proxy_static.maifang_x1;
import javabase.designTemplate.construction.proxy_static.maizhuangxiu;

/**
 * 
 * @author Administrator
 *
 */
public class testjdkproxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long p1 = System.currentTimeMillis();			
		maifang_x1 x1 = new maifang_x1();
		jdkproxy prox = new jdkproxy(x1);
		house h = (house) Proxy.newProxyInstance(maifang_x1.class.getClassLoader()
				, maifang_x1.class.getInterfaces(), prox);
		Long p2 = System.currentTimeMillis();
		h.maifang();
		Long p3 = System.currentTimeMillis();
		System.out.println("初始化时间:"+(p2-p1)/1000);
		System.out.println("执行时间:"+(p3-p2)/1000);				
	}
	//测试jdk动态代理的局限性,必须是接口中定义的方法才可以，没有再接口中定义的方法，不能被代理
	@Test
	public void test(){
		maizhuangxiu x1 = new maizhuangxiu();
		jdkproxy prox = new jdkproxy(x1);
		house h = (house) Proxy.newProxyInstance(maifang_x1.class.getClassLoader()
				, maifang_x1.class.getInterfaces(), prox);
		h.maifang();		
		//下面不能执行
		maizhuangxiu h2 = (maizhuangxiu) Proxy.newProxyInstance(maizhuangxiu.class.getClassLoader()
				, maizhuangxiu.class.getInterfaces(), prox);
		h2.maizhuangxiu();			
	}

}
