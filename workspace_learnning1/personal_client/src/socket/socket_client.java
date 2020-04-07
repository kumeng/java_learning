package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class socket_client {
	String clientstr = "默认客户端";
	String tabstr = ": \t";
	public socket_client(){
		
	}
	public socket_client(String str){
		clientstr = str;
	}	

	public Socket  getSocketConnectionOf(){
		try {
			Socket   sc = new  Socket("localhost",8088);
			return sc;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	public void  CloseSocket(Socket sc){
		if(sc!=null){
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendmsgToService(String msg){
		Socket connectionOfSocket = this.getSocketConnectionOf();
		try {
			OutputStream outputStream = connectionOfSocket.getOutputStream();
			OutputStreamWriter  wri = new OutputStreamWriter(outputStream,"UTF-8");
			PrintWriter  pw = new PrintWriter(wri,true);
			pw.println(clientstr+tabstr+msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.CloseSocket(connectionOfSocket);
		}
	}
	
	//循环发送消息
	public void loopSendmsgToService(){
		Socket connectionOfSocket = this.getSocketConnectionOf();
		try {
			OutputStream outputStream = connectionOfSocket.getOutputStream();
			OutputStreamWriter  wri = new OutputStreamWriter(outputStream,"UTF-8");
			PrintWriter  pw = new PrintWriter(wri,true);
			System.out.println("请输入要发送到服务器的数据");
			Scanner  sc = new Scanner(System.in);
			//循环发送
			while(true){
				pw.println(clientstr+tabstr+sc.nextLine());
			}						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.CloseSocket(connectionOfSocket);
		}
	}	
	public static void main(String[] arg0){
//		new socket_client().testConnection();
//		new socket_client().loopSendmsgToService();
		new socket_client("客户端A").testConnection();
		new socket_client("客户端B").testConnection();
		new socket_client("客户端C").testConnection();
	}	
	public void testConnection(){
		this.sendmsgToService(" 服务器收到了吗");
	}
}
