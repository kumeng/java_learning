package javabase.IO.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Administrator
 *
 */
public class PrintWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname1= java.io.File.separator+"home"
		+java.io.File.separator+"logs"+java.io.File.separator;
		String name2 = "copylog.log";
		
		try {
			FileOutputStream  fileoutput = new FileOutputStream(pathname1+name2);
//			自动行刷新的缓冲字符输出流
			PrintWriter  pw = new PrintWriter(fileoutput,true);
			pw.print("11111111111111");
			pw.print(45654633);
			//立即写出缓冲区已有内容，并换行
			pw.println("2222222222222222");
			pw.print(45654633);
			if(pw!=null){
				//close之前会自动清空缓冲区，并写出
				pw.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
