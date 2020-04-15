package javabase._1basic;

/**
 * java中只有成员变量  和 局部变量  
 * 成员变量是方法之外类的一个属性. 和类实例出的对象一起存储在堆中
 * 
 *成员变量成员变量定义在类中，在整个类中都可以被访问。
 *成员变量随着对象的建立而建立，随着对象的消失而消失，存在于对象所在的堆内存中。
 *成员变量有默认初始化值。
 *
 *局部变量局部变量只定义在局部范围内，如：函数内，语句内等，
 *只在所属的区域有效。
 *局部变量存在于栈内存中，
 *作用的范围结束，
 *变量空间会自动释放。
 *局部变量没有默认初始化值
 * @author jiawen
 *
 *验证栈是线程安全(一个线程对应一个) ,堆是多线程共享的
 */
public class validateStackAndHeap {

	//validateStackAndHeap对象  
	
	int a;
	
	Integer b;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
