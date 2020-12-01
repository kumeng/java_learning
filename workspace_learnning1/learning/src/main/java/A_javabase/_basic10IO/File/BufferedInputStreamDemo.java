package A_javabase._basic10IO.File;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 缓冲输入流
 * 缓冲输入流,尽可能多的一次读取若干字节到缓冲区，然后逐一字节返回，全部返回后继续重复此过程，直到读取完毕
             这样可以减少读取次数，提高效率
 * @author Administrator
 *
 */
public class BufferedInputStreamDemo {
	String filename="log.log";
//	String filename="demo.txt";
	 java.io.File   file = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"+java.io.File.separator+filename);	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BufferedInputStreamDemo().cs1();
		System.out.println("======================");
		new BufferedInputStreamDemo().cs2();
		
		
	}
	//BufferedInputStream读取
	public void cs1(){
		BufferedInputStream  bis = null;		
		try {
			FileInputStream fis = new  FileInputStream(file);
			bis =  new BufferedInputStream(fis);
			int d=-1; 
			long currtime = System.currentTimeMillis();
			int x=-1;
			//缓冲读取，实际并非一个字节一个字节从文件读取，
			while((d=bis.read())!=-1){				
				x++;
			}
			long currtime2 = System.currentTimeMillis();
			System.out.println("读取时间:"+ (currtime2-currtime));
			System.out.println("字节数:"+ x);
			System.out.println("kb数:"+ x/1024);
			System.out.println("Mb数:"+ x/(1024*1024));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	//直接FileInputStream读取
	public void cs2(){
		FileInputStream fis = null;
		try {
			fis = new  FileInputStream(file);
			
			int d=-1; 
			long currtime = System.currentTimeMillis();
			int x=-1;
			//缓冲读取，实际并非一个字节一个字节从文件读取，
			while((d=fis.read())!=-1){
				x++;
			}
			long currtime2 = System.currentTimeMillis();
			System.out.println("读取时间:"+ (currtime2-currtime));
			System.out.println("字节数:"+ x);
			System.out.println("kb数:"+ x/1024);
			System.out.println("Mb数:"+ x/(1024*1024));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}	

	//BufferedInputStream 读取返回 byte[]
	public byte[] readtobyte(){
		BufferedInputStream  bis = null;		
		try {
			FileInputStream fis = new  FileInputStream(file);
			bis =  new BufferedInputStream(fis);
			long currtime = System.currentTimeMillis();
			int x=bis.available();
			byte[] b1 = new byte[x];
			int read = bis.read(b1);
			System.out.println("read:"+read);
			long currtime2 = System.currentTimeMillis();
			System.out.println("读取时间:"+ (currtime2-currtime));
			System.out.println("字节数:"+ x);
			System.out.println("kb数:"+ x/1024);
			System.out.println("Mb数:"+ x/(1024*1024));
			return b1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bis!=null){
				
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		}
		return null;		
	}	
}
