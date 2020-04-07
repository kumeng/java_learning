package javabase.Thread;

public class aTestThreadVolatile {
	
	/**
	 * 测试volatile变量的作用
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//定义在线程之间的变量，不被其他线程访问和修改。
		//证明线程之间变量不可见，主线程修改novolatileThread的变量之后，子线程依旧在执行
		//注意变量定义在线程代码中
//		testNovolatileThread();			
		
		//证明方法区和堆中的变量对线程是共享的
		testNovolatileThread2();
		
		
		//验证volatile变量的非原子性
//		testVolatiletAddThread();
				
		
	}
	
	
	static void testNovolatileThread(){
		novolatileThread  nov = new novolatileThread();
		Thread thread1 = new Thread(nov,"novolatileThread");
		thread1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"写入结束标志");
		nov.setFal(false);		
	}
	
	
	static void testNovolatileThread2(){
		
		flags  fal = new flags();
		novolatileThread2  nov = new novolatileThread2();
		nov.setFal(fal);
		Thread thread1 = new Thread(nov,"novolatileThread2_1");
		Thread thread2 = new Thread(nov,"novolatileThread2_2");
		Thread thread3 = new Thread(nov,"novolatileThread2_3");
		thread1.start();		
		thread2.start();
		thread3.start();
	}

	
	static void testVolatiletAddThread(){
		int a = 0;
		while(a<10){
			volatiletAddThread vt = new volatiletAddThread();
			Thread t = new Thread(vt);
			t.start();	
			a++;
		}
	}

}





class novolatileThread implements Runnable{
	
//	volatile private boolean fal = true;
	private boolean fal = true;	

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"线程开始执行..");
		while(fal){
			ThreadUtils.dosleep(1);
		}
		System.out.println(Thread.currentThread().getName()+"线程结束..");
	}
	public void setFal(boolean fl){
		fal = fl;
	}
	public boolean setangetFal(boolean fl){
		fal = fl;
		return fal;
	}	
}

class volatiletAddThread implements Runnable{
	
	static volatile private int i = 0;
	
	public void run() {
		// TODO Auto-generated method stub		
		for(int j=0;j<1000;j++){
			i++;
		}
		System.out.println(Thread.currentThread().getName()+" ,"+i);
	}
	
}


class flags{
	private static boolean f1 = true;
	private boolean f2 = true;
	
	public static boolean isF1() {
		return f1;
	}
	public static void setF1(boolean f1) {
		flags.f1 = f1;
	}
	public boolean isF2() {
		return f2;
	}
	public void setF2(boolean f2) {
		this.f2 = f2;
	}
	
	
}


class novolatileThread2 implements Runnable{
	
	private flags fal ;
	int i=0;
	int j=0;

	public void run() {
		// TODO Auto-generated method stub
		StringBuilder sr = new StringBuilder();		
		sr.append(Thread.currentThread().getName()+"线程开始执行..");
		sr.append("\n");
		while(flags.isF1()){
			i++;
			if(i==3000000){
				flags.setF1(false);
			}
		}		
		sr.append(Thread.currentThread().getName()+"flags.f1已修改为"+flags.isF1()+" 循环指数"+i);
		sr.append("\n");
		while(fal.isF2()){
			j++;
			if(j==3000000){
				fal.setF2(false);
			}			
		}
		sr.append(Thread.currentThread().getName()+"flags.f2已修改为"+fal.isF2()+" 循环指数"+j);
		sr.append("\n");
		sr.append(Thread.currentThread().getName()+"线程结束..");
		sr.append("\n");
		
		System.out.println(sr.toString());
	}

	public flags getFal() {
		return fal;
	}

	public void setFal(flags fal) {
		this.fal = fal;
	}	
	
	
	
}


class ThreadUtils{
	public static void dosleep(int seconds) {
		if(seconds<=0){
			return;
		}
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}


