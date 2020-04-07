package RMI_Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import RMI.RmtServer;
import dto.users;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RmtServer server_c = (RmtServer)Naming.lookup("testServer");
			//从另一台启动了RMI注册服务的机器上查找hello实例 
			//HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");
			//调用远程方法
			System.out.println(server_c.getDate());
			System.out.println(server_c.task(2,3));
			users  u = new users();
			u.setUsername("dfgname");
			u.setPassword("fdfdgpss");
			System.out.println(server_c.task3(u));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
