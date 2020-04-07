package javabase.Thread;


/**
 * 利用wait() notify() 实现线程通信，模拟生产消费模型
 * @author Administrator
 * 
 * 如果对象调用了wait方法就会使持有该对象的线程把该对象的控制权交出去，然后处于等待状态(个人认为是阻塞状态,等待某个触发条件)。
如果对象调用了notify方法就会通知某个正在等待这个对象的控制权的线程可以继续运行。
如果对象调用了notifyAll方法就会通知所有等待这个对象控制权的线程继续运行

 *
 */
public class aTestThreadProvider_Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource resou = new Resource();	
		
		//生产者
		threadPro pro = new threadPro(resou);
		//消费者
		threadSm sme = new threadSm(resou);
		
		Thread t_pro = new Thread(pro,"生产者");
		Thread t_sme = new Thread(sme,"消费者");
		t_pro.start();
		t_sme.start();
	}

}

//消费者
 class  threadSm implements Runnable {
	 private Resource resource;
	 //资源 
	
	 public threadSm(Resource resource){
		 this.resource = resource;
	 }
	
	public void run() {
		for(int x=0;x<3;x++){
			synchronized(resource){
				System.out.println();
				System.out.println("当前线程:"+Thread.currentThread().getName()+" 当前资源："+resource.getResource());
				if(resource.getResource()<=0){				
					try {
						System.out.println("没有资源，消费者等待...");
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					System.out.println("消费资源，唤醒生产线程：");
					resource.setResource(-1);
					//资源消耗，唤醒生产线程
					resource.notify();
				}			
			}			
		}

	
	}
	
 }
 
 //生产者
 class threadPro implements Runnable {
	 private Resource resource;
	 //资源 
	
	 public threadPro(Resource resource){
		 this.resource = resource;
	 }
	
	public void run() {
		for(int x=0;x<2;x++){
			synchronized(resource){
				System.out.println();
				System.out.println("当前线程:"+Thread.currentThread().getName()+" 当前资源："+resource.getResource());
				if(resource.getResource()>0){
					try {
						System.out.println("有资源，生产者等待...");
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					resource.setResource(6);
					System.out.println("生产资源，唤醒消费线程：");
					//资源生产完毕，唤醒消费线程
					resource.notify();
				}			
			}			
		}


	}
	
 } 
 
	class Resource{
		static private int resource=-1;

		public Resource(){
			
		}
		
		public   int getResource() {
			return resource;
		}		
		public  void setResource(int resource) {
			Resource.resource = resource;					
		}
		
	}
