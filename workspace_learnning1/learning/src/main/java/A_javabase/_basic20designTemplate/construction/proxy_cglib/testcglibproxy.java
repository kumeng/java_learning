package A_javabase._basic20designTemplate.construction.proxy_cglib;

import A_javabase._basic20designTemplate.construction.proxy_static.maizhuangxiu;

public class testcglibproxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long p1 = System.currentTimeMillis();	
		proxycglib  p = new proxycglib();
		Long p2 = System.currentTimeMillis();
		maizhuangxiu h = (maizhuangxiu)p.getproxy(maizhuangxiu.class);		
		h.maifang();
		h.maizhuangxiu();
		Long p3 = System.currentTimeMillis();
		System.out.println("初始化时间:"+(p2-p1)/1000);
		System.out.println("执行时间:"+(p3-p2)/1000);			
	}

}
