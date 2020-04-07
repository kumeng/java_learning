package javabase._basicYufa;

import java.util.Date;

import org.junit.Test;

/**
 * 局部变量
 * @author jiawen
 *
 */
public class localValiable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		localValiable l = new localValiable();
		l.parentmethod();
		l.parentmethod2();
	}
	private void parentmethod(){
		int  a = 1;
		Integer b = 1;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		for(int i=0;i<5;i++){
			a=submenthod1(a);
			b=submenthod2(b);			
		}
		System.out.println("a:"+a);
		System.out.println("b:"+b);	
	}
	private void parentmethod2(){
		int  a = 1;
		Integer b = 1;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		for(int i=0;i<5;i++){
			submenthod3(a);
			submenthod4(b);			
		}
		System.out.println("a:"+a);
		System.out.println("b:"+b);	
	}	
	private int submenthod1(int a) {
		// TODO Auto-generated method stub
		a++;
		return a;
	}
	private Integer submenthod2(Integer b) {
		// TODO Auto-generated method stub
		b++;
		return b;
	}
	private void submenthod3(int a2) {
		// TODO Auto-generated method stub
		a2++;
	}
	private void submenthod4(Integer b2) {
		// TODO Auto-generated method stub
		b2++;
	}
	@Test
	public void tebetweenDate(){
		Date d1  = new Date();
		Long mi = System.currentTimeMillis();
		System.out.println(mi-d1.getTime());
	}
}
