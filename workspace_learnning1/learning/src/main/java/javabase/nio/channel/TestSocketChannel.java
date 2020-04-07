package javabase.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


/**
 * SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel：

打开一个SocketChannel并连接到互联网上的某台服务器。
一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。
 * @author Administrator
 *
 */
public class TestSocketChannel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void test1() throws IOException{
		//默认是阻塞模式
		SocketChannel  socketc = SocketChannel.open();
		socketc.connect(new InetSocketAddress("http://jenkov.com", 80));
		
		//从SocketChannel 中读取数据
		ByteBuffer buff = ByteBuffer.allocate(48);
		int read = socketc.read(buff);		
		while(read!=-1){
			System.out.println("\nread"+read);
			buff.flip();
			while(buff.hasRemaining()){
				//循环打印buffer内容    ，中文乱码了
				System.out.print((char)buff.get());
			}
			buff.clear();
			read = socketc.read(buff);			
		}
		
		String newdate = "sdfsdfsdfdsfsdf"+System.currentTimeMillis();
		buff.clear();
		buff.flip();
		buff.put(newdate.getBytes());
		buff.flip();
		while(buff.hasRemaining()){
			socketc.write(buff);
		}
		
		socketc.close();
	}
}
