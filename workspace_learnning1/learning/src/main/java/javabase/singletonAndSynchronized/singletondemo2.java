package javabase.singletonAndSynchronized;

/**
 * 方法二
 *  单例模式的实现：懒汉式,非线程安全  
 */
public class singletondemo2 extends warehouse{
	private singletondemo2(int num){
		super(num);
	}
	private static   singletondemo2  instance  ;
	public static singletondemo2 getNewInstance(){
		if(instance == null){
			instance = new singletondemo2(10);
		}
		return instance;
	}
}
