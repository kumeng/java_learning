package scanerpac.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextEntity implements ApplicationContextAware {
	private static ApplicationContext ware = null;

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		ware = arg0;
	}

	private static ApplicationContext getApplicationContext() {
		return ware;
	}

	public static Object getBeans(String name) {
		return getApplicationContext().getBean(name);
	}

}
