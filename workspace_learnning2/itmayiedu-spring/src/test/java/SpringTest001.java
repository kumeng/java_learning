	import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.service.UserService;

public class SpringTest001 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
//		UserEntity user1 = (UserEntity) app.getBean("userEntity");
//		UserEntity user2 = (UserEntity) app.getBean("userEntity");
//		System.out.println(user1 == user2);
//		UserEntity  user3=(UserEntity) app.getBean("userEntity2");
//		System.out.println(user3.toString());
		UserService userService=	(UserService) app.getBean("userService");
		userService.add();
	}

}
