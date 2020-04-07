package javabase.designTemplate.construction.proxy_cglib;

import javabase.designTemplate.construction.proxy_static.house;
import javabase.designTemplate.construction.proxy_static.maifang_x1;

public class testcglibproxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		proxycglib  p = new proxycglib();
		house h = (house)p.getproxy(maifang_x1.class);

		h.maifang();
	}

}
