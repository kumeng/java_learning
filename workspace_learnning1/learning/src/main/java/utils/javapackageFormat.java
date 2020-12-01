package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class javapackageFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileParerntpath = args[0];	
		String prefixPackageName = null;
		if(args.length>1){
			prefixPackageName = args[1];
		}
		System.out.println("获取要处理包格式的包的绝对路径:"+fileParerntpath);
		File file = new File(fileParerntpath);
		try {
			circlehanderPackageFormatOfjava(file,prefixPackageName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void circlehanderPackageFormatOfjava(File file,String parentPackageName) throws IOException{
		// TODO Auto-generated method stub		
		if(file.isDirectory()){
			String name =  parentPackageName==null?file.getName():parentPackageName+"."+file.getName();			
			File[] listFiles = file.listFiles();
			if(listFiles!=null){
				for(File f:listFiles){
					circlehanderPackageFormatOfjava(f,name);
				}				
			}
		}else{
			circlehanderPackageFormatOfjava2(file,parentPackageName);
		}		
	}
	
	private static void circlehanderPackageFormatOfjava2 (File file,String parentPackageName)throws IOException {
		// TODO Auto-generated method stub
		//获取换行符
		String lineSeparator = System.getProperty("line.separator");
		FileReader fileReader = new FileReader(file);
		BufferedReader breader = new BufferedReader(fileReader);
		List<String> list = new ArrayList<String>();
		while(breader.ready()){
			String readLine = breader.readLine();
			if(readLine!=null&&readLine.indexOf("package")>-1){
				readLine = "package "+parentPackageName+";";
			}
			list.add(readLine);
		}
		breader.close();
		FileWriter fileWriter = new FileWriter(file);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				fileWriter.write(list.get(i)+lineSeparator);			
			}			
		}
		fileWriter.flush();
		fileWriter.close();
	}

}
