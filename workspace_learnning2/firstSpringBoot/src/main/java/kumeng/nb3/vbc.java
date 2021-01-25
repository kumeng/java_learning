package kumeng.nb3;

import lombok.Getter;
import lombok.Setter;

public class vbc {
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private int age;
	
	public String toString(){
		return "名字3:"+name +"年龄3:"+ age;
	}
}
