package javabase.Thread;

/**
 * 测试synchronizedTicket 关键字,卖票业务
 * @author Administrator
 *
 */
public class aTestsSynchronizedTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
		test2();
	}

	/**
	 * 锁加在 实例对象上
	 */
	private static void test1() {
		synchronizedTicket  ynchronizedTicket = new synchronizedTicket();
		salestick  s1 = new salestick();
		s1.setYnchronizedTicket(ynchronizedTicket);
		salestick  s2 = new salestick();
		s2.setYnchronizedTicket(ynchronizedTicket);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		t1.start();
		t2.start();
	}

	/**
	 * 锁加在 字节码文件上
	 */	
	private static void test2() {
		synchronizedTicket  ynchronizedTicket = new synchronizedTicket();
		salestick2  s1 = new salestick2();
		s1.setYnchronizedTicket(ynchronizedTicket);
		salestick2  s2 = new salestick2();
		s2.setYnchronizedTicket(ynchronizedTicket);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		t1.start();
		t2.start();
	}	

}
