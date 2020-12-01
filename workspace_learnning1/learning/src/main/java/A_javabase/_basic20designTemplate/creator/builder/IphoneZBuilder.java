package A_javabase._basic20designTemplate.creator.builder;

public class IphoneZBuilder implements PhoneBuilder {
	
	private MobilePhone mobilePhone=new MobilePhone();

	public void buildPhoneBody() {
		// TODO Auto-generated method stub
		mobilePhone.setPhoneBody("苹果机身");
	}

	public void buildScreen() {
		// TODO Auto-generated method stub
		mobilePhone.setScreen("苹果屏幕");
	}

	public void buildBattery() {
		// TODO Auto-generated method stub
		mobilePhone.setBattery("苹果电池");
	}

	public MobilePhone buildMobilePhone() {
		// TODO Auto-generated method stub
		return mobilePhone;
	}

}
