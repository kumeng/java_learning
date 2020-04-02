package javabase.ExtendsAndClassLoad;

public class SubClass extends FatherClass {
	String color;

	static{
		System.out.println("子  s static块");  //声明就执行
	}
	{
		System.out.println("子  s  动态块"); //实例化才会执行
	}
	public SubClass(int age1, String name1,String color1) {
		super(age1, name1);
		this.color = color1;
		System.out.println("子  s 有参构造器r");
		this.toString();
	}
	public SubClass() {
		// TODO Auto-generated constructor stub
		System.out.println("子 s 无参构造函数");  //实例化才会执行  在动态块之后
	}
	@Override
	public String toString() {
		return "SubClass [color=" + color+" hashcode="+this.hashCode()+"   "+super.toString() + "]";
	}

}
