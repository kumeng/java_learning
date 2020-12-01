package A_javabase._basic15Thread;


import org.junit.Test;

public class aTest {

	/**
	 * @param args
	 */
	
	//线程三种创建方式
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//implements Runnable 实现Runnable接口方式,实现run方法
		threadImpelments tt = new threadImpelments();
		//实例化一个线程对象
		new Thread(tt).start();
		//实例化一个线程对象,指定名称myThread
		new Thread(tt,"myThread").start();
		
		//extends Thread  继承Thread方式,重写run方法
		new threadExtends().start();
		

			//匿名内部类方式
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
				}			
			});		
			thread.start();
		
	}
	
	/**
	 * //run方法并不是一定可以运行当前线程，而只是比start方法多一个步骤，结束当前线程cpu占用	
	 * //start方法 是等待获取cpu资源，获取后运行。如果cpu空闲，那就是立刻运行
	 * @author Administrator
	 *
	 */	
	@Test
	public void test2(){
		threadImpelmentsPrintName  tpn2 = new threadImpelmentsPrintName();
		tpn2.setCounts(10);
		Thread t2 = new Thread(tpn2,"t2");

		threadImpelmentsPrintName  tpn3 = new threadImpelmentsPrintName();
		tpn3.setCounts(10);	
		Thread t3 = new Thread(tpn3,"t3");
		
		t2.start();
		t3.start();
		t3.run();

	}

}
