package javabase.ExtendsAndClassLoad;

public class FatherClass {
	public FatherClass(){
		System.out.println("父  s 无参构造函数");  //实例化才会执行  在动态块之后
	}
	static {
		System.out.println("父  s static块");  //声明就执行
	}
	{
		System.out.println("父  s  动态块"); //实例化才会执行
	}
	public static final String df = "df"; //静态常量
	
	private int age;
	private String name;
	public FatherClass(int age1,String name1){
		this.age = age1;
		this.name=name1;
		System.out.println("父  s 有参构造器r");
		this.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "FatherClass  [age=" + age + ", name=" + name + ", 静态常量df=" + df+ " hashcode="+this.hashCode()+"]";
	}
	
	public String toString_super(){
		return  super.toString();
	}
}

