package WebServiceClient.httpbid;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import org.xml.sax.InputSource;

/**
 * HttpURLConnection调用方式
 * @author 20171230
 *
 */
public class testConnectService3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConnectService3  t = new testConnectService3();
		try {
			t.test02();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test  
	public void test02() throws IOException {  

	    	String serverurl = "http://localhost:9001/Service/HelloService";
	    	//第一步：创建服务地址，不是WSDL地址  
	        URL url = new URL(serverurl);  
	        //第二步：打开一个通向服务地址的连接
	        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
	        //第三步：设置参数
	        //3.1设置发送方式，必须大写POST
	        connect.setRequestMethod("POST");
	        //3.2设置content-type
	        connect.setRequestProperty("content-type", "text/xml;charset=utf-8");
	        //3.3设置输入输出，默认没有读写权限
	        connect.setDoOutput(true);
	        connect.setDoInput(true);	        
	        
	        //第四步，准备soap数据，发送请求
	        String soap_xml = getxml("测试3");
	        OutputStream outputStream = connect.getOutputStream();
	        outputStream.write(soap_xml.getBytes());
	        
	        //第五步，接受服务器响应
	        int responseCode = connect.getResponseCode();
	        if(200==responseCode){//表示响应成功
	        	InputStream inputStream = connect.getInputStream();
	        	InputStreamReader isr = new InputStreamReader(inputStream,"UTF-8");
	        	BufferedReader  bufferedReader = new BufferedReader(isr);
	        	String readLine = bufferedReader.readLine();
	        	System.out.println(readLine);
	        	this.readResultFromxmlstr(readLine);
	        	while(readLine!=null){
	        		readLine = bufferedReader.readLine();
	        		if(readLine!=null){
	        			System.out.println(readLine);
	        			this.readResultFromxmlstr(readLine);
	        		}
	        		
	        	}
	        	bufferedReader.close();
	        }
	        
	        outputStream.close();	        	      

	}  
	
	public String getxml(String arg0 ){
        String json = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
        		+ " xmlns:web=\"http://WebService/\">\r\n" +
                "   <soapenv:Header/>\r\n" +
                "   <soapenv:Body>\r\n" +
                "	<web:getName>\r\n" +
                "	<arg0>"+arg0+"</arg0>\r\n"+
                "	</web:getName>\r\n"+	                	          	              
                "   </soapenv:Body>\r\n" +
                "</soapenv:Envelope>";	
        return json;
	}

	void readResultFromxmlstr(String xmlstr){
//		xmlstr = xmlstr.replace("<?xml version='1.0' encoding='UTF-8'?>", "");
		StringReader   strreader = new StringReader(xmlstr);
		//创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource  source = new InputSource(strreader);
		//jdom.jar 包
		SAXBuilder  build = new SAXBuilder();
		try {
			org.jdom.Document  document = build.build(source);
			Element rootElement = document.getRootElement();
			Element selectSingleNode = (Element)org.jdom.xpath.XPath.selectSingleNode(rootElement, "//return");
			System.out.println("return: "+selectSingleNode.getText());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
