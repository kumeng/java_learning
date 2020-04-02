package javabase._basicType;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.sun.mail.iap.ByteArray;

import javabase.beans.dog;
import utils.Coder;
import utils.CopyObject4;

public class StringUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ids = "32432,32431,50000";
		int lastIndexOf = ids.lastIndexOf(",");
		String ysid = ids.substring(lastIndexOf+1);
		ids = ids.substring(0, lastIndexOf);
		
		System.out.println(ysid);
		System.out.println(ids);
		
	}
	
	/**
	 * 默认的String 与  Byte[] 互转是存在问题的 ：
	 * 即 一个 Byte[] 数组转换为 一个   str 后， str.getbytes()返回的 字节组，与 原先的数组不同
	 * 
	 * 可用base64编码解决
	 */
	@Test
	public void StringAndBytes(){
		dog d = new dog("bl","hashiq",5);
		try {
			byte[] objectToBytes = CopyObject4.ObjectToBytes(d);
			System.out.println("转换前：字节长度  "+objectToBytes.length+ "第一个字节 "+objectToBytes[0]);
			String str = new String(objectToBytes);
			System.out.println("默认构建的字符串长度："+str.length());
//			System.out.println("默认构建的字符串："+str);
			byte[] bytes = str.getBytes();
			System.out.println("默认构建的字符串通过str.getBytes()获取字节组：字节长度  "+bytes.length+ "第一个字节 "+bytes[0]);
			
			str = Coder.encryptBASE64(objectToBytes);
			System.out.println("Base64构建的字符串长度："+str.length());
//			System.out.println("Base64构建的字符串："+str);	
			byte[] decryptBASE64 = Coder.decryptBASE64(str);
			System.out.println("Base64构建的字符串解码得到的字节组：字节长度  "+decryptBASE64.length+ "第一个字节 "+decryptBASE64[0]);
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void DefaultStrFormat(){
		// 16.05格式化 为字符串
		System.out.println("格式化 为字符串: "+String.format("{%s}", 16.05));
		//16 格式化 为整数
		System.out.println("格式化 为整数: "+String.format("%d", 16));
		//16 格式化为 16进制
		System.out.println("格式化 为16进制: "+String.format("%x", 16));
		//16 格式化为8进制
		System.out.println("格式化 为8进制: "+String.format("%o", 16));
		//布尔类型
		System.out.println("格式化 为布尔类型: "+String.format("%b", true));
		//浮点型
		System.out.println("格式化 为浮点型: "+String.format("%f", 16.05));
		//换行符
		System.out.println("格式化 为换行符: "+String.format("%s %n %s", 16,17));
		//百分比
		System.out.println("格式化 为百分比: "+String.format("%%", 16));
		//正数表示
		System.out.println("格式化 为正数表示: "+String.format("%+d", 16));
		//数字前 补0
		System.out.println("格式化 为数字前 补0,%04d: "+String.format("%04d", 16));
		//补空格
		System.out.println("格式化 为补空格: "+String.format("% 4d", 16));
		//千分符 ，显示金额用
		System.out.println("格式化 为千分符 ，显示金额用: "+String.format("%,f", 100000.05));
		//负数 变括号
		System.out.println("格式化 为负数 变括号: "+String.format("%(f", -16.05));
		
		//格式化日期
		Date d1 = new Date();
		System.out.println("格式化 为字符串"+String.format("%tc", d1));
		System.out.println("格式化 为字符串"+String.format("%tF", d1));
		System.out.println("格式化 为字符串"+String.format("%tD", d1));
		System.out.println("格式化 为字符串"+String.format("%tr", d1));
		System.out.println("格式化 为字符串"+String.format("%tT", d1));
		System.out.println("格式化 为字符串"+String.format("%tR", d1));
		
	}	
	

}
