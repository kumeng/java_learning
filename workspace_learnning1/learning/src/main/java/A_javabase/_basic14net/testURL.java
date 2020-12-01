package A_javabase._basic14net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class testURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:8090/loginPage.action");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getFile());
			System.out.println(url.getAuthority());
			System.out.println(url.getContent());
			System.out.println(url.getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
