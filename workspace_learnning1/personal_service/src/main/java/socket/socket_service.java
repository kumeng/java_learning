package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *tcp：a、建立连接，形成传输数据的通道.
    b、在连接中进行大数据量传输，以字节流方式
    c 通过三次握手完成连接,是可靠协议
    d 必须建立连接m效率会稍低
 * 
 */
public class socket_service {
	ServerSocket servicesc  = null;
	
	//只能监听一个Socket连接
	public void start(){
		try {
			 servicesc  = new ServerSocket(8088);
			 System.out.println("等待客户端连接...");
					 
			 //监听端口，等待连接
			 Socket accept = servicesc.accept();
			 System.out.println("客户端已连接");
			 InputStream inputStream = accept.getInputStream();
			 InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
			 BufferedReader  bf = new BufferedReader(reader);
			 while(true){
				 System.out.println(bf.readLine()); 
			 }
			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(servicesc!=null){
					servicesc.close();
				}				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//使用线程池，让一个线程让管理一个socket连接，达到监听多线程的目的
	public void start2(){
		try {
			
			 servicesc  = new ServerSocket(8088);
			 System.out.println("等待客户端连接...");
			
			 //创建固定线程数的线程池
			 ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
			 while(true){				 
				 //监听端口，等待连接
				 Socket accept = servicesc.accept();
				 socketThread socketThread = new socketThread(accept);
				 newFixedThreadPool.execute(socketThread);
			 }
			


			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(servicesc!=null){
					servicesc.close();
				}				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] arg0){
//		new socket_service().start();
		new socket_service().start2();
	}
	
}
class socketThread  implements Runnable{
	Socket accept = null;
	public socketThread(Socket accep){
		accept = accep;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("客户端已连接");
		 try {
			InputStream inputStream = accept.getInputStream();
			 InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
			 BufferedReader  bf = new BufferedReader(reader);
			 while(true){
				 System.out.println(bf.readLine()); 
			 }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
