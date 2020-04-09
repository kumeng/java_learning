package javabase._basicReferenceType;

/**
 * 内部类 
 * @author Administrator
 * 四种： 成员内部类 、局部内部类、静态内部类、匿名内部类
 */
public class InnerClass {
	private static String a = "InnerClass a";
	public static void main(String[] arg0){
		//调用成员内部类  
//		new InnerClass().new inner1().main(null);
		//调用静态内部类  
//		InnerClass.inner3.main(null);
		//调用匿名内部类  
//		new InnerClass().method4();
		
	}
	//成员内部类  
	private class inner1{
//		static String a = "inner1 a";  不允许静态变量
//		public static void main(String[] arg1){}  也不能存在静态方法	
		String a = "inner1 a";  //外部类中存在相同变量名		
		public  void main(String[] arg1){			
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(InnerClass.this.a); //调用外部类属性
			InnerClass.this.outerpringt(a);
		}
	}
	
	protected  void  method2(){
		System.out.println("outer method2 ");
		//局部内部类     待研究  goto   
		class inner2{
//			static String a = "inner2 a";  //不允许静态变量
			String a = "inner2 a";  //不允许静态变量
			public  void main2(String[] arg1){			
				System.out.println(a);
			}			
		}
	}
	
	//静态内部类   ，可定义静态 和 非静态 成员
	static class  inner3{
		static String a = "inner3 a";
		public static void main(String[] arg3){
			//调用成员内部类  
			new InnerClass().new inner1().main(null);
			
		}		
	}
	
	//方式四，展示匿名内部类，一种独特的局部内部类
	private  void  method4(){
		//匿名内部类定义规则 ,接口定义，匿名内部类实现接口  
		//InterFace  i = new InterFace(){}
		
		InterFace1 i = new InterFace1(){

			public void printInfo() {
				// TODO Auto-generated method stub
				System.out.println("这里是匿名内部类i的printInfo方法");
			}
			
		};
		i.printInfo();
		//不利用接口定义，用类定义  匿名内部类 
		new InnerClass(){
			//这里表面实例化InnerClass，实际创建了一个匿名内部类，继承父类InnerClass
			
			//这里会重写父类方法
			public void outerpringt(final String msg) {
				// TODO Auto-generated method stub
//				super(msg);//正常类继承，可以super（）调用父类，匿名类不可以
				System.out.println("这里是匿名内部类i2的printInfo方法 " +msg);
			}			
		}.outerpringt(" 测试匿名内部类 ");
			
		//相同匿名类，，但调用父类方法
		new InnerClass(){
			//这里表面实例化InnerClass，实际创建了一个匿名内部类，继承父类InnerClass
			
			public void outerpringt(final String msg) {
				// TODO Auto-generated method stub
//				super(msg);//正常类继承，可以super（）调用父类，匿名类不可以
				System.out.println("这里是匿名内部类i2的printInfo方法 " +msg);
			}			
		}.method2();	
		
		
		//注意  父类method2 的前缀修饰符为protected ,由此可知匿名内部类是 继承了 父类的子类实例
//		、、,匿名类内部会重写与父类方法名相同的方法
	}
	
	
	
	protected void outerpringt(final String msg){
		System.out.println("outer "+msg   );
	}
}
