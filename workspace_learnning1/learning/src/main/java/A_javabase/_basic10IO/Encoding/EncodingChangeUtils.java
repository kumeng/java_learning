package A_javabase._basic10IO.Encoding;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;


public class EncodingChangeUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	//utf-8 to gbk
	@Test
	public  void change1() {
		EncodingChangeUtils ec = new EncodingChangeUtils();
		String sourcefilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk";
		String destcode="GBK";
		String destfilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk2";
		try {
			ec.changeEncode(sourcefilepath, destcode, destfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//utf-8 to gb2312
	@Test
	public  void change2() {
		EncodingChangeUtils ec = new EncodingChangeUtils();
		String sourcefilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk2312";
		String destcode="GB2312";
		String destfilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk23122";
		try {
			ec.changeEncode(sourcefilepath, destcode, destfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	//gbk to utf-8    = //只有汉字乱码 锟斤拷
	@Test
	public  void change3() {
		EncodingChangeUtils ec = new EncodingChangeUtils();
		String sourcefilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk2";
		String destcode="UTF-8";
		String destfilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk3";
		try {
			ec.changeEncode(sourcefilepath, destcode, destfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//gb2312 to utf-8  = //只有汉字乱码 锟斤拷
	@Test
	public  void change4() {
		EncodingChangeUtils ec = new EncodingChangeUtils();
		String sourcefilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk23122";
		String destcode="UTF-8";
		String destfilepath="C://Users//Administrator//workspace//learning//src//main//java//javabase//IO//Encoding//file_gbk23123";
		try {
			ec.changeEncode(sourcefilepath, destcode, destfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	
	public  void  changeEncode(String sourcefilepath
			,String destcode
			,String destfilepath) throws IOException{
		//读取文件
		FileInputStream readfile = new FileInputStream(sourcefilepath);
		//缓冲读取
		BufferedInputStream bfin = new BufferedInputStream(readfile);
		//字符读取流,可以获取编码格式
		InputStreamReader  insreader = new InputStreamReader(bfin);
		System.out.println("源文件编码格式："+insreader.getEncoding());
		char[] chararry = new char[1024];
		
		
		//写文件
		FileOutputStream writefile = new FileOutputStream(destfilepath);
		//写文件缓冲流
		BufferedOutputStream  bfout = new  BufferedOutputStream(writefile);
		//字符写人流，为了设置编码格式
		OutputStreamWriter  outwriter = new OutputStreamWriter(bfout,destcode);
		
					
		int x=0;
		while(x!=-1){	
			x = insreader.read(chararry);
			outwriter.write(chararry);
		}

		if(insreader!=null){
			insreader.close();
		}
		if(outwriter!=null){
			outwriter.close();
		}
		
		
	}

}
