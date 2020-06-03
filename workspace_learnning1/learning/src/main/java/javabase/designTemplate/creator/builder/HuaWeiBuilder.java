package javabase.designTemplate.creator.builder;

public class HuaWeiBuilder implements PhoneBuilder {
	
	private MobilePhone mobilePhone=new MobilePhone();

	public void buildPhoneBody() {
		// TODO Auto-generated method stub
		mobilePhone.setPhoneBody("华为机身");
	}

	public void buildScreen() {
		// TODO Auto-generated method stub
		mobilePhone.setScreen("华为屏幕");
	}

	public void buildBattery() {
		// TODO Auto-generated method stub
		mobilePhone.setBattery("华为电池");
	}

	public MobilePhone buildMobilePhone() {
		// TODO Auto-generated method stub
		return mobilePhone;
	}

}
