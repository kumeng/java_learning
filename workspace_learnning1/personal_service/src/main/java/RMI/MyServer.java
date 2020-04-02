package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import dto.users;
import job.MyCalculation;
import job.WorkRequest;

public class MyServer extends UnicastRemoteObject implements RmtServer {


/**
 * 构造器必须声明 RemoteException异常，所以必须显示写出来
 * @throws RemoteException
 */
	protected MyServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Date getDate() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("hello,this is MyServer");
		return new Date();
	}

	
	public Object task(Integer m,Integer n) throws RemoteException {
		// TODO Auto-generated method stub
		return new MyCalculation(m,n).task();
	}


	@Override
	public Object task3(users obj) throws RemoteException {
		// TODO Auto-generated method stub
		return obj.getUsername()+"\r"+obj.getPassword();
	}	

}
