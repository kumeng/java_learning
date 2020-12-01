package A_javabase._basic15Thread.volatitle11synchronized;

/**
 * 读取共享变量
 * 模拟多次读取某一个变量
 * @author jiawen
 *
 */
public class writeboolenNumberThread implements Runnable {

	private  ShareValiryNumber s ;
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			s.fl = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public writeboolenNumberThread(ShareValiryNumber s1){
		s = s1;
	}

}
