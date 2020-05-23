package javabase.designTemplate.behavior.Observer.publish.ipm;

import javabase.designTemplate.behavior.Observer.publish.ObserverInterFace;
import javabase.designTemplate.behavior.Observer.publish.SubjectInterFace;

public class Obsever1a implements ObserverInterFace {

	public void update(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Obsever1a,收到"+msg);
	}

}
