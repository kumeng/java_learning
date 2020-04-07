package javabase.ExtendsAndClassLoad;

import java.math.BigDecimal;

import org.junit.Test;

public class _basic {
	//1bit  即二进制的0或者1
	//1字节 = 8bit

	static byte _byte1 = 127;	
	static boolean $2 = false;
	static short $3  = 32767;
	static int   $4  = 2147483647;
	static long  $5 = 2342343;
	static float $6 =  (float) -343.23434;
	static double $7 = -343.23434;
	static char $8 = 'q';
	//0-65535
	static char $9 = 65535;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _basic().testCacheNumber();
	}
	@Test
	public void test1(){
		$3 -= 32760;
		System.out.println($3);
		$3 += 3;
		System.out.println($3);
		$3 *= 3;
		System.out.println($3);
		$3 /= 3;
		System.out.println($3);
		$3 %= 3;
		System.out.println($3);		
	}	
	@Test
	public void testdoube7(){
		System.out.println($7);
		System.out.println(new BigDecimal($7));
		System.out.println(new BigDecimal(String.valueOf($7)));
	}
	
	@Test
	public void testCacheNumber(){
		Integer a=100,b=100;
		Integer a2=1000,b2=1000;
		System.out.println(a==b);
		System.out.println(a2==b2);
	}
	@Test
	public void testCacheNumber2(){
		int a=100,b=100;
		int a2=1000,b2=1000;
		System.out.println(a==b);
		System.out.println(a2==b2);
	}	
}
