package javabase.IO.File;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSeriabled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestSeriabled test = new TestSeriabled();
//		test.testxuliehua();
		test.testxuliehua2();
	}
	public void testxuliehua(){
		TestSeriabledBean2  bena2 = new TestSeriabledBean2();
		bena2.setName("name2");
		bena2.setAge(2);
		bena2.setSex("f");
		bena2.setType("blaaa");			
		TestSeriabled test = new TestSeriabled();
		try {
			//序列化
			byte[] xuliehua = test.xuliehua(bena2);
			bena2.setName("name1");
			System.out.println(bena2.toString());
			
			//这里可以将  序列化后的 byte[] 跨机器传递,但是需要两边都有相同定义 TestSeriabledBean2
			
			//反序列化
			Object fanxuliehua = test.fanxuliehua(xuliehua);
			System.out.println(((TestSeriabledBean2)fanxuliehua).toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//序列化到内存
	public byte[] xuliehua(TestSeriabledBean2  bena2) throws IOException{
	
		ByteArrayOutputStream outp = new ByteArrayOutputStream();
		ObjectOutputStream  oos = new ObjectOutputStream(outp);
		oos.writeObject(bena2);	
		byte[] byteArray = outp.toByteArray();
		if(oos!=null){
			oos.close();
		}
		return byteArray;
	}
	//从内存反序列化
	public Object fanxuliehua(byte[] buf) throws IOException, ClassNotFoundException{
		ByteArrayInputStream intp = new ByteArrayInputStream(buf);
		ObjectInputStream   ois = new ObjectInputStream(intp);
		Object readObject = ois.readObject();
		if(ois!=null){
			ois.close();
		}		
		return readObject;
	}
	
	public void testxuliehua2(){
		TestSeriabledBean2  bena2 = new TestSeriabledBean2();
		bena2.setName("name2");
		bena2.setAge(2);
		bena2.setSex("f");
		bena2.setType("blaaa");			
		TestSeriabled test = new TestSeriabled();
		try {
			//序列化
			String name = test.xuliehua2(bena2);
			bena2.setName("name1");
			System.out.println(bena2.toString());
			
			//这里可以将  序列化后的 byte[] 跨机器传递,但是需要两边都有相同定义 TestSeriabledBean2
			
			//反序列化
			Object fanxuliehua = test.fanxuliehua2(name);
			System.out.println(((TestSeriabledBean2)fanxuliehua).toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//序列化到文件
	public String xuliehua2(TestSeriabledBean2  bena2) throws IOException{
	
		String pathname = java.io.File.separator+"home"
				+java.io.File.separator+"logs"+java.io.File.separator+"seriabled.txt";
		FileOutputStream  outp = new FileOutputStream(pathname);
		ObjectOutputStream  oos = new ObjectOutputStream(outp);
		oos.writeObject(bena2);	
		if(oos!=null){
			oos.close();
		}
		return pathname;
	}
	//从文件反序列化
	public Object fanxuliehua2(String name) throws IOException, ClassNotFoundException{
		FileInputStream intp = new FileInputStream(name);
		ObjectInputStream   ois = new ObjectInputStream(intp);
		Object readObject = ois.readObject();
		if(ois!=null){
			ois.close();
		}			
		return readObject;
	}	

}
