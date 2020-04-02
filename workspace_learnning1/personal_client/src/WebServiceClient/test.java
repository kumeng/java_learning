package WebServiceClient;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sdfgr");
		sayhello();
	}
	public static void sayhello(){
		ServiceHello  hello = new ServiceHelloService().getServiceHelloPort();
		String name = hello.getName("hello name1");
		System.out.println(name);		
	}

}
