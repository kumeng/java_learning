package A_javabase._basic20designTemplate.creator.builder;

public interface PhoneBuilder {
	//
	void buildPhoneBody();
	void buildScreen();
	void buildBattery();	
	
	MobilePhone buildMobilePhone();
}
