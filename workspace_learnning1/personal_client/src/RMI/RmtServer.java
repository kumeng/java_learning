package RMI;

import java.rmi.Remote;
import java.util.Date;

import dto.users;

/**
 * RMI  remote  method  invocation  远程方法调用
 * @author Administrator
 *
 */
public interface RmtServer extends Remote{
	Date getDate() ;
	Object task(Integer m,Integer n);
	Object task3(users obj) ;
}
