package example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;


import org.springframework.context.annotation.ComponentScan.Filter;

import kumeng.kb.GreetingController;
import kumeng.nb3.MyImportBeanDefinitionRegistrar;

@SpringBootApplication

@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan(basePackages={"kumeng.kb","example.restservice"},
		excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })

public class applicationBoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext run = SpringApplication.run(applicationBoot.class, args);
		GreetingController bean = run.getBean("greetingController",GreetingController.class);
		bean.test();
	}

}
