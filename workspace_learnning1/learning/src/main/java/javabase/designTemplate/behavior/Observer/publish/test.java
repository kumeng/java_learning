package javabase.designTemplate.behavior.Observer.publish;

import javabase.designTemplate.behavior.Observer.publish.ipm.Obsever1a;
import javabase.designTemplate.behavior.Observer.publish.ipm.Obsever1b;
import javabase.designTemplate.behavior.Observer.publish.ipm.Subject1;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化订阅者、观察者
		Obsever1a oa1 = new Obsever1a();
		Obsever1b ob1 = new Obsever1b();
		
		//注册到发布者那里。
		Subject1 s1 = new Subject1();
		s1.attach(ob1);
		s1.attach(oa1);
		s1.notifyall("发布芯片嘻嘻嘻");
		s1.detach(ob1);
		s1.notifyall("发布芯片嘻嘻嘻2");
	}

}
