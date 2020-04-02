package utils;

import static java.util.Locale.ENGLISH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyObject4 {
	/**
	 * 浅度复制,利用反射，动态运行get ,set方法
	 * 复制同一类型的对象
	 * @param ori  复制来源对象
	 * @param onew 目的对象
	 * @return     目的对象
	 * 
	 * 支持 属性以 aA的方式命名  (实际是getaA,setaA)
	 */	
	public static  void  copyBean2(Object ori,Object  onew){
		Class<?> classtype = ori.getClass();
//		Constructor<?> cur2;
//		Object onew = null;
		try {
//			cur2 = classtype.getConstructor();
			//Method[] me = classtype.getDeclaredMethods();
			Field[] fi = classtype.getDeclaredFields();
			for(Field f:fi){
					
				Method logMethod = null;
				try{
					logMethod =classtype.getMethod(getMethodname_fromField(f));
				}catch (NoSuchMethodException e) {
					continue;
				} 				

				Object df = logMethod.invoke(ori);
				
				logMethod = classtype.getMethod(setMethodName_fromField(f), f.getType());				
				
				logMethod.invoke(onew,df);
			}			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public  static  String capitalize(String name) { 
	if (name == null || name.length() == 0) { 
	    return name; 
        }
	char[] chr = new char[2];
	chr = name.substring(0, 2).toCharArray();
	if( chr[0] >= 'a' && chr[0] <= 'z' && chr[1] >= 'a' && chr[1] <= 'z' )
	{
		return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
	}else{
		return name; 
	}
    }
    
    public static String  getMethodname_fromField(Field f){
		String readMethodName;
		String newcha =  capitalize(f.getName());
		
		if(null==f.getType()||f.getType()==boolean.class){
			 readMethodName = "is" +newcha ;
		}else{
			readMethodName = "get" +newcha;
		}	    	
		return readMethodName;
    }
    public static String  setMethodName_fromField(Field f){
    	return  "set"+capitalize(f.getName());
    }    
    /**
     * 深度复制，利用序列化实现，，要求对象实现Serializable接口
     * @param o
     * @return Object
     * @throws IOException
     * @throws ClassNotFoundException
     * 同一声明,对象不同
     */
    public static Object deepCopy(Object o) throws IOException, ClassNotFoundException {      	
        return BytesToObject(ObjectToBytes(o));
    }      
    
    //通过ObjectOutputStream 写入对象 到  字节组输出流,返回字节组        序列化
    public static byte[] ObjectToBytes(Object o)throws IOException{
    	ByteArrayOutputStream bo = new ByteArrayOutputStream();
    	ObjectOutputStream  oo = new ObjectOutputStream(bo);
    	oo.writeObject(o);
    	byte[] byteArray = bo.toByteArray();
    	if(oo!=null){
    		oo.close();
    	}
    	return byteArray;
    }
    //通过ObjectInputStream  读取 ByteArrayInputStream中的字节组 ，返回对象         反序列化
    public static Object BytesToObject(byte[] byts)throws IOException, ClassNotFoundException{
        ByteArrayInputStream bi = new ByteArrayInputStream(byts);  
        ObjectInputStream oi = new ObjectInputStream(bi);
        Object readObject = oi.readObject();
    	if(oi!=null){
    		oi.close();
    	}        
        return readObject;
    }    
    
    public static String ObjectToBase64Str(Object o) throws Exception{    	
    	return Coder.encryptBASE64(ObjectToBytes(o));
    }
    public static Object Base64StrToObject(String base64str) throws ClassNotFoundException, IOException, Exception{
    	return  BytesToObject(Coder.decryptBASE64(base64str));
    }    
    
}
