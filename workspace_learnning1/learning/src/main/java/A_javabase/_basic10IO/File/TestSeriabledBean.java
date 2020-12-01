package A_javabase._basic10IO.File;

import java.io.Serializable;

/**
 * 待实例化的对象
 * 序列化，必须实现接口Serializable，，可序列化的标记,
 * 该类的子类也可以序列化，无序额外实现接口Serializable
 * @author Administrator
 *
 */
public class TestSeriabledBean implements  Serializable  {
	
	/**
	 *建议显示声明 serialVersionUID，方便跨平台
	 */
	private static final long serialVersionUID = 3146247612083711926L;
	
	private String name;
	//transient  修饰 的属性   序列化会被忽略
	private transient int age;
	private String sex;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "TestSeriabledBean  "+super.toString()+" [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
