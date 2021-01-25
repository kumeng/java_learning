package example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.service.inputService;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		inputService service = ac.getBean("inputServiceImpl",inputService.class);
		service.printSOme("电饭锅");
	}

}
