
package javabase.jvm.jvm001;

import java.text.DecimalFormat;

public class Demo004 {
	private static int count = 0;

	public static void count() {
		try {
			if(count==5000){
				// 当前空闲内存
				long freeMemory = Runtime.getRuntime().freeMemory();
				System.out.println("freeMemory:" + freeMemory + ",转换成" + toM(freeMemory) + "M");					
			}
	         count++;
			count();
		} catch (Throwable  e) {		
			System.out.println("最大深度i:"+count);
			e.printStackTrace();
		}
	}
	public static String toM(long maxMemory) {
		float num = maxMemory / (1024 * 1024);
		DecimalFormat dlf = new DecimalFormat("0.00");
		String result = dlf.format(num);
		return result;
	}	

	public static void main(String[] args) {
//		for (int i = 0; i <10793; i++) {
			count();
//		}
	}

}
