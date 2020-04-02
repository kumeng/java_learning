package javabase.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *  ServerSocketChannel 是一个可以监听新进来的TCP连接的通道
 * @author Administrator
 *
 */
public class testServerSocketChannel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//阻塞模式,循环监听端口
	public void test1() throws IOException{
		ServerSocketChannel  serversocketc = ServerSocketChannel.open();
		serversocketc.socket().bind(new InetSocketAddress(9999));
		while(true){
			//accept()方法会一直阻塞到有新连接到达
			SocketChannel accept = serversocketc.accept();
			if(accept!=null){
				
				accept.close();
				break;
			}
		}
		
		serversocketc.close();
		
	}
	
	//非阻塞模式
	public void test2() throws IOException{
		ServerSocketChannel  serversocketc = ServerSocketChannel.open();
		serversocketc.socket().bind(new InetSocketAddress(9999));
		//比阻塞模式多了这句
		serversocketc.configureBlocking(false);
		while(true){
			//accept()方法可能还没接收到 连接，于是可能返回nulll
			SocketChannel accept = serversocketc.accept();
			if(accept!=null){
				
				accept.close();
				break;
			}
		}
		
		serversocketc.close();
		
	}	

}
