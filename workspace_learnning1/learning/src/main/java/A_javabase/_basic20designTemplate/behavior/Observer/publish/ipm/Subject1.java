package A_javabase._basic20designTemplate.behavior.Observer.publish.ipm;

import java.util.ArrayList;
import java.util.List;

import A_javabase._basic20designTemplate.behavior.Observer.publish.ObserverInterFace;
import A_javabase._basic20designTemplate.behavior.Observer.publish.SubjectInterFace;

public class Subject1 implements SubjectInterFace {
	
	private List<ObserverInterFace> list = new ArrayList<ObserverInterFace>();

	public void attach(ObserverInterFace o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	public void detach(ObserverInterFace o) {
		// TODO Auto-generated method stub
		list.remove(o);
	}

	public void notifyall(String msg) {
		// TODO Auto-generated method stub
		for(ObserverInterFace o:list){
			o.update(msg);
		}
	}


}
