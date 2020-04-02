package javabase.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DynamicLoadClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String pathname = DynamicLoadClass.class.getPackage().getName();
			System.out.println("当前路径:"+pathname);
			//通过Class.forName()方法动态加载
			Class<?> ca = Class.forName( pathname+".aClass");
			printCLassInfo(ca);
			
			ClassLoader  loader = ca.getClassLoader();
			System.out.println("类加载器"+loader);
			System.out.println("类加载器的父类"+loader.getParent());
			System.out.println("类加载器的父类的父类"+loader.getParent().getParent());
			//null，  由c语言所写，无法返回对象，是Java最顶级类加载器，bootstrap loader  
			
//			通过ClassLoader.loadClass()方法动态加载	
			System.out.println();
			ca = loader.loadClass(pathname+".aClass");
			ca = Class.forName( pathname+".aClass",false,loader);//等同的加载方式 
			
			printCLassInfo(ca);
			System.out.println();
			
			
/**
 * 三、类加载的一般过程
原理：双亲委托模式
1、寻找jre目录，寻找jvm.dll，并初始化JVM；
2、产生一个Bootstrap Loader（启动类加载器）；
3、Bootstrap Loader自动加载Extended Loader（标准扩展类加载器），并将其父Loader设为Bootstrap Loader。
4、Bootstrap Loader自动加载AppClass Loader（系统类加载器），并将其父Loader设为Extended Loader。
5、最后由AppClass Loader加载HelloWorld类。	

 三种加载方式
1、命令行启动应用时候由JVM初始化加载
2、通过Class.forName()方法动态加载      ，执行静态块
3、通过ClassLoader.loadClass()方法动态加载	，	不执行静态块
 */
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void printCLassInfo(Class<?> ca) {
		//			Field[] f = ca.getFields();
					Field[] f = ca.getDeclaredFields();
					Constructor[] c = ca.getConstructors();
					Method[] m = ca.getMethods();
					System.out.println("第一个字段,名"+f[0].getName());
					System.out.println("第一个构造器,名"+c[0].getName());
					System.out.println("第一个方法,名"+m[0].getName());
	}

}
