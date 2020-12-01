package B_javaExtends.xml.xmlAPI;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.xpath.XPath;

import org.dom4j.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * jdom.jar 构建Document对象
 * 支持xpath,需要包 jaxen-xx-xx.jar
 * @author 20171230
 *
 */
public class JdomReaderXMLStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个新的字符串
		StringReader   strreader = new StringReader(getxmlstr("ceshi"));
		//创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource  source = new InputSource(strreader);
		//jdom.jar 包
		SAXBuilder  build = new SAXBuilder();
		try {
			org.jdom.Document  document = build.build(source);
			Element rootElement = document.getRootElement();
			Element selectSingleNode = (Element)org.jdom.xpath.XPath.selectSingleNode(rootElement, "//arg0");
			System.out.println(selectSingleNode.getText());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getxmlstr(String arg0 ){
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
}
