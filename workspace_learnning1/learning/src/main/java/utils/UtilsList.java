package utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import scanerpac.entity.sys.Seqs;

public class UtilsList {

	/**
	 * 例如List<Bean>,获取其中所有Bean中 名为ColumnName 的值，并作为一个String返回
	 * 
	 * @param li
	 * @param ColumnName
	 * @return
	 */
	public String ColumnOfListToStr(List<?> li, String ColumnName) throws Exception {
		String str = "";
		if (li == null || li.isEmpty()) {
			return null;
		} else {
			for (Object obj : li) {
				Class<?> classtype = obj.getClass();
				Field fi = classtype.getDeclaredField(ColumnName);// 可以访问 public
																	// protected
																	// default(不写即more)
																	// private
																	// 字段
				// Field fi = classtype.getField(ColumnName);//只能访问public 字段
				Method logMethod = classtype.getMethod(CopyObject4.getMethodname_fromField(fi));
				str = str + String.valueOf(logMethod.invoke(obj));
			}
			return str;
		}

	}

	public Object getFistFromList(List<?> selectByExample) {
		if (selectByExample == null || selectByExample.isEmpty()) {
			return null;
		} else {
			return selectByExample.get(0);
		}
	}

	@Test
	public void test() {
		List<computer> list = new ArrayList<computer>();
		computer c = new computer();
		c.setMsgFdf("12");
		c.setMsgStr("3");
		list.add(c);
		computer c1 = new computer();
		c1.setMsgFdf("120");
		c1.setMsgStr("30");
		list.add(c1);
		String columnOfListToStr;
		try {
			columnOfListToStr = ColumnOfListToStr(list, "msgStr");
			System.out.println(columnOfListToStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * public String msgFdf; private String msgStr;
	 */

	@Test
	public void test2() {

		try {
			computer c = new computer();
			c.setMsgFdf("12");
			c.setMsgStr("3");
			System.out.println(Coder.encryptMD5(c.toString()));
			computer c1 = new computer();
			c1.setMsgFdf("120");
			c1.setMsgStr("30");
			System.out.println(Coder.encryptMD5(c1.toString()));
			c1.setMsgFdf("12");
			c1.setMsgStr("3");
			System.out.println(Coder.encryptMD5(c1.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test3() {
		computer c1 = null;
		Set<computer> set = new HashSet<computer>();
		List<computer> list = new ArrayList<computer>();
		Map<String, Set<computer>> map = new HashMap<String, Set<computer>>();

		c1 = new computer();
		c1.setMsgFdf("12");
		c1.setMsgStr("3");

		set.add(c1);
		list.add(c1);
		map.put("1", set);

		c1 = new computer();
		c1.setMsgFdf("22");
		c1.setMsgStr("23");

		set = new HashSet<computer>();
		set.add(c1);
		list.add(c1);
		map.put("2", set);

		System.out.println(set.toString());
		System.out.println(list.toString());
		System.out.println(map.toString());

		set = new HashSet<computer>();
		set = map.get("2");
		c1 = new computer();
		c1.setMsgFdf("32");
		c1.setMsgStr("33");
		set.add(c1);
		map.put("3", set);
		System.out.println("s=========================================================");
		System.out.println(set.toString());
		System.out.println(map.toString());
	}

	@Test
	public void test5() {
		StringBuffer sr = new StringBuffer();
		sr.setLength(0);
		int i = 0;
		while (i++ < 20000) {
			sr.append("噗");
		}
		System.out.println(sr.length());
		System.out.println(sr.toString());
	}

	@Test
	public void test6() {
		String s = (String) null;
		Seqs se = (Seqs) null;
	}

}
