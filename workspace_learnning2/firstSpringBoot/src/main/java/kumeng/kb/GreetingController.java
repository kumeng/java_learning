package kumeng.kb;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kumeng.nb3.vbc;

@RestController
@RequestMapping("/greet")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Resource
	dog d;
	@Resource
	vbc v1;	

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String string = d.toString();
		return new Greeting(counter.incrementAndGet(), String.format(template, name+string));
	}
	public void test(){
		System.out.println(d.toString());
		System.out.println(v1.toString());
	}
}