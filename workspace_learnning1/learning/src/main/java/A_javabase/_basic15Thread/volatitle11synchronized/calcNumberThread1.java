package A_javabase._basic15Thread.volatitle11synchronized;

/**
 * 读取并计算共享变量
 * 两个线程处理同一个变量
 * @author jiawen
 *
 */
public class calcNumberThread1 implements Runnable {

	private  ShareValiryNumber s ;
	
	public void run() {
		// TODO Auto-generated method stub
		
		printInfo("初始读取,");
		for(int i=0;i<50000;i++){
			s.a = s.a +1;
			s.setB(s.getB()+1);
		}
		printInfo("计算完毕,");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo("沉睡三秒再读,");
	}
	public void printInfo(String str) {
		System.out.println();
		System.out.println(str);
		System.out.println("当前线程"+Thread.currentThread().getName());
		System.out.println("堆中变量 a:"+s.a);
		System.out.println("堆中变量b"+s.getB());
	}
	public calcNumberThread1(ShareValiryNumber s1){
		s = s1;
	}

}
