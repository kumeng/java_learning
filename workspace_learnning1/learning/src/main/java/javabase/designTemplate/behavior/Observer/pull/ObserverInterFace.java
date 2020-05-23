package javabase.designTemplate.behavior.Observer.pull;


/**
 * 订阅者、观察者 抽象类
 * @author jiawen
 *
 */
public interface ObserverInterFace {
	//订阅一个发布者
	void attach(SubjectInterFace o);
	//移除一个发布者
	void detach(SubjectInterFace o);
	//更新发布者的内容
	void updateALL();
}
