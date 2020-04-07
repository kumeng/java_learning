package javabase.Thread;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StringUtils;

/**
 * 线程同步场景:
 * 设计4个线程操作变量j，2个线程都对j做增加1操作，另外2个线程都对j做减1操作
 * @author Administrator
 *
 */
public class aTestThreadSynchronComputer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AtomicInteger  atomici  = new AtomicInteger(0);
		reosurce  r = new reosurce();
		tdsfdthread  ad = new tdsfdthread(r,1);
		tdsfdthread  de = new tdsfdthread(r,2);

		Thread ad1 = new Thread(ad,"加法线程1");
		Thread ad2 = new Thread(ad,"加法线程2");
		Thread de1 = new Thread(de,"减法线程1");
		Thread de2 = new Thread(de,"减法线程2");
		ad1.start();
		ad2.start();
		de1.start();
		de2.start();
		
//		System.out.println("最终结果:"+atomici.get());
		
	}
	
}


class tdsfdthread implements Runnable {
	private reosurce sour;
	//1 +  2 -
	private int comtype;
	public tdsfdthread(reosurce sour2,int comtype2){
		sour = sour2;
		comtype = comtype2;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<30;i++){
			synchronized(sour){
				switch(comtype){
				case 1:
					sour.setJ(sour.getJ()+1);
					break;
				case 2:
					sour.setJ(sour.getJ()-1);
					break;						
				}
				System.out.println(Thread.currentThread().getName()+" "+sour.getJ() );
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}


class reosurce{
	private Integer j=0;

	public Integer getJ() {
		return j;
	}

	public void setJ(Integer j) {
		this.j = j;
	}
	
}

