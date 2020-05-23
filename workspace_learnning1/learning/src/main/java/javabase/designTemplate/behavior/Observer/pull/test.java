package javabase.designTemplate.behavior.Observer.pull;

import javabase.designTemplate.behavior.Observer.pull.ipm.ObserverUser;
import javabase.designTemplate.behavior.Observer.pull.ipm.Subject1;
import javabase.designTemplate.behavior.Observer.pull.ipm.Subject2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化发布者
		Subject1 s1 = new Subject1();
		Subject2 s2 = new Subject2();
		//实例化订阅者，并选择订阅内容
		ObserverUser su  = new ObserverUser();
		su.attach(s1);
		System.out.println("第一次订阅");
		su.updateALL();
		su.attach(s2);
		su.detach(s1);
		System.out.println("第二次订阅");
		su.updateALL();		
	}
}
