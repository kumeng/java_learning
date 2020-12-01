package A_javabase._basic15Thread;

/**
 * 使用t1.join()让 其他线程 等待线程t1执行完成
 * @author Administrator
 *
 */
public class aTestThreadJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddressBean bean = new AddressBean();
		
		Thread down = new  Thread(new downloadPicThread(bean));
		down.start();
		Thread display = new  Thread(new displayPicThread(bean,down));
			
		display.start();
		
	}

}

//模拟显示图片线程
class displayPicThread implements  Runnable{
	private AddressBean Address;
	private Thread downThread;
	
	public displayPicThread(AddressBean Address,Thread downThread){
		this.Address = Address;
		this.downThread = downThread;
	}	
	
	public void run() {
		
//		System.out.println("这里是展示图片线程，地址时:"+this.getAddress().getPicpath());
		
		try {
			downThread.join();
			System.out.println("这里是展示图片线程，地址时:"+this.getAddress().getPicpath());
		} 
		catch (InterruptedException e) {			
			e.printStackTrace();
		}
	
	}

	public AddressBean getAddress() {
		return Address;
	}

	public void setAddress(AddressBean address) {
		Address = address;
	}

	public Thread getDownThread() {
		return downThread;
	}

	public void setDownThread(Thread downThread) {
		this.downThread = downThread;
	}

}

//模拟加载图片线程
class downloadPicThread implements  Runnable{
	private AddressBean Address;
	
	public downloadPicThread(AddressBean Address){
		this.Address = Address;
	}
	
	public void run() {
		try {
			int i=1;
			while(i<11){
				System.out.println("这里是加载图片线程，图片已加载"+10*i+"%");
				Thread.sleep(300);
				i++;
			}			
			this.getAddress().setPicpath("图片地址shi:dsfsfsf");
			System.out.println("图片已放置到:"+this.getAddress().getPicpath());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public AddressBean getAddress() {
		return Address;
	}

	public void setAddress(AddressBean address) {
		Address = address;
	}	
}

class AddressBean{
	String picpath;

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
}
