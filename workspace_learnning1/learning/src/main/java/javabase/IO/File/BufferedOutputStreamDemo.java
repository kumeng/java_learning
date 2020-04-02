package javabase.IO.File;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流
 * BufferedOutputStream  缓冲输出流 向硬件设备写出操作时，增大写出操作会降低写出效率,使用此类流 先将数据写入缓冲区
			，缓冲区的数据会在流关闭前或者存满时或Flush(）方法之前，一次性写出。另外，Flush(）方法会清空缓冲区
 * @author Administrator
 *
 */
public class BufferedOutputStreamDemo {
	 java.io.File   file = new java.io.File (java.io.File.separator+"home"
				+java.io.File.separator+"logs"+java.io.File.separator+"copydemp.txt");	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				new BufferedOutputStreamDemo().bos();
	}
	public void bos(){
		//先利用缓冲输入流 读取 文件，文件已在输入流demo定义
		BufferedInputStreamDemo  demoInput = new BufferedInputStreamDemo();
		
		byte[] readtobyte = demoInput.readtobyte();
		BufferedOutputStream  bos = null;	
		try {
			FileOutputStream  outs = new FileOutputStream(file);
			bos = new BufferedOutputStream(outs);
			for(int i=0;i<readtobyte.length;i++){
				bos.write(readtobyte[i]);
				if(i==(readtobyte.length/2)){
					System.out.println("清空缓冲区");
					bos.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
