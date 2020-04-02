package javabase.designTemplate.construction.proxy_static;

/**
 * 自定义的，静态代理类
 * @author Administrator
 *
 */
public class proxystatic  implements house{

	private house m1;
	private house m2;
	
	public proxystatic(maifang_x1 mf1,maifang_x2 mf2){
		m1 = mf1;
		m2 = mf2;
	}

	public void maifang() {
		// TODO Auto-generated method stub
		System.out.println("帮人买房，收留鱼香");
		m1.maifang();
		m2.maifang();
		System.out.println("买房完成");
	}
	
	
	
}
