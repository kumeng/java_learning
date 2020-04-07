package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udpscoket_client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("udp客户端启动");
		DatagramSocket ds = new DatagramSocket();
		byte[] bys = "蚂蚁麻麻".getBytes();
		DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("127.0.0.1"),11090);
		ds.send(dp);
		ds.close();
	}

}
