package A_javabase._basic20designTemplate.creator.builder;
/**
 * 导演类，组织构建顺序
 * @author jiawen
 *
 */
public class Director {
//	public void 
	public MobilePhone createMobilePhone(PhoneBuilder builder){
		builder.buildPhoneBody();
		builder.buildScreen();
		builder.buildBattery();
		return builder.buildMobilePhone();
	}
}
