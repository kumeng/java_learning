package javabase.ExtendsAndClassLoad;

import org.junit.Test;

public class TestClassLoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(FatherClass.class);
//		FatherClass FatherClass2 = new SubClass(6,"ds6","blue");
//		System.out.println(FatherClass2.toString());
		FatherClass subClass1 = new SubClass(5,"ds","red");
		System.out.println(subClass1.toString());
			
	}
	@Test
	public void ste(){
		FatherClass subClass1 = new SubClass(5,"ds","red");
		System.out.println(subClass1.toString());	
		SubClass subClass2 = new SubClass(6,"ds6","red6");
		System.out.println(subClass2.toString());			
	}
	
	@Test
	public void testNUllException(){
		Object a = null;
		System.out.println(String.valueOf(a));
	}
	@Test
	public void testNUllException2(){
		StringBuffer  sr  = new StringBuffer();
		System.out.println(sr.toString().equals(""));
	}	
}


