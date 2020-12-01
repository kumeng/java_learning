package A_javabase._basic14net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testInetAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress  ip = InetAddress.getLocalHost();
			
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getCanonicalHostName());
			System.out.println(ip.getAddress()[2]);
			System.out.println(ip.getLoopbackAddress().getHostAddress());
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
