package personal_service;

import java.util.Date;

import org.junit.Test;

import com.baomidou.mybatisplus.toolkit.StringUtils;

public class ttttttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ttttttt  t= new ttttttt();
		t.test1();
	}
	public void test1(){
		System.out.println("".intern());
	}
	@Test
	public void test2(){
		String sqlStr="__{0}__{1}";
		String[] params = {"dsgf","1232"};
		  String sqlArgsFill = StringUtils.sqlArgsFill(sqlStr, params);
		  System.out.println(sqlArgsFill);
	}

}
