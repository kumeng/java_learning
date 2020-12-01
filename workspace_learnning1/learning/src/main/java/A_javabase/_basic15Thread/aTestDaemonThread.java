package A_javabase._basic15Thread;

/**
 * 测试守护线程 
 * @author Administrator
 * Thread.setDaemon(true) 可以将普通线程设置为守护线程
 * 
 * 守护线程特性，当其他线程结束时后，只有剩下守护线程，守护线程也会结束
 */
public class aTestDaemonThread {
	public static void main (String[] arg0){

		//展示守护进程效果
		new aTestDaemonThread().testDaemonTh();
		//展示非守护进程效果，避免无限循环，设置定时结束后台线程
//		new aTestDaemonThread().testNotDaemonTh();
	}
	
	private void  testDaemonTh(){
		
		//匿名内部类 ，创建一个线程,继承了Thread的 匿名类(匿名内部类也是一种局部内部类)
		Thread  r = new Thread(){

			public void run() {
				// TODO Auto-generated method stub
				try {
					while(true){
						System.out.println("后台线程"+"CurrentThreadName:"+Thread.currentThread().getName()
								+"CurrentThreadId:"+Thread.currentThread().getId());
						Thread.sleep(500);
												
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		};
		
		Long d = System.currentTimeMillis();	
		
		//设置线程为守护线程
		r.setDaemon(true);
		r.start();
		
		try {
			Thread.sleep(5000);
			System.out.println("main 结束"+"CurrentThreadName:"+Thread.currentThread().getName()
					+"CurrentThreadId:"+Thread.currentThread().getId());
			
			
			Long d2 = System.currentTimeMillis();
			System.out.println("耗时(毫秒)："+(d2-d));	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	private void  testNotDaemonTh(){
		
		//匿名内部类 ，创建一个线程,继承了Thread的 匿名类(匿名内部类也是一种局部内部类)
		Thread  r = new Thread(){

			public void run() {
				// TODO Auto-generated method stub
				try {

					Long d = System.currentTimeMillis();
					Long d2 = null;
					
					while(true){
						System.out.println("后台线程"+"CurrentThreadName:"+Thread.currentThread().getName()
								+"CurrentThreadId:"+Thread.currentThread().getId());
						Thread.sleep(500);
											
						d2 = System.currentTimeMillis();
						if((d2-d)>10000){
							//定时10秒 结束
							break;
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		};
		

		
		//设置线程为非守护线程
		r.setDaemon(false);
		r.start();
		
		try {
			Thread.sleep(5000);
			System.out.println("main 结束"+"CurrentThreadName:"+Thread.currentThread().getName()
					+"CurrentThreadId:"+Thread.currentThread().getId());
			
		
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	

		
}
