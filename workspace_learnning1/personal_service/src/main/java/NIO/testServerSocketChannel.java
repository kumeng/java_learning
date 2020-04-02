package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
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
		testServerSocketChannel newserver = new testServerSocketChannel();
		try {
			newserver.test1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//阻塞模式,循环监听端口
	public void test1() throws IOException{
		ServerSocketChannel  serversocketc = ServerSocketChannel.open();
		serversocketc.socket().bind(new InetSocketAddress(9999));
		System.out.println("9999等待连接..");
		while(true){
			//accept()方法会一直阻塞到有新连接到达
			SocketChannel accept = serversocketc.accept();
			System.out.println("9999已经连接..");
			if(accept!=null){
				this.readBytefromSocketchannel(accept);
				this.WriteBytetiSocket(accept);
//				accept.close();		
				
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
		System.out.println("9999等待连接..");
		while(true){
			//accept()方法可能还没接收到 连接，于是可能返回nulll
			SocketChannel accept = serversocketc.accept();
			System.out.println("9999已经连接..");
			if(accept!=null){
				this.readBytefromSocketchannel(accept);
				accept.close();
				break;
			}
		}
		
		serversocketc.close();
		
	}	

	public void readBytefromSocketchannel(SocketChannel  socketc) throws IOException{		
		
		//从SocketChannel 中读取数据
		ByteBuffer buff = ByteBuffer.allocate(148);
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
		
	}	
	
	public void WriteBytetiSocket(SocketChannel  socketc) throws IOException{		
		ByteBuffer buff = ByteBuffer.allocate(148);
		String newdate = "这里是服务端发送的,msg from server"+System.currentTimeMillis();
		buff.clear();
		buff.flip();
		buff.put(newdate.getBytes());
		buff.flip();
		while(buff.hasRemaining()){
			socketc.write(buff);
		}
		
		
	}	
}
