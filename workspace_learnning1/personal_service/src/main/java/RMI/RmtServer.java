package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import dto.users;
import job.WorkRequest;

/**
 * RMI  remote  method  invocation  远程方法调用
 * @author Administrator
 *
 */
public interface RmtServer extends Remote{
	Date getDate() throws RemoteException;
	Object task(Integer m,Integer n) throws RemoteException;
	Object task3(users obj) throws RemoteException;
}
