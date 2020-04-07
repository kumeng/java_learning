package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {

			 
			 //获取默认端口1099的Registry
			Registry local_egistry =    LocateRegistry.getRegistry();
			if(null==local_egistry){
				 //启动RMI注册服务,指定端口1099（默认端口）
				 //1024以下为操作系统保留端口，建议1024以上				
				local_egistry = LocateRegistry.createRegistry(1099);
			}
					
			
			RmtServer se = new MyServer();
			
			// 注册服务到RMi上，命名为testServer
			/**
			 * java.rmi.Naming
			 *  lookup  返回与名称文件部分关联的远程对象
			 *  bind  把指定名称绑定到远程对象。如果该名称已绑定到某一对象，则报AlreadyboundException
			 *  rebind 不管是否已有绑定，，强制绑定到新的对象
			 *  unbind 撤销绑定
			 */			
			Naming.rebind("testServer", se);
			
			System.out.println("testServer is alredy");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
