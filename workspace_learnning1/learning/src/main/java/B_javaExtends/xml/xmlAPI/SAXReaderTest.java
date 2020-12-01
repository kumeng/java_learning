package B_javaExtends.xml.xmlAPI;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用 org.dom4j.io.SAXReader  读取xml
 * @author Administrator
 *
 */
public  class SAXReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		SAXReader  reader = new SAXReader();
		try {
			Document read = reader.read(new File("C:/Users/Administrator/workspace/learning/src/main/java/javabase/xml/xmltemplate.xml"));
			//获取根节点
			Element rootElement = read.getRootElement();			
			//获取当前节点下名为   subroot  的节点
			Element element = rootElement.element("subroot2");			
			List elements = rootElement.elements();
			for(Object ele:elements){
				Element ele2 = (Element)ele;
				ele2 = ele2.element("value");
				System.out.println(ele2.getText());
			}
			element = element.element("description");
			String name = element.getName();
			String text = element.getText();

			Attribute attribute = element.attribute(0);
			Attribute attribute2 = element.attribute("tri2");
			String attributename = attribute.getName();
			String attributevalue = attribute.getValue();
			System.out.println();
			
			element = element.getParent().element("value");
			name = element.getName();
			text = element.getText();		
			System.out.println(text);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
