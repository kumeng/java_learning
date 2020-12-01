package A_javabase._basic10IO.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 *
 */
public class BufferedRreaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname1= java.io.File.separator+"home"
		+java.io.File.separator+"logs"+java.io.File.separator;
		String name2 = "copylog.log";
		
		try {
			FileInputStream  inp = new FileInputStream(pathname1+name2);
			InputStreamReader inreader = new InputStreamReader(inp);
			String encode = inreader.getEncoding();
			BufferedReader  reder = new BufferedReader(inreader);
			while(reder.ready()){
				String readLine = reder.readLine();
				System.out.println(readLine);				
			}
			if(reder!=null){
				reder.close();
			}
			BufferedWriter witer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathname1+name2),encode));
			witer.write("ce法规到工地方\n发鬼地方");
			witer.newLine();
			witer.write("dfgfg法国恢复");
			witer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
