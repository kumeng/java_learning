package A_javabase._basic10IO.File;


import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fileReader = new FileReader("c:\\data2.txt");
		char[] buffer = new char[256];
		if(fileReader.ready()){
			int readNum = fileReader.read(buffer);
			fileReader.close();
			System.out.println("readNum is "+readNum+",readstr is "+new String(buffer,0,readNum));
		}
		
		
	}

}
