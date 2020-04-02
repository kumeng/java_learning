package javabase.IO.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_WriteFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//首先写个文件,默认就是覆盖模式
		new FileOutputStream_WriteFileDemo().reWriter(false);
		//追加模式
		new FileOutputStream_WriteFileDemo().reWriter(true);
		//覆盖模式
		new FileOutputStream_WriteFileDemo().reWriter(false);
	}
	public void reWriter(boolean fl){
		
		byte[] somebyte = {'a','b','d'};
//		byte[] byteln ={'\n'};
		byte[] byteln={'3','7'};
		try {
			
			FileOutputStream fileoutput = null; 
			if(fl){
				fileoutput=	new FileOutputStream("c:\\data.txt",fl);
			}else{
				fileoutput=	new FileOutputStream("c:\\data.txt");
			}
					
			if(fileoutput != null){				
				fileoutput.write(somebyte);
				fileoutput.write(byteln);
				fileoutput.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

}
