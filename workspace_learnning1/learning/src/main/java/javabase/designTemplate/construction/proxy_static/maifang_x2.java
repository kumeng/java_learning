package javabase.designTemplate.construction.proxy_static;

/**
 * 假如此类加载特别复杂
 * @author Administrator
 *
 */
public class maifang_x2 implements house {

	public void maifang() {
		// TODO Auto-generated method stub
		System.out.println("第x2人买房");
	}
	
	public maifang_x2(){
		//模拟复杂类加载
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
