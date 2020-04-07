package javabase.Thread;

/**
 * Synchronized 关键字
 * 锁定的是一个实例对象，多个线程访问这个实例对象才会互斥 
 * @author Administrator
 *
 */
public class synchronizedTicket {
	private Integer ticket=100;
	
	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}
		
	public  void saleTicket(int i){
		
		int j = this.getTicket()-i;
		if(j>=0){
			this.setTicket(j);
			System.out.println(" 票数："+i+"，余票:"+j+" ,线程name:"+Thread.currentThread().getName());
		}else{
			System.out.println(" 余票不足，交易取消");
			System.exit(0);
		}
		
	}	
	
}

class salestick implements  Runnable {

	private synchronizedTicket  ynchronizedTicket ;
	
	public void run() {
		// TODO Auto-generated method stub	
		while(ynchronizedTicket.getTicket()>0){
			
			//锁住的是 ynchronizedTicket这个实例对象,
//			也可以在类synchronizedTicket的方法saleTicket上加锁，锁住的是调用这个方法的对象(this)
			synchronized(ynchronizedTicket){
				ynchronizedTicket.saleTicket(3);
			}		
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public synchronizedTicket getYnchronizedTicket() {
		return ynchronizedTicket;
	}

	public void setYnchronizedTicket(synchronizedTicket ynchronizedTicket) {
		this.ynchronizedTicket = ynchronizedTicket;
	}
}

class salestick2 implements  Runnable {

	private synchronizedTicket  ynchronizedTicket ;
	
	public void run() {
		// TODO Auto-generated method stub	
		while(ynchronizedTicket.getTicket()>0){

			//锁加在 字节码文件上
			synchronized(synchronizedTicket.class){
				ynchronizedTicket.saleTicket(3);
			}		
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public synchronizedTicket getYnchronizedTicket() {
		return ynchronizedTicket;
	}

	public void setYnchronizedTicket(synchronizedTicket ynchronizedTicket) {
		this.ynchronizedTicket = ynchronizedTicket;
	}
}

