package javabase.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class aTestAtomicInteger {

	/**
	 * 测试 AtomicInteger （Integer类） 提供线程安全的原子加减操作 
	 * 
	 *  可以对比aTestThreadVolatile的testVolatiletAddThread()结果 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAtomicIntegerThread();
	}
	
	static void testAtomicIntegerThread(){
		int a = 0;
		while(a<10){
			atomicIntegerThread vt = new atomicIntegerThread();
			Thread t = new Thread(vt);
			t.start();	
			a++;
		}
	}	

}


class atomicIntegerThread implements Runnable{
	
	//初始化一个数值 0
	private static AtomicInteger atInteger = new AtomicInteger(0);
	
	public void run() {
		// TODO Auto-generated method stub		
		for(int j=0;j<1000;j++){
			//相当于i++;
			atInteger.incrementAndGet();
		}
		System.out.println(Thread.currentThread().getName()+" ,"+atInteger.get());
	}
	
}
