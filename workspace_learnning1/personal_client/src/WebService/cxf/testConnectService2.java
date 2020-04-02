package WebService.cxf;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.Test;

/**
 * service编程调用方式
 * @author 20171230
 *
 */
public class testConnectService2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConnectService2  t = new testConnectService2();
		t.test02();
	}
	//命名空间地址
	private String nameSpaceUri = "http://WebService/";  
	//wsdl地址
	private String wsdlUrl = "http://localhost:9001/Service/HelloService?wsdl";  
	//服务名称
	private String serviceName = "HelloServiceService";
	//Port Name
	private String portName = "HelloServicePort";
	/** 
	 * 消息的传递和处理（MESSAGE） 
	 * 提交给服务器 
	 */  
	@Test  
	public void test02() {  
	    try {  
	    	//创建WSDL的URL，注意不是服务地址  
	        URL url = new URL(wsdlUrl);  
	        //创建服务名称  
	        //1.namespaceURI - 命名空间地址  
	        //2.localPart - 服务视图名  	        
	        QName sName = new QName(nameSpaceUri, serviceName); 
	        
	        
	        //创建服务视图  
	        //参数解释：  
	        //1.wsdlDocumentLocation - wsdl地址  
	        //2.serviceName - 服务名称 	        
	        Service service = Service.create(url, sName);  
	        printServiceInfo(service);
	        
	        //获取服务实现类 	          
	        FileUploadIService hello = service.getPort(FileUploadIService.class);
	        //调用查询方法
	          

	    } catch (MalformedURLException e) {  
	        e.printStackTrace();  
	    } 
	}  
	
	public void printServiceInfo(Service service ){
		Iterator<QName> ports = service.getPorts();
		QName serviceName2 = service.getServiceName();
		URL wsdlDocumentLocation = service.getWSDLDocumentLocation();
		System.out.println("ServiceName："+serviceName2.toString());
		while(ports.hasNext()){
			serviceName2 = ports.next();
			System.out.println("PortName："+serviceName2.toString());
		}
		System.out.println("URL:  "+wsdlDocumentLocation.toString());
	}

}
