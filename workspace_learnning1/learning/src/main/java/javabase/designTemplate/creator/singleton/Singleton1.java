package javabase.designTemplate.creator.singleton;

/**
 * 懒汉式，需要才被实例化
 * @author Administrator
 *
 */
public class Singleton1 {
	private static Singleton1  ton;
	private Singleton1(){
		
	}
	public static synchronized Singleton1  getSingleton1(){
		if(ton==null){
			ton = new Singleton1();
		}
		return ton;
	}
}
