package A_javabase._basic16singletonAndSynchronized;

import org.junit.Test;

/**
 * 测试单利模式的线程安全问题
 * @author Administrator
 * 测试线程synchronized关键字对线程的作用
 */

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void testdemo1(){
		threadImpelments_demo1 demo1 = new threadImpelments_demo1();

		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();		
	}
	@Test
	public void testdemo2(){
		threadImpelments_demo2 demo2 = new threadImpelments_demo2();

		int i=0;
		while(i<100){
			new Thread(demo2).start();
			i++;
		}
		

	}
	@Test
	public void testdemo4(){
		threadImpelments_demo4 demo4 = new threadImpelments_demo4();

		new Thread(demo4).start();
		new Thread(demo4).start();
		new Thread(demo4).start();
		new Thread(demo4).start();		
		new Thread(demo4).start();
		new Thread(demo4).start();		
	}	
	@Test
	public void testString(){		
		String a = "q"; 
		String b = a;
		//一共产生了"q",a,b三个对象
		a = "w";
		String c = new String(a);
		System.out.println(c.equals(a));
		// 这里产生了 第四个对象“w” 并将a的引用指向该对象。
	}
	@Test
	public void test_synchronized_warehouse(){
		threadImpelments_warehouse demowarehouse = new threadImpelments_warehouse();
		threadImpelments_warehouse demowarehouse_ = new threadImpelments_warehouse();

		new Thread(demowarehouse).start();
		new Thread(demowarehouse).start();
		new Thread(demowarehouse_).start();
	}
}
