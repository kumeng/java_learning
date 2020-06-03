package javabase.designTemplate.creator.builder;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Director d = new Director();
		MobilePhone createMobilePhone = d.createMobilePhone(new IphoneZBuilder());
		MobilePhone createMobilePhone2 = d.createMobilePhone(new HuaWeiBuilder());
		System.out.println(createMobilePhone.toString());
		System.out.println(createMobilePhone2.toString());
	}

}
