package init;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class SpringInit {
	
	@PostConstruct
	public void   init1(){
		System.out.println("容器初始化");
	}
	@PreDestroy
	public void  destroy1(){
		System.out.println("predestroy");
	}
}
