package javabase.designTemplate.creator.builder;

public class MobilePhone {
	//屏幕
	private String screen;
	//机身
	private String phoneBody;
	//电池
	private String battery;
	
	
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getPhoneBody() {
		return phoneBody;
	}
	public void setPhoneBody(String phoneBody) {
		this.phoneBody = phoneBody;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	@Override
	public String toString() {
		return "MobilePhone [screen=" + screen + ", phoneBody=" + phoneBody + ", battery=" + battery + "]";
	}
	
}
