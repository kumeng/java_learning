package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * udp: a、是面向无连接, 将数据及源的封装成数据包中,不需要建立连接
    b、每个数据报的大小在限制64k内
    c、因无连接,是不可靠协议
    d、不需要建立连接,速度快

 * @author Administrator
 *
 */

public class udpscoket_service {
	public static void main(String[] arg0) throws IOException{
		System.out.println("开启udp服务器，保持监听，");
		DatagramSocket  ds = new DatagramSocket(11090);
		byte[] bys = new byte[1024];
		DatagramPacket  dp = new DatagramPacket(bys,bys.length);
		//阻塞，等待接受客户端请求
		ds.receive(dp);
		
		System.out.println("来源"+dp.getAddress()+":"+dp.getPort());
		//获取内容
		String str = new String(dp.getData(),0,dp.getLength());
		System.out.println("接收到："+str);
	}
}
