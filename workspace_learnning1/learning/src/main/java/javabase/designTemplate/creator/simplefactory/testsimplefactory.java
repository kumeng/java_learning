package javabase.designTemplate.creator.simplefactory;

public class testsimplefactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car c1 = new carfactory1().createcar("宝马");
		c1.run();
	}

}
