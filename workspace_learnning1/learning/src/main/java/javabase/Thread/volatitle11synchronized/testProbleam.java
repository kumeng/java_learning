package javabase.Thread.volatitle11synchronized;

import org.junit.Test;

public class testProbleam {

	/**
	 * 多个读写线程一起
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先获取一块变量
		ShareValiryNumber s = new ShareValiryNumber();
		//两个线程处理同一个变量
		calcNumberThread1 c1 = new calcNumberThread1(s);
		Thread t1  = new Thread(c1);
		Thread t2  = new Thread(c1);
		t1.start();
		t2.start();
		
		//每一次运算 + - 等等,都会涉及到工种内存，主内存的读写操作。
		//线程当中每次运算结果，肯定不是一直是用主内存的值，或者说没有及时写入主内存			
		
	}
	@Test
	public void test(){
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
	}	

}
