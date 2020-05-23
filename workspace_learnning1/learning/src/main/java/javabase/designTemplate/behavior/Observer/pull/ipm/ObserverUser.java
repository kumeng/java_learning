package javabase.designTemplate.behavior.Observer.pull.ipm;

import java.util.ArrayList;
import java.util.List;

import javabase.designTemplate.behavior.Observer.pull.ObserverInterFace;
import javabase.designTemplate.behavior.Observer.pull.SubjectInterFace;

public class ObserverUser implements ObserverInterFace {
	private List<SubjectInterFace> list = new ArrayList<SubjectInterFace>();

	public void attach(SubjectInterFace o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	public void detach(SubjectInterFace o) {
		// TODO Auto-generated method stub
		list.remove(o);
	}

	public void updateALL() {
		// TODO Auto-generated method stub
		for(SubjectInterFace s:list){
			System.out.println(s.publishMsg());
		}
	}

}
