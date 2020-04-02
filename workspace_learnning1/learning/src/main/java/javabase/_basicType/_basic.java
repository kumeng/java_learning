package javabase._basicType;

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
	public void tesMathpw(){
		double a = 2;
		System.out.println((long)Math.pow(a, 8-1));
		System.out.println((long)Math.pow(a, 16-1));
		System.out.println((long)Math.pow(a, 32-1));
	} 
	@Test
	public void test1(){
		$3 -= 32760;
		System.out.println($3);
		$3 += 3;
		System.out.println($3);
		$3 *= 3;
		System.out.println($3);
		$3 /= 4;
		System.out.println($3);
		$3 %= 3;
		System.out.println($3);		
		
		System.out.println(8/3);
	}	
	@Test
	public void test2(){
		System.out.println($4);
		System.out.println($4+1);
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
	@Test
	public void testweiyifu(){
		System.out.println(4<<1);
		System.out.println(4<<2);
		System.out.println(4>>1);
		System.out.println(4>>2);
		System.out.println();
		System.out.println(5<<0);
		System.out.println(5<<1);
		System.out.println(5<<2);
		System.out.println(5>>1);
		System.out.println(5>>2);		
	}
	@Test
	public void testAND(){
		if(true&&false){
			System.out.println("1");
		}else{
			System.out.println("2");
		}
	}
	@Test
	public void testMoudel(){
		System.out.println(1%600);
		System.out.println(0%600);
		System.out.println(600%600);
		System.out.println(601%600);		
	}
	@Test
	public void printchar(){
		for(int i=0;i<140;i++){
			System.out.println(i+" "+(char)i);
		}
	}
	@Test
	public void printRondom(){
		int i=0;
		while(i<100){
//			double random = Math.random();
//			System.out.println(random*54);
//			System.out.println((int)(random*54));
			int indexspilt =  (int)(Math.random()*3);
			System.out.println(indexspilt);
			i++;
		}

	}
}
