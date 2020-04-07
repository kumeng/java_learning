package javabase.singletonAndSynchronized;
/**
 *  * 在线程中使用单利模式二
 * @author Administrator
 *
 */
public class threadImpelments_demo2 implements Runnable {
	
	public  void run() {
		// TODO Auto-generated method stub
		singletondemo2 singled = singletondemo2.getNewInstance();	
		System.out.println("currentThread:"+Thread.currentThread().getName()+"\n"+singled);
	}

}
