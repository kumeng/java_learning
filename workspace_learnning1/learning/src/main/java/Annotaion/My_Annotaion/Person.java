package Annotaion.My_Annotaion;

import Annotaion.My_Annotaion.Profile.GanderType;

/**
 * 使用 @Profile注解
 * @author Administrator
 *
 */
public class Person {
	@Profile(id=5,gander=GanderType.Female)
	private String gander;

	public String getGander() {
		return gander;
	}

	public void setGander(String gander) {
		this.gander = gander;
	}
	
	
}
