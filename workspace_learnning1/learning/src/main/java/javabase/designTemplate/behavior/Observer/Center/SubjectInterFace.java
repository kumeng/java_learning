package javabase.designTemplate.behavior.Observer.Center;
/**
 * 发布者、被观察者   接口
 * @author jiawen
 *
 */
public interface SubjectInterFace {
	//发布消息 到中介对象
	void putSubjectToCenter(String name);
}
