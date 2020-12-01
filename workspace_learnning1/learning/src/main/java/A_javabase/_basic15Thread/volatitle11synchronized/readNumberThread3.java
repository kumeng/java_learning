package A_javabase._basic15Thread.volatitle11synchronized;

/**
 * 读取共享变量
 * 模拟多次读取某一个变量
 * @author jiawen
 *
 */
public class readNumberThread3 implements Runnable {

	private  ShareValiryNumber s ;
	
	public void run() {
		// TODO Auto-generated method stub
		int i = 500;
		while(s.fl){
			i++;
			s.a = i;
		}
		System.out.println("a实际应该为"+i);		
	}
	public readNumberThread3(ShareValiryNumber s1){
		s = s1;
	}

}
