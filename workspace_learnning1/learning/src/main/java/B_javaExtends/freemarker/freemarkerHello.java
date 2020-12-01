package B_javaExtends.freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import Constans.ConstantsFilePath;

/**
 * 模板 + 数据 = 输出
 * @author Administrator
 *
 */
public class freemarkerHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration  conf = new Configuration();
		try {
			
			conf.setDirectoryForTemplateLoading(new File(ConstantsFilePath.basepath_src+File.separator+"freemarker"+File.separator+"template"));
			Template template = conf.getTemplate("HelloFreemarker.ftl");
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", "\"hello freemarker\"");

			Writer  out = new FileWriter(new File("HelloFreemarker.java"));
			template.process(map, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
