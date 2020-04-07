package javabase.IO.File;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ReadFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream input = new FileInputStream("c:\\data.txt");
		byte[] buffwr = new byte[input.available()];
		if(input!=null){
			System.out.println(input.read(buffwr));
			String str = new String(buffwr);
			System.out.println(str);
			input.close();
		}
	}	

}
