package javabase.Thread.volatitle11synchronized;

/**
 * 读取共享变量
 * 模拟多次读取某一个变量
 * @author jiawen
 *
 */
public class readNumberThread7 implements Runnable {

	private  ShareValiryNumber s ;
	
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(s.fl==false){
				printInfo("最终主内存a和c结果");	
				break;
			}
		}
		
	}
	public void printInfo(String str) {
		System.out.println();
		System.out.println(str);
		System.out.println("当前线程"+Thread.currentThread().getName());
		System.out.println("堆中变量 c:"+s.c);
		System.out.println("堆中变量a:"+s.a);
	}
	public readNumberThread7(ShareValiryNumber s1){
		s = s1;
	}

}
