package A_javabase._basic9concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier案例
 * @author Administrator
 *
 */
public class TestCyclicBarrier {
	
	static int i=5;
	static CyclicBarrier  cy = new CyclicBarrier(i);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//通过i+或- 来控制执行cy.await();的次数，查看效果
//		for(int j=0;j<i;j++){
		for(int j=0;j<i-1;j++){
		
			new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(2000);
						System.out.println(Thread.currentThread().getName()+"执行前");
						cy.await();
						System.out.println(Thread.currentThread().getName()+"执行后");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
		}
		
		System.out.println("主任务结束");
	}	

}

