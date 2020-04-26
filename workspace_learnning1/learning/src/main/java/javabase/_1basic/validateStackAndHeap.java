package javabase._1basic;

import javabase.Thread.threadExtends;

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
	
	int a;   //成员变量，跟随对象存储在堆
	
	Integer b;	 
	 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int a1 = 200;   		//局部变量。存储在栈
		Integer b1 = 300;	  //局部变量与方法参数，是线程私有的。 也就是当前主线程私有
		//volatile Integer a2 = 400;  //局部变量不能用volatile修饰，编译出错。volatile是用来保证变量的可见性。
		
		System.out.println("当前线程name="+Thread.currentThread().getName()+",当前线程id="+Thread.currentThread().getId());		
		
		validateStackAndHeap vp = new validateStackAndHeap();  //对象引用名存储在栈，对象存储在堆
		
		vp.printvalirynumber(a1,b1);
		
		System.out.println("主方法内,a1="+a1+",b1="+b1);  //可见不同方法之间使用的栈不同
		
		//那看看不同线程是否可以使用同一个栈
		
		//匿名内部类方式,不能读取当前主线程私有的变量。编译出错
		Thread thread = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				//沉睡2秒,自动醒来
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("匿名内部类线程:,当前线程name="+Thread.currentThread().getName()+",当前线程id="+Thread.currentThread().getId());
//				System.out.println("主方法内,a1="+a1+",b1="+b1);
			}			
		});		
//		thread.start();
		
		System.out.println();	
		System.out.println("其他方法修改前的局部变量,a1="+a1+",b1="+b1);			
		//那尝试把主线程私有变量传递给 新的线程，进行数据操作，看是否可以影响到主线程的变量。
		threadExtends t = new threadExtends(a1,b1);
		System.out.println("其他方法修改后的局部变量,a1="+a1+",b1="+b1);			

		System.out.println("主方法内读取线程体成员变量,a1="+t.getA()+",b1="+t.getB());

		System.out.println("执行子线程，主线程睡眠2秒");
		t.start();
		//主线程沉睡2秒,自动醒来
		Thread.sleep(2000);		
		
		//以及主线程修改变量，是否影响		
		System.out.println("醒来后主方法内读取线程体成员变量,a1="+t.getA()+",b1="+t.getB());
		
//		Integer b2 = vp.b;
//		int a2 = vp.a;
		
		//线程安全问题，主要是多个线程，共享在堆中的数据，出现。
		//使用关键字  synchronized    volatile 解决共享问题		
		


		
	}

	public void printvalirynumber(int a1, Integer b1) {
		// TODO Auto-generated method stub
		System.out.println("当前线程name="+Thread.currentThread().getName()+",当前线程id="+Thread.currentThread().getId());	
		a1--;
		b1--;
		System.out.println("printvalirynumber内,a1="+a1+",b1="+b1);
	}

}
