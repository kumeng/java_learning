package javabase.designTemplate.creator.builder;

public interface PhoneBuilder {
	//
	void buildPhoneBody();
	void buildScreen();
	void buildBattery();	
	
	MobilePhone buildMobilePhone();
}
