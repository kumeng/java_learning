package A_javabase._basic10IO.File;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile  可读，可写，读写都是基于指针位置开始
 * getFilePointer（） 读取指针位置
 * seek(0)  移动指针位置    ,（0表示移动到开始位置，第一个字节位置）
 * skipBytes(int n)  跳过n个字节，建议少量字节。返回int 跳过的字节，-1不跳过
 * 
 * @author Administrator
 *
 */

public class RandomAccessFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		long dataPosition = 0;
		int data = 12345;
		long data2 = (long)data;
		
		String sr = "234324个地方官";
		

		RandomAccessFile raf = new RandomAccessFile("c:\\data3.txt","rwd");

		
		raf.write(sr.getBytes());
				
		
//		raf.writeLong(0);

//		raf.writeChars("电饭锅23");
		
		

//		raf.writeUTF("地方12345");
		
//		raf.writeLong(data2);	
	
		//当前指针位置， 
		dataPosition = raf.getFilePointer();
		
		System.out.println("当前指针位置:"+dataPosition);

//		raf.writeUTF("elphong");

//		raf.seek(0);
//		raf.writeLong(dataPosition);
		raf.seek(0);
		int rednum = raf.readInt();
		System.out.println("第一个字节："+rednum);
		raf.close();
	}

}
