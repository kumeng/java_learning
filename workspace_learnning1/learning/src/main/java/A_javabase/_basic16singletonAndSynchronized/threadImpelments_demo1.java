package A_javabase._basic16singletonAndSynchronized;
/**
 * 在线程中使用单利模式一
 * @author Administrator
 *
 */
public class threadImpelments_demo1 implements Runnable  {
	
	public  void run() {
		// TODO Auto-generated method stub
		singletondemo1 singled = singletondemo1.getNewInstance();
		System.out.println(singled);
		System.out.println("currentThread:"+Thread.currentThread().getName());
	}

}
