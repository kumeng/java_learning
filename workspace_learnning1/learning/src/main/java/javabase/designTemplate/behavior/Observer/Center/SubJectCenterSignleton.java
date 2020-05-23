package javabase.designTemplate.behavior.Observer.Center;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;

/**
 * 单例对象（懒汉式，双重校验锁）
 * 
 * 存储所有的主题
 * @author jiawen
 *
 */
public class SubJectCenterSignleton {
	private static SubJectCenterSignleton ton;
	private SubJectCenterSignleton(){
		subjectMap = new HashMap<String, String>();
		allnames = new HashSet<String>();
	}
	public static SubJectCenterSignleton getSingleton(){
		if(ton==null){
			synchronized (SubJectCenterSignleton.class) {
				if(ton==null){
					ton = new SubJectCenterSignleton();
				}
			}
		}
		return ton;
	}
	
	private Map<String,String> subjectMap;
	private Set<String> allnames;
	
	public String getSubject(String key){
		if(subjectMap!=null&&subjectMap.containsKey(key)){
			return subjectMap.get(key);
		}
		return null;
	}
	public boolean putSubject(String key,String sf){
		if(subjectMap!=null&&!StringUtils.isEmpty(key)){
			subjectMap.put(key, sf);
			allnames.add(key);
			return true;
		}
		return false;
	}	
}
