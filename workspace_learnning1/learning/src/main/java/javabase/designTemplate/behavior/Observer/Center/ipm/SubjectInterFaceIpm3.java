package javabase.designTemplate.behavior.Observer.Center.ipm;

import javabase.designTemplate.behavior.Observer.Center.SubJectCenterSignleton;
import javabase.designTemplate.behavior.Observer.Center.SubjectInterFace;

public class SubjectInterFaceIpm3 implements SubjectInterFace {

	public void putSubjectToCenter(String name) {
		// TODO Auto-generated method stub
		SubJectCenterSignleton singleton = SubJectCenterSignleton.getSingleton();
		singleton.putSubject(name, "覆盖快递费3");
	}

}
