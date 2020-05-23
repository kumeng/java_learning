package javabase.designTemplate.behavior.Observer.Center;


/**
 * 订阅者、观察者 抽象类
 * @author jiawen
 *
 */
public interface ObserverInterFace {	
	//从中介拉取 消息
	void updateFromCenter(String name);
}
