package A_javabase._basic15Thread;

/**
 * 研究多线程 在没有任何同步关键字情况下  读写变量，
 * 以及ThreadLoacl 为每一个线程，创建一个私有的变量副本
 * @author Administrator
 *
 *变量定义在资源对象中，
 *多个线程访问这
 */
public class aTestThreadLoacl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		res re = new res();
		printNumThread prith = new printNumThread(re);
		
		Thread t1 = new Thread(prith,"T1");
		Thread t2 = new Thread(prith,"T2");
		Thread t3 = new Thread(prith,"T3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class res{
	//对象的全局变量，跟随实例对象，存储在堆(实例对象、数组)
	private int a=0;
	//静态变量，跟随class文件存储在方法区
	private static int b=0;
	//ThreadLocal线程变量
	private ThreadLocal<Integer> c = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 0;
		}
	};
	
	public int geta(){
		a = a+1;
		return a;
	}
	public int getb(){
		b = b+1;
		return b;
	}	
	
	public Integer getc(){
		c.set(c.get()+1);
		return c.get();
	}
}

class printNumThread implements Runnable{
	
	private res re;
	public printNumThread(res re2){
		re = re2;
	}

	public void run() {
		// TODO Auto-generated method stub
		StringBuilder sr = new StringBuilder();
		
		sr.append(Thread.currentThread().getName());		
		sr.append(",实例全局变量:");
		for(int i=0;i<3;i++){
			sr.append(re.geta()+",");			
		}		
		sr.append(" 静态变量:");
		for(int i=0;i<3;i++){
			sr.append(re.getb()+",");			
		}		
		sr.append(" ThreadLocal线程变量:");
		for(int i=0;i<3;i++){
			sr.append(re.getc()+",");			
		}
		System.out.println(sr.toString());		
	}
	
}
