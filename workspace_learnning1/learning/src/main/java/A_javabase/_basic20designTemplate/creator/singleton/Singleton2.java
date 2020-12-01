package A_javabase._basic20designTemplate.creator.singleton;

/**
 * 懒汉式第二种写法，双重校验锁，效率更高
 */
public class Singleton2 {
	private static Singleton2  ton;
	private Singleton2(){
		
	}
	public static  Singleton2  getSingleton2(){
		if(ton==null){
			synchronized(Singleton2.class){
				if(ton==null){
					ton = new Singleton2();
				}				
			}
		}
		return ton;
	}
}
