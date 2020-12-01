package A_javabase._basic15Thread.volatitle11synchronized;

import org.junit.Test;

/**
 * s.fl  不用 volatile修饰时，某些情况下线程一直使用工作副本的值
 * 而使用volatile修饰时,线程只从主内存读写值，但不能保存多线程的写的原子性。
 * 所以只适合，一个写，其他要求及时性高的读线程的场景
 * @author jiawen
 *
 */
public class testProbleam2 {

	/**
	 * v
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先获取一块变量
		ShareValiryNumber s = new ShareValiryNumber();
		//控制线程
		writeboolenNumberThread w1 = new writeboolenNumberThread(s);
		Thread t3  = new Thread(w1);
		//一个读写线程
		readNumberThread3 c1 = new readNumberThread3(s);
		Thread t1  = new Thread(c1);
		readNumberThread4 c2 = new readNumberThread4(s);
		Thread t4  = new Thread(c2);
		//只读线程
		readNumberThread7 r1 = new readNumberThread7(s);		
		Thread t2  = new Thread(r1);
		
		t3.start();
		t2.start();				
		t1.start();	
		t4.start();
	}
	
	@Test
	public void test(){
		int fl = 0;
		do{
			if(fl==5){
				fl  = 12;
			}
			System.out.println("执行查询"+fl);
			if(fl<11){		
				try {
					Thread.sleep(3000);
					fl++;
					System.out.println("沉睡了"+fl*3+"秒");
					if(fl>10){
						System.out.println("异常结束");	
						fl=-1;
					}	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}	
			fl =-1;			
		}while(fl>=0);		
		System.out.println(fl);
	}

}
