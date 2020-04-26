package javabase.Thread.volatitle11synchronized;

/**
 * 堆中的共享变量
 */

public class ShareValiryNumber {
	//线程读写该变量时，会使用工作内存副本，
	public Integer a = 500;	
	private int b = 500;     
	//int 和  Integer  只要是成员变量，就是存储在堆中的，可多线程访问，没有措施，线程不安全。 int效率比Integer更高些
	
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	//设置线程读写该变量时 都从主内存读取,不使用工作内存副本, 不能保证线程安全
	public volatile Integer c = 500;
	
//	public volatile  boolean fl = true;
	public   boolean fl = true;
}
