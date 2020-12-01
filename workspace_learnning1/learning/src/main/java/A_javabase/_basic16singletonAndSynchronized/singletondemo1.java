package A_javabase._basic16singletonAndSynchronized;

/**
 * 方法一
 * 单例模式的实现：饿汉式,线程安全 但效率比较低 
 * @author Administrator
 *缺点是：当类SingletonTest被加载的时候，
 *会初始化static的instance，静态变量被创建并分配内存空间，
 *从这以后，这个static的instance对象便一直占着这段内存
 *（即便你还没有用到这个实例），当类被卸载时，静态变量被摧毁，
 *并释放所占有的内存，因此在某些特定条件下会耗费内存。
 */
public class singletondemo1 extends warehouse{
	private singletondemo1(int num){
		super(num);
	}
	private static final singletondemo1  instance  = new singletondemo1(10);
	public static singletondemo1 getNewInstance(){
		return instance;
	}
}
