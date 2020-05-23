package javabase.designTemplate.behavior.Observer.Center;

import javabase.designTemplate.behavior.Observer.Center.ipm.ObserverInterFacelpm;
import javabase.designTemplate.behavior.Observer.Center.ipm.ObserverInterFacelpm2;
import javabase.designTemplate.behavior.Observer.Center.ipm.ObserverInterFacelpm3;
import javabase.designTemplate.behavior.Observer.Center.ipm.SubjectInterFaceIpm;
import javabase.designTemplate.behavior.Observer.Center.ipm.SubjectInterFaceIpm2;
import javabase.designTemplate.behavior.Observer.Center.ipm.SubjectInterFaceIpm3;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先预定义全部主题的名字
		String n1 = "name1";String n2 = "name2";String n3 = "name3";
		
		//实例化发布者
		SubjectInterFaceIpm3 sm3 = new SubjectInterFaceIpm3();
		SubjectInterFaceIpm2 sm2 = new SubjectInterFaceIpm2();
		SubjectInterFaceIpm sm = new SubjectInterFaceIpm();	
		
		//发布到中介
		sm3.putSubjectToCenter(n3);sm2.putSubjectToCenter(n2);sm.putSubjectToCenter(n1);
		
		//实例化订阅者
		ObserverInterFacelpm om = new ObserverInterFacelpm();
		ObserverInterFacelpm2 om2 = new ObserverInterFacelpm2();
		ObserverInterFacelpm3 om3 = new ObserverInterFacelpm3();
		
		//订阅者，随便订
		om.updateFromCenter(n1);
		om.updateFromCenter(n2);
		om.updateFromCenter(n3);
		om2.updateFromCenter(n1);
		om2.updateFromCenter(n2);
		om3.updateFromCenter(n3);		
		
	}

}
