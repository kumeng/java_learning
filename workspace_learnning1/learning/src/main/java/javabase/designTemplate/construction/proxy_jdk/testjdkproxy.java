package javabase.designTemplate.construction.proxy_jdk;

import java.lang.reflect.Proxy;

import javabase.designTemplate.construction.proxy_static.house;
import javabase.designTemplate.construction.proxy_static.maifang_x1;

/**
 * 
 * @author Administrator
 *
 */
public class testjdkproxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maifang_x1 x1 = new maifang_x1();
		jdkproxy prox = new jdkproxy(x1);
		house h = (house) Proxy.newProxyInstance(maifang_x1.class.getClassLoader()
				, maifang_x1.class.getInterfaces(), prox);
		h.maifang();
		
	}

}
