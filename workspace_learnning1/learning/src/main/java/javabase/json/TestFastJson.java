package javabase.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javabase.beans.ManagerGogs;
import javabase.beans.dog;

/**
 * 常用的三种json框架 fastjson(阿里) ,gson(谷歌),jackson(springmvc自带)
 * 
 * json (JavaScript Object Notation)  JavaScript对象表示法
 * 
 * json有两种结构，对象和数组 
 * 1、对象 {key1:value1,key2:value2,...}  取值为   对象.key
 * 2、数组["java","python","IOS","JAVASCRIPT",...]  取值使用索引
 * 
 * 两种结构可以组合，构成很多复杂的数据结构
 * 
 * 
 *   <groupId>com.alibaba</groupId>
  <artifactId>fastjson</artifactId>
  <version>1.2.23</version>
 * 
 * @author Administrator
 */
public class TestFastJson {

	static String jsonStr = "{\"sites\":[{\"name\":\"蚂蚁课堂\",\"url\":\"www.itmayiedu.com\"},{\"name\":\"每特教育\",\"url\":\"http://meiteedu.com/\"}]}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFastJson t = new TestFastJson();
		t.parsestr(jsonStr);
		System.out.println();
		t.createjsonByBean();
		System.out.println();
		t.createjsonByJSONAPI();
	}
	
	
//	public static final Object parse(String text); 
	// 把JSON文本parse为JSONObject或者JSONArray 	

	public void parsestr(String str){
		JSONObject  obj = JSONObject.parseObject(str);
		JSONArray  arra = obj.getJSONArray("sites");
		for(Object obj2:arra){
			JSONObject d = (JSONObject) obj2;
			System.out.println("name:"+d.getString("name"));
			System.out.println("url:"+d.getString("url"));
		}
	}
	
	//通过对象产生json
	public void createjsonByBean(){
		dog d1 = new dog("雪拉","哈士奇",1);
		dog d2 = new dog("tomcat","柴犬",2);
		List<dog> arra = new ArrayList<dog>();
		arra.add(d1);
		arra.add(d2);
		ManagerGogs ma = new ManagerGogs();
		ma.setDogs(arra);
		ma.setName("中山宠物狗饲养基地");	
		System.out.println(JSON.toJSONString(ma));
	}
	
	//通过JSON对象封装 产生 json
	public void createjsonByJSONAPI(){
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "雪拉2");
		obj1.put("pz", "哈士奇");
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "tomcat2");
		obj2.put("pz", "柴犬");	
		JSONArray ar = new JSONArray();
		ar.add(obj1);
		ar.add(obj2);
		JSONObject root = new JSONObject();
		root.put("dogs", ar);
		root.put("name", "中山宠物狗饲养基地");
		System.out.println(root.toJSONString());
	}	
}
