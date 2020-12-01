package A_javabase._basic20designTemplate.behavior.Observer.Center.ipm;

import A_javabase._basic20designTemplate.behavior.Observer.Center.SubJectCenterSignleton;
import A_javabase._basic20designTemplate.behavior.Observer.Center.SubjectInterFace;

public class SubjectInterFaceIpm implements SubjectInterFace {

	public void putSubjectToCenter(String name) {
		// TODO Auto-generated method stub
		SubJectCenterSignleton singleton = SubJectCenterSignleton.getSingleton();
		singleton.putSubject(name, "覆盖快递费1");
	}

}
