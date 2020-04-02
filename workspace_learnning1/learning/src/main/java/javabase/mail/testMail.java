package javabase.mail;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 核心API javax.mail
 * Session Message Address Authenticator Transport Store Folder 
 * @author Administrator
 *
 */
public class testMail {

	
	private String smtphost;  //服务器 
	private String smtpuser;  //登录名
	private String smtppwd;   //密码
	private String from;     //发件人
	private String to;        //收件人
	private String head;     //标题
	private String body;     //内容
	private String bodystyle="text/plain;charset=UTF-8"; //默认text/plain文本格式，html可用 text/html
	private String filename;   //附件名
	private Vector file=new Vector() ;//保存附件的集合
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMail test = new testMail();
		test.smtphost = args[0];
		test.smtpuser = args[1];
		test.smtppwd = args[2];
		test.from = args[3];
		test.to = args[4];
		test.head = args[5];
		test.body = args[6];
		test.bodystyle = args[7];
//		test.filename = args[8];
		//文件如何处理
		try {
			test.sendmailHello();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void sendmailHello() throws MessagingException{

		Multipart mp = new MimeMultipart();  //存放多个bodypart  内容，附件等
		
		//添加附件到Multipart
		Enumeration efile = file.elements();//枚举器 遍历集合
		while(efile.hasMoreElements()){
			MimeBodyPart  mbody = new MimeBodyPart();
			filename = efile.nextElement().toString();   //得到附件名
			FileDataSource fds = new FileDataSource(filename);  //得到数据源
			mbody.setDataHandler(new DataHandler(fds));    //得到附件  放入BodyPart
			mbody.setFileName(fds.getName());    //得到附件名  放入BodyPart
			mp.addBodyPart(mbody);   //添加附件到Multipart
		}
		file.removeAllElements();   //清空附件集合
		
		//添加z正文内容到Multipart
		MimeBodyPart  mbody = new MimeBodyPart();
		mbody.setContent(body, bodystyle);//准备放入正文
		mp.addBodyPart(mbody);       //添加z正文内容到Multipart
		
		//下面开始准备发送
		Properties p = new Properties();  //建立空属性
		p.setProperty("mail.smtp.host", smtphost);
		p.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(p,null);
		Message mimeMessage = new MimeMessage(session);//传入Session 创建Message对象
		Address addr = new InternetAddress(from); 
		mimeMessage.setFrom(addr);
		Address[]  addrsto = {new InternetAddress(to) };
		//TO  发个一人  BC 复制另一个人     BCC
		mimeMessage.setRecipients(Message.RecipientType.BCC, addrsto);
		mimeMessage.setSubject(head);		//设置头  到  Message
		mimeMessage.setContent(mp);        //设置Multipart(包括内容和附件 )  到  Message
		mimeMessage.setSentDate(new Date()); //设置日期
		
		Transport transport = session.getTransport("smtp");//从Session获取传输对象
		transport.connect(smtphost, smtpuser, smtppwd);//建立连接
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients()); //发送
		transport.close();
	}

}
