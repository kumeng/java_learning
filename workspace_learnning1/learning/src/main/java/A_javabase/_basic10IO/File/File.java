package A_javabase._basic10IO.File;

import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

import org.junit.Test;

public class File {
//	String filename="log.log";
	String filename="demo.txt";
	 java.io.File   file = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"+java.io.File.separator+filename);	
	
//	/home/logs/testfile1/testfile2/   
	static java.io.File   file2 = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"
			+java.io.File.separator+"testfile1"
			+java.io.File.separator+"testfile2");			
	static java.io.File   file3 = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"
			+java.io.File.separator+"testfile1"
			+java.io.File.separator+"testfile3");		
	static java.io.File   file4 = new java.io.File (java.io.File.separator+"home"
			+java.io.File.separator+"logs"
			+java.io.File.separator+"testfile1"
			);	
	
	//文件大小，，文件不存在时，大小为0
	@Test
	public void  testFile1(){

		System.out.println("文件大小:"+Math.round(file.length()/1024)+"kb");
	} 
	//创建文件
	@Test
	public void  testFile2(){
		//判断文件或者文件夹是否存在
		try {
			if(!file.exists()){
				boolean fl = file.createNewFile();
				System.out.println("创建是否成功:"+fl);
			}
			System.out.println("文件已存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//创建文件夹
	@Test
	public void  testFile3(){

		file2.delete();
		boolean delete = file3.delete();
		System.out.println("删除目录testfile3是否成功:"+delete);		
		file4.delete();
		if(!file2.exists()){
			boolean fl = file2.mkdirs();
			System.out.println("创建多级目录testfile1/testfile2是否成功:"+fl);

			if(!file3.exists()){
				fl = file3.mkdir();
				System.out.println("创建单级目录testfile3是否成功:"+fl);
			}else{
				System.out.println("文件夹已存在");
			}
		}else{
			System.out.println("文件夹已存在");
		}			
	}	
	//获取子文件组，过滤子文件组
	@Test
	public void  testFile4(){
		java.io.File[] listFiles = file4.listFiles();
		for(java.io.File file:listFiles){
			System.out.println(file.getName());
		}
		
		System.out.println("FiLter过滤结果");
		
		//自定义类实现接口FiLter
		FileFilter  filter = new MyFileFilter();
		//自定义类实现接口FilenameFilter
		FilenameFilter  namefilter =  new MyFilenameFilter();
		listFiles = file4.listFiles(filter);
		for(java.io.File file:listFiles){
			System.out.println(file.getName());
		}
		
		System.out.println("FilenameFilter过滤结果");
		
		listFiles= file4.listFiles(namefilter);
		for(java.io.File file:listFiles){
			System.out.println(file.getName());
		}		
	}	
}

class MyFileFilter implements FileFilter {

	public boolean accept(java.io.File pathname) {
		// TODO Auto-generated method stub
		if(pathname.equals(File.file2)){
			return true;
		}
		return false;
	}
	
}
class MyFilenameFilter implements FilenameFilter {

	public boolean accept(java.io.File dir, String name) {
		// TODO Auto-generated method stub
		if(dir.equals(File.file4)&&name.equals(File.file3.getName())){
			return true;
		}
		return false;
	}
	
}
