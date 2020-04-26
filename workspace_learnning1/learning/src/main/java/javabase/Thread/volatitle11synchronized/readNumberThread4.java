package javabase.Thread.volatitle11synchronized;

/**
 * 读取共享变量
 * 模拟多次读取某一个变量
 * @author jiawen
 *
 */
public class readNumberThread4 implements Runnable {

	private  ShareValiryNumber s ;
	
	public void run() {
		// TODO Auto-generated method stub
		int i = 500;
		while(s.fl){
			i++;
			s.c = i;
		}
		System.out.println("c实际应该为"+i);		
	}
	public readNumberThread4(ShareValiryNumber s1){
		s = s1;
	}

}
