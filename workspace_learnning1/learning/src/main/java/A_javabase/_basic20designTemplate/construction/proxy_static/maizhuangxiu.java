package A_javabase._basic20designTemplate.construction.proxy_static;

/**
 * 假如此类加载特别复杂
 * @author Administrator
 *买装修类，继承买房类
 */
public class maizhuangxiu extends maifang_x1 {

	public void maizhuangxiu() {
		// TODO Auto-generated method stub
		System.out.println("买装修服务!");
	}
	
	public maizhuangxiu(){
		//模拟复杂类加载
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
