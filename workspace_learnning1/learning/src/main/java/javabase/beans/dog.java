package javabase.beans;

import java.io.Serializable;

public class dog  implements Serializable{
	
	private String name;
	private int age;
	private String pz;
	
	public dog(){
		
	}
	public dog(String name1,String pz1,int age1){
		this.name = name1;
		this.pz = pz1;
		this.age = age1;
	}
	
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
	public String getPz() {
		return pz;
	}
	public void setPz(String pz) {
		this.pz = pz;
	}
	@Override
	public String toString() {
		return "dog [name=" + name + ", age=" + age + ", pz=" + pz + ", objt="+super.toString()+ "]";
	}
}
