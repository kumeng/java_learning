package A_javabase._basic8Collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class testHashMapHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1",new Date());
		System.out.println("HashMap初始:"+map);
		Map<String,Object> map2 = new Hashtable<String,Object>();
		map2.put("1",new Date());
		System.out.println("Hashtable初始:"+map2);
		
		//用多线程，分局加一个元素2，移除一个元素2
		threadAddhash2 add  = new threadAddhash2(map);
		threadremovehash  remove = new threadremovehash(map);
		Thread  th_add = new Thread(add);
		Thread  th_rm = new Thread(remove);
		th_add.start();
		th_rm.start();
		
		//用多线程，分局加一个元素2，移除一个元素2
		threadAddhash2 add2  = new threadAddhash2(map2);
		threadremovehash  remove2 = new threadremovehash(map2);
		Thread  th_add2 = new Thread(add2);
		Thread  th_rm2 = new Thread(remove2);
		th_add2.start();
		th_rm2.start();				
		
	}
	
}

class threadAddhash2 implements Runnable{

	private Map<String,Object> map;
	threadAddhash2(Map<String,Object> map2){
		this.map = map2;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.map.put("2",new Date());
		System.out.println("添加2:"+map);
	}
	
}

class threadremovehash implements Runnable{

	private Map<String,Object> map;
	threadremovehash(Map<String,Object> map2){
		this.map = map2;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		this.map.remove("1");
		System.out.println("移除1:"+map);
	}
	
}
