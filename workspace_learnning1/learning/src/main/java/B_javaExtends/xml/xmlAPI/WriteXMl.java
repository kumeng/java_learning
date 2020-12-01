package B_javaExtends.xml.xmlAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author Administrator
 *
 */
public class WriteXMl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document createDocument = DocumentHelper.createDocument();
		//添加根节点
		Element root = createDocument.addElement("project");
		//向根节点添加子节点
		Element ele = root.addElement("path");
		//向子节点添加属性
		ele.addAttribute("attr1", "1");
		//向子节点添加文本
		ele.addText("饿了");
		
		//使用Xmlwriter输出到xml文档
		XMLWriter  write = new XMLWriter();
		try {
			File file = new File("/home/xml/");
			//如果文件夹不存在，则创建
			if(!file.exists()){
				boolean mkdirs = file.mkdirs();
			}			
			FileOutputStream  fileout = new FileOutputStream("/home/xml/build.xml");

			write.setOutputStream(fileout);
			write.write(createDocument);			
			write.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
