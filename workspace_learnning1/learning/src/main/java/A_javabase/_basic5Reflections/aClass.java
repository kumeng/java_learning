package A_javabase._basic5Reflections;

public class aClass {
	private String name;
	static{
		System.out.println("i am a static statement");
	}
	{
		System.out.println(" a statement");		
	}
	public aClass(){
		System.out.println("this is construct ,no name");
	}
	public aClass(String name2){
		this.name = name2;
		System.out.println("this is construct,name is"+name2);
	}
	public void setname(String name2){
		this.name = name2;
		System.out.println("this is setname,name is "+name2);
	}
	public String getname(){
		System.out.println("this is getname");
		return this.name;
	}
	
}
