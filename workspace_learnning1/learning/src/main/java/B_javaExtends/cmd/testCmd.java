package B_javaExtends.cmd;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class testCmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmd = "msconfig";
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStream inputStream = proc.getInputStream();
			InputStream errorStream = proc.getErrorStream();
			OutputStream outputStream = proc.getOutputStream();
			int exitValue = proc.exitValue();
			int a = 0;
			a++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
