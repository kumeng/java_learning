package A_javabase._basic20designTemplate.construction.proxy_static;

public class testproxys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test01();
		test02();
	}




	/**
	 * 不用代理，x1,x2买房
第x1人买房
第x2人买房
初始化时间:4
执行时间:0
没有实现延迟加载
	 */
	private static void test01() {
		// TODO Auto-generated method stub
		Long p1 = System.currentTimeMillis();		
		house  h1 = new maifang_x1();
		maizhuangxiu  h2 = new maizhuangxiu();
		Long p2 = System.currentTimeMillis();
		h1.maifang();
		h2.maizhuangxiu();
		Long p3 = System.currentTimeMillis();
		System.out.println("初始化时间:"+(p2-p1)/1000);
		System.out.println("执行时间:"+(p3-p2)/1000);
	}
	
	/**
	 * 使用静态代理
	 * 
帮人买房，收留鱼香
第x1人买房
第x2人买房
买房完成
初始化时间:4
执行时间:0
没有实现延迟加载
	 * 
	 */
	
	private static void test02() {
		// TODO Auto-generated method stub
		Long p1 = System.currentTimeMillis();		
		house h = new proxystatic(new maifang_x1(),new maizhuangxiu());
		Long p2 = System.currentTimeMillis();
		h.maifang();
		Long p3 = System.currentTimeMillis();
		System.out.println("初始化时间:"+(p2-p1)/1000);
		System.out.println("执行时间:"+(p3-p2)/1000);		
	}	

}
