package A_javabase._basic20designTemplate.behavior.Observer.publish.ipm;

import A_javabase._basic20designTemplate.behavior.Observer.publish.ObserverInterFace;
import A_javabase._basic20designTemplate.behavior.Observer.publish.SubjectInterFace;

public class Obsever1b implements ObserverInterFace {

	public void update(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Obsever1b,收到"+msg);
	}
}
