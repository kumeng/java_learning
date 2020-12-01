package A_javabase._basic7Annotaion.My_Annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 @Profile  
 * 
 * 一个接口
 * @author Administrator
 *
 */


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Profile {
	public int id() default -1;
	
	public enum GanderType{
		Male("男"),
		Female("女");
		private String ganderStr;
		GanderType(String arg0){
			this.ganderStr = arg0;
		}
		@Override
		public String toString(){
			return ganderStr;
		}
	}
	
	public GanderType  gander()  default GanderType.Male;
}
