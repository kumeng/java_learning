package javabase._1basic;

import java.math.BigDecimal;

import org.junit.Test;
/**
 * java 标识符，关键字，数据类型，变量，运算符，控制语句
 * @author 20171230
 *
 */
public class _basic {
	/**
	 * 标识符
	 */
	/*
	 * 类名，方法名，变量名，常量名，接口名
	 * 由字母、数字、下划线(_)和美元符号($)构成。数字不能开头,大小写敏感,无长度限制
	 */
	
	/**
	 * 关键字
	 */	
	/*
	 * abstract  boolean  break byte case  catch  char
	 * class continue default do double else extends 
	 * false final finally  float for if implements  import
	 * instanceof  int interface  long native new null
	 * package private protected public return short 
	 * static super switch synchronized this throw throws 
	 * transient true try void  volatile while
	 */
	//transient 修饰的变量，不参与序列化 
	
	
	/**
	 * 数据类型
	 */	
	
	/*
	 内存大小单位及换算关系
	1bit 位  即二进制的0或者1  
	1字节 = 8bit
	
	基础类型
	byte = 1字节      2的7次方=128 (-128~127)
	boolean = 1字节  
	short = 2字节	2的15次方=32768(-32768~32767)		
	char = 2字节    			0~65535
	int = 4字节                   正负21亿左右(~2147483647)
	float = 4字节，赋值需要加f,因为浮点数字在java被默认为double	
	long = 8字节
	double = 8字节
	
	引用类型STRING;枚举；数组；类和接口等等，引用地址占,16字节
	 */
	
	//java使用Unicode字符集
	
	//特殊变量，或字符，赋值演示
	@Test
	public void testShowtszf(){
		char n1 = '\n'; //换行符
		char n2 = '\t'; //指标符
		char n3 = '\r'; //回车符
		char n4 = '\"'; //双引号
		char n5 = '\\'; //反斜杆
		// 反斜杠 加 u 加4个16进制数字  指定 Unicode字符对应的字符
		char n6 = '\u00A9'; //版权符号
		char n7 = '\u00BD'; //表示分数½
		System.out.println(n6 + " "+n7);
	}	
	//Integer对象，有个缓存区间IntegerCache[-128~127]，是不会创建新对象的
	@Test
	public void testCacheNumber(){
		Integer a=100,b=100;
		Integer a2=1000,b2=1000;
		int a3 = 1000;
		System.out.println(a==b);
		System.out.println(a2==b2);
		System.out.println(a2.equals(b2));
		System.out.println(a2==a3);
		System.out.println(b2==a3);
	}	
	
	///打印所有的char
	@Test
	public void printchar(){
		for(int i=0;i<140;i++){
			System.out.println(i+" "+(char)i);
		}
	}	
	
	//测试int溢出
	@Test
	public void testOutLimitOfInt(){
		int x = 2147483647;	
		System.out.println(x+1);
	}
	
	/**
	 * 运算符
	 */	
	/*
	 * 算术运算符
	 * 
	 * + 加 - 减  * 乘 
	 *  / 除法，结果只取整，余数舍去
	 *  % 模运算，结果只取余数
	 *  ++ 递增运算
	 *  -- 递减运算
	 */
	//计算次方
	@Test
	public void tesMathpw(){
		double a = 2;
		//计算a的7次方
		System.out.println((long)Math.pow(a, 8-1));
		System.out.println((long)Math.pow(a, 16-1));
		System.out.println((long)Math.pow(a, 32-1));
	} 	
	
	/*
	 * 赋值运算符
	 * = 直接赋值
	 * +=  -=  *= /= %=
	 * i += 6 等于  i = i+6;其他类似
	 */
	/*
	 * 关系运算符
	 * ==  != > <  >=  <=
	 */
	/*
	 * 逻辑运算符
	 * &   逻辑与      两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
	 * |   逻辑或
	 * !   逻辑反
	 * ^   异或        两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
	 * &&  条件与
	 * ||  条件或
	 */
	/*
	 * 位运算符
	 * <<  左移
	 * >>  有移
	 * >>>  无符号右移
	 */

	
	//测试位移符号
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
		
		System.out.println("按位表示数字");
		int a = 0x80;				
		int b = 0xFFFFFFFF;
		int c = 0x0100;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
	
		System.out.println("按位表示数字,对-8做位移进行测试,16进制A~F分别表示10~15");
		a = 0xFFFFFFF8;
		System.out.println(a);
//		int 类型默认是有符号的，最高位 0 表示 正数， 1 表示负数
		// int是4字节，共32位，二进制表示 1111 1111 1111 1111 1111 1111 1111 1000     
        // 右移>> 与 无符号右移>>> 都是向右位移，左边补零, 区别在于>>补符号位，>>>补0
        
		//要理解位移 需要理解  计算机计算原理，原码，反码，补码
        System.out.println(a>>1); //位移后的二进制1111 1111 1111 1111 1111 1111 1111 1100
        System.out.println(a>>>1);//位移后的二进制10000000 00000000 00000000 10000000   
	}	
	
	/**
	 * 控制语句
	 */		
		//略
}
