package javabase.designTemplate.creator.singleton;
/**
 * 饿汉式，class文件被加载时就初始化
 * @author Administrator
 * 
 */
public class Singleton3 {
	private static Singleton3  ton=new Singleton3();
	private Singleton3(){
		
	}
	public static Singleton3   getSingleton3(){
		return ton;
	}
}
