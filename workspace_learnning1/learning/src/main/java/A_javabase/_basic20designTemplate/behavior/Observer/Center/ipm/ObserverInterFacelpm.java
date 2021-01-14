package A_javabase._basic20designTemplate.behavior.Observer.Center.ipm;

import A_javabase._basic20designTemplate.behavior.Observer.Center.ObserverInterFace;
import A_javabase._basic20designTemplate.behavior.Observer.Center.SubJectCenterSignleton;

public class ObserverInterFacelpm implements ObserverInterFace {

	public void updateFromCenter(String name) {
		// TODO Auto-generated method stub
		SubJectCenterSignleton singleton = SubJectCenterSignleton.getSingleton();
		String subject = singleton.getSubject(name);
		System.out.println("Observer1获得"+subject);
	}
}