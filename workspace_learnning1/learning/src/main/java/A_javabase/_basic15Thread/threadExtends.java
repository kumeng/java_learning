package A_javabase._basic15Thread;

public class threadExtends extends Thread{
	public void run() {
		super.run();
		// TODO Auto-generated method stub	
		System.out.println("extends Thread线程:"+Thread.currentThread().getName());
		subvalirynumber();
	}
	
	int a;   //成员变量，跟随对象存储在堆
	
	Integer b;	 
	
	public threadExtends(){
		
	}
	public threadExtends(int a1,Integer b1){
		System.out.println("其他方法内修改前的传入变量,a1="+a1+",b1="+b1);	
		a1--;
		b1--;
		System.out.println("其他方法内修改后的传入变量,a1="+a1+",b1="+b1);			
		a = a1;
		b = b1;
		System.out.println("线程内成员变量首次赋值,a="+a+",b="+b);
	}	
	public void subvalirynumber(){
		a--;
		b--;
		System.out.println("线程内成员变量减法运算后,a="+a+",b="+b);
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
}
