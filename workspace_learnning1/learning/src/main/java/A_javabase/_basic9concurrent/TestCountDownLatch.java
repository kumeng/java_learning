package A_javabase._basic9concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch使用案例
 * @author Administrator
 *
 */
public class TestCountDownLatch {

	CountDownLatch count = new CountDownLatch(3);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCountDownLatch  t   = new TestCountDownLatch();
		t.some();
	}

	public  void some() {
	    
		count.countDown();
		Thread t1 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count.countDown();
				System.out.println("线程1，执行完毕");
			}
			
		});
		t1.start();
		Thread t2 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				count.countDown();
				System.out.println("线程2，执行完毕");
			}
			
		});
		t2.start();		
		try {
			count.await();
			System.out.println("主任务执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
