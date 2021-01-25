package kumeng.kb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="cat")
public class dog {
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private int age;
	
	public String toString(){
		return "名字:"+name +"年龄:"+ age;
	}
}
