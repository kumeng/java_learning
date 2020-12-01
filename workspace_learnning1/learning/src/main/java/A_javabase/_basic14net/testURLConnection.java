package A_javabase._basic14net;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class testURLConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
//			url = new URL("http://www.w3school.com.cn/jquery/jquery_traversing_ancestors.asp");
			url = new URL("http://localhost:8090/main.action"); 
			URLConnection uc = url.openConnection();
			System.out.println(uc.getContentType());
			System.out.println(new java.util.Date(uc.getDate()));
			InputStream in = uc.getInputStream();
			//OutputStream out = uc.getOutputStream();
			System.out.println(in.available());
			File file = new File("C:\\text.txt");
		    FileOutputStream out = new FileOutputStream(file);
		    byte[] by = new byte[1024];
		    System.out.println(in.read(by));
		    out.write(by);
		    out.close();
		    
		    
			
//			System.out.println(in.read(new byte[in.available()]));
//			java.io.BufferedInputStream;
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
