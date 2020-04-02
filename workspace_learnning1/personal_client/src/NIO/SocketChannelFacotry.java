package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannelFacotry {
	
	public SocketChannel  createSocketChannel(Boolean isblock
			,String hostpath,int port  ) throws IOException{
		
		//默认是阻塞模式
		if(isblock == null){
			isblock  = true;
		}
		SocketChannel  socketc = SocketChannel.open();
		socketc.connect(new InetSocketAddress(hostpath, port));
		socketc.configureBlocking(isblock);
		return socketc;
	}
	
	

}
