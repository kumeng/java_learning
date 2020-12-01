package A_javabase._basic10IO.File;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char[] somebyte = {'a','b','d'};
		char[] byteln ={'\n'};
		FileWriter fileoutput = new FileWriter("c:\\data2.txt");
		if(fileoutput != null){
			fileoutput.write(somebyte);
			fileoutput.write(byteln);
			fileoutput.write(somebyte);
			fileoutput.close();
		}
	}

}
