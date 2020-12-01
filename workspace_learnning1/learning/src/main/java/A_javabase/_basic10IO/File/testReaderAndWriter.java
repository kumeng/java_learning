package A_javabase._basic10IO.File;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class testReaderAndWriter {
	 static java.io.File   file = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"+java.io.File.separator+"log.log");	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Long currtime1 = System.currentTimeMillis();
			char[] testReader = testReaderAndWriter.testReader_noBuffered();
			Long currtime2 = System.currentTimeMillis();			
			testReaderAndWriter.testWriter(testReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static char[] testReader() throws IOException{
		FileInputStream fis = new  FileInputStream(file);
		
		//BufferedInputStream  使用缓冲区加速读取文件效率
		BufferedInputStream bis = new BufferedInputStream(fis);
		//指定编码读取
		InputStreamReader  reader = new InputStreamReader(bis);
		System.out.println("encoding:"+reader.getEncoding());
		char[] cr = new char[bis.available()];
		reader.read(cr);
		if(reader!=null){
			reader.close();
		}
		
		return cr;
		
	}
	public static void testWriter(char[] cr) throws IOException{
		file = new java.io.File (java.io.File.separator+"home"
				+java.io.File.separator+"logs"+java.io.File.separator+"Writertext.txt");			
		FileOutputStream  outs = new FileOutputStream(file,false);
		OutputStreamWriter  writer = new OutputStreamWriter(outs,"utf-8");
		writer.write(cr);
		String string = "上单据华国锋";
		writer.write(string);
		if(writer!=null){
			writer.close();
		}
		System.out.println(string);
	}
	public static char[] testReader_noBuffered() throws IOException{
		FileInputStream fis = new  FileInputStream(file);
		//指定编码读取
		InputStreamReader  reader = new InputStreamReader(fis);
		System.out.println("encoding:"+reader.getEncoding());
		char[] cr = new char[fis.available()];
		reader.read(cr);
		if(reader!=null){
			reader.close();
		}
		
		return cr;
		
	}	
	
	@Test
	public void test(){
		
	}
}
