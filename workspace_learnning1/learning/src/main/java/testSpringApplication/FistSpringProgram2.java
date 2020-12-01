package testSpringApplication;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import scanerpac.ServiceInterface.PersonLogin;

@ContextConfiguration(locations = { "classpath:springbasic/SpringMVC.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class FistSpringProgram2 {

	@Resource(name = "animalServicecat")
	private AnimalsServices service;
	@Resource(name = "animalServicedog")
	private AnimalsServices service2;

	@Resource(name = "personLoginImpl")
	private PersonLogin login;

	@Test
	public void testSpringJdbcDao() {

		service.run();
		service2.run();

		UsePersonLogin use = new UsePersonLogin();
		use.print();

		// login.dologin("2","1");

	}

	public AnimalsServices getService() {
		return service;
	}

	public void setService(AnimalsServices service) {
		this.service = service;
	}

	public AnimalsServices getService2() {
		return service2;
	}

	public void setService2(AnimalsServices service2) {
		this.service2 = service2;
	}

	public PersonLogin getLogin() {
		return login;
	}

	public void setLogin(PersonLogin login) {
		this.login = login;
	}

}
