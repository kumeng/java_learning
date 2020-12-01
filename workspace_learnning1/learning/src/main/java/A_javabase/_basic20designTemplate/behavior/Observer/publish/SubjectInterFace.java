package A_javabase._basic20designTemplate.behavior.Observer.publish;
/**
 * 发布者、被观察者   接口
 * @author jiawen
 *
 */
public interface SubjectInterFace {
	//增加一个订阅者、观察者
	void attach(ObserverInterFace o);
	//移除一个订阅者、观察者
	void detach(ObserverInterFace o);
	//发布消息给全部订阅者、观察者
	void notifyall(String msg);
}
