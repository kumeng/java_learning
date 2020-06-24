package javabase.designTemplate.behavior.Observer.Center.ipm;

import javabase.designTemplate.behavior.Observer.Center.SubJectCenterSignleton;

public class ObserverInterFacelpm implements javabase.designTemplate.behavior.Observer.Center.ObserverInterFace {

	public void updateFromCenter(String name) {
		// TODO Auto-generated method stub
		SubJectCenterSignleton singleton = SubJectCenterSignleton.getSingleton();
		String subject = singleton.getSubject(name);
		System.out.println("Observer1获得"+subject);
	}
}