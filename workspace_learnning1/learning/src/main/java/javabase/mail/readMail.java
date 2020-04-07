package javabase.mail;

/**
 * 额外的jar包
 */
import java.util.Properties;

import javax.mail.*;

public class readMail {

	private String smtphost;  //服务器 
	private String smtpuser;  //登录名
	private String smtppwd;   //密码	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readMail rm = new readMail();
		try {
			rm.readMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readMail() throws MessagingException{
		Properties p = new Properties();  //建立空属性
		Session session = Session.getDefaultInstance(p,null);
		//
		Store store = session.getStore("pop3");
		store.connect(smtphost, smtpuser, smtppwd);
		
		Folder folder = store.getFolder("inbox");
		folder.open(Folder.READ_ONLY);
		
		Message[] messages = folder.getMessages();
		
		for(Message msg: messages){
			System.out.println("孙子收邮件啦："+msg.getSubject());
		}
		
		//关闭连接
		folder.close(false);
		store.close();
	}

}
