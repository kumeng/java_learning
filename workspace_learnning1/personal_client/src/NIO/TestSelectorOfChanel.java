package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel：

打开一个SocketChannel并连接到互联网上的某台服务器。
一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。
 * @author Administrator
 *
 */
public class TestSelectorOfChanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new TestSelectorOfChanel().startSelector();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  startSelector() throws IOException{
		Selector selc = Selector.open();
		//创建一个非阻塞模式的，连接本地 9999 端口的 socketChannel(通道的一种)
		SocketChannelFacotry facory = new SocketChannelFacotry();
		SocketChannel socketChannel = facory.createSocketChannel(false, "localhost", 9999);
		//注册到Selector
		int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
		SelectionKey selectKey = socketChannel.register(selc, interestSet, "firstSocketChannel");
		
		switchSelectkey(selectKey);
		
		//阻塞，一直到通道准备完毕
		int select = selc.select();
		
		switchSelectkey(selectKey);		
	}

	private void switchSelectkey(SelectionKey selectKey) throws IOException {
		if(selectKey.isAcceptable()){
			System.out.println("selectKey isAcceptable ");
		}
		else if(selectKey.isConnectable()){
			System.out.println("selectKey isConnectable ");
		}
		else if(selectKey.isReadable()){
			System.out.println("selectKey isReadable ");
		}
		else if(selectKey.isWritable()){
			System.out.println("selectKey isWritable ");
			SocketChannel mudch = (SocketChannel) selectKey.channel();
			this.WriteBytetiSocket(mudch);			
			this.readBytefromSocketchannel(mudch);
			System.out.println("'是否打开"+mudch.isOpen());
//			System.out.println("'是否关闭"+mudch.finishConnect());
		}else{
			System.out.println("通道尚未准备好");
		}
	}
	
	public void readBytefromSocketchannel(SocketChannel  socketc) throws IOException{		
		
		//从SocketChannel 中读取数据
		ByteBuffer buff = ByteBuffer.allocate(148);
		int read = socketc.read(buff);		
		while(read>1){
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
		String newdate = "这里是客户端发送的,msg from client "+System.currentTimeMillis();
		buff.clear();	
		buff.put(newdate.getBytes());
		buff.flip();
		while(buff.hasRemaining()){
			socketc.write(buff);
		}
		
	}
}
