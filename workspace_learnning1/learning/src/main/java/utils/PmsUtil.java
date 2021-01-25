package utils;


import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName PmsUtil
 * @Description 根据变量名 获取id
 * @Author zb
 * @Date 2018/7/23 16:20
 * @Version 1.0
 */
public class PmsUtil {

    public static <T> List<Long> getLongValue(List<T> dataList, String field){
        if(dataList==null||dataList.size()<=0){
            return new ArrayList<Long>();
        }
        return getLongValue(dataList, BeanUtils.findMethod(dataList.get(0).getClass(),"get"+upperCaseFirstLetter(field)));
    }

    public static <T> List<Long> getLongValue(List<T> dataList,Method fieldMethod){
        List<Long> list=new ArrayList<Long>();
        if(dataList==null||fieldMethod==null){
            return list;
        }
        for(T t:dataList){
            try{
                Object obj=fieldMethod.invoke(t);
                if(obj==null){
                    continue;
                }
                Long value=Long.valueOf(obj.toString());
                list.add(value);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Set<Long> set = new HashSet<Long>(list);
        list = new ArrayList<Long>(set);
        return list;
    }

    public static <T> List<String> getStringValue(List<T> dataList,String field){
        if(dataList==null||dataList.size()<=0){
            return new ArrayList<String>();
        }
        return getStringValue(dataList,BeanUtils.findMethod(dataList.get(0).getClass(),"get"+upperCaseFirstLetter(field)));
    }

    public static <T> List<String> getStringValue(List<T> dataList,Method fieldMethod){
        List<String> list=new ArrayList<String>();
        if(dataList==null||fieldMethod==null){
            return list;
        }
        for(T t:dataList){
            try{
                Object obj=fieldMethod.invoke(t);
                if(obj==null){
                    continue;
                }
                if(!StringUtils.isEmpty(obj.toString())){
                    list.add(obj.toString());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Set<String> set = new HashSet<String>(list);
        list = new ArrayList<String>(set);
        return list;
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String upperCaseFirstLetter(String str) {
        if(str!=null && str.length()>0) {
            return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
        } else {
            return str;
        }
    }    
    
    /**
     * List<String> 转换为    str1,str2,str3 格式的 字符串 
     * @param list
     * @return
     */
    public  static String listToStr(List<String> list){
    	if(CollectionUtils.isEmpty(list)){
    		return null;
    	}
    	StringBuffer sf = new StringBuffer();
    	int j = list.size();
    	for(int i=0;i<j;i++){
    		if(StringUtils.isEmpty(list.get(i))){
    			continue;
    		}
    		sf.append(list.get(i));
    		if(i<j-1){
    			sf.append(",");
    		}    		
    	}    	
    	return sf.toString();
    }
    /**
     * List<String> 转换为    str1,str2,str3 格式的 字符串 ,去重,去空值
     * @param list
     * @return
     */
    public  static String listToStrDistinct(List<String> list){
    	if(CollectionUtils.isEmpty(list)){
    		return null;
    	}
    	Set<String> sedistinct = new HashSet<String>(list);    	
    	return listToStr(new ArrayList<String>(sedistinct));
    }    
    
    /** 
     *  str1,str2,str3 格式的 字符串   转换为   List<String>
     * @param str
     * @return
     */
    public static List<String> strToList(String str){
    	if(StringUtils.isEmpty(str)){
    		return null;
    	}
    	List<String> list= new ArrayList<String>();
    	if(str.indexOf(",")<0){
    		list.add(str);    		
    	}else{
    		String[] split = str.split(",");
    		list = Arrays.asList(split);
    	}
    	return list;
    }
    
    /**
     * 判断  字符串 str是否存在于 列表list
     * false 不存在， true存在
     * @param list
     * @param str
     * @return
     */
    public  static boolean existsStrOflist(List<String> list,String str){
    	if(CollectionUtils.isEmpty(list)){
    		return false;
    	}else{
    		for(int i=0;i<list.size();i++){
    			String string = list.get(i);
    			if(string== null&& str==null){
    				return true;
    			}
    			if(string!=null&&string.equals(str)){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /**
     * list转为Set
     * @param list
     * @return
     */
    public static <T>  Set<T>  ListToSet(List<T> list){
    	Set<T> set = new HashSet<T>();
    	if(!CollectionUtils.isEmpty(list)){
        	Iterator<T> iterator = list.iterator();
        	while(iterator.hasNext()){
        		T t= iterator.next();
        		set.add(t);
        	}    		
    	}
    	return set;
    } 
    /**
     * 将list中的某个唯一值作为key,将list<T>对象转为Map<key,T>结构 
     * @param list
     * @param keyField
     * @return
     */
    public static <T> Map<Object,T>  ListToMap1(List<T> list,String keyField){
    	Map<Object,T> map = new HashMap<Object,T>();
    	if(!CollectionUtils.isEmpty(list)){
        	Iterator<T> iterator = list.iterator();
        	String upperCaseFirstLetter = upperCaseFirstLetter(keyField);
        	Method findMethod = BeanUtils.findMethod(list.get(0).getClass(),"get"+upperCaseFirstLetter);
        	try {
				while(iterator.hasNext()){
					T t= iterator.next();
				    Object obj=findMethod.invoke(t);
				    if(obj==null){
				        continue;
				    }
				    map.put(obj, t);
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    		
    	}
    	return map;
    }    
    /**
     * 将对象 t  放置到  set中，空对象或字符串"" 跳过 
     * @param set
     * @param t
     */
    public static <T> void setSomeExcludeNull(Set<T> set,T t){
    	if(t!=null){
    		if(t instanceof String && StringUtils.isEmpty(String.valueOf(t))){
    			return;
    		}
    		set.add(t);
    	}
    }
    /**
     * 比较两个字符串对象是否相等,,支持空字符处理
     * @param str1
     * @param str2
     * @return
     */
    public static boolean eqString(String str1,String str2){
    	boolean fl = true;
    	if(str1==null){
    		if(!StringUtils.isEmpty(str2)){
        		fl = fl & false;
    		}
    	}else{
    		fl = fl & str1.equals(str2);
    	}
    	return fl;
    }
    /**
     * 比较两个对象是否相等,支持空对象处理
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean eqObject(Object obj1,Object obj2){
    	boolean fl = true;
    	if(obj1==null){
    		if(obj2!=null){
        		fl = fl & false;
    		}
    	}else{
    		fl = fl & obj1.equals(obj2);
    	}
    	return fl;
    }    
    /**
     * 求集合交集，不影响原集合
     * @param s1
     * @param s2
     * @return
     */
    public static <T> Set<T>  SetIntersection(Set<T> s1,Set<T> s2){
    	Set<T>  result = new HashSet<T>();
    	result.addAll(s1);
    	//保留result 中 包含在 S2中的结果
    	result.retainAll(s2);  
    	return result;
    }
    
    /**
     * 求集合并集，不影响原集合
     * @param s1
     * @param s2
     * @return
     */
    public static <T> Set<T>  SetUion(Set<T> s1,Set<T> s2){
    	Set<T>  result = new HashSet<T>();
    	result.addAll(s1);
    	result.addAll(s2);  
    	return result;
    }
    
    /**
     * 求集合差集,s1中有，s2没有的
     * ，不影响原集合
     * @param s1
     * @param s2
     * @return
     */
    public static <T> Set<T>  SetDifference(Set<T> s1,Set<T> s2){
    	Set<T>  result = new HashSet<T>();
    	result.addAll(s1);
    	result.removeAll(s2);  
    	return result;
    }
	
    /**
     * 检查字符串，是否是金额，只由字符(0123456789-.)构成
     * @param str
     * @return
     */
    public static boolean checkStrIsNumber(String str){
		char[] charArray = str.toCharArray();
		for(short i=0;i<charArray.length;i++){
			char c = charArray[i];
			if((c>=48&&c<=57)||c==46||c==45){
				continue;
			}else{
				return false;
			}
		}
		return true;
	} 	

    /**
     * 检查某个参数对象，指定字段的值是否为空。为空的全部提示  (指定的列有一个为空都要提示)
     * @return
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     */
    public static void checkParam1(Object paramObj,String... columNames) throws Exception{
    	if(paramObj==null){
    		throw new IllegalArgumentException("参数为空");    		
    	}
    	Class<? extends Object> class1 = paramObj.getClass();
		StringBuffer sf = new StringBuffer();
		for(String colm:columNames){
			Field field = getDeclaredFieldCicle(class1,colm);
//			ApiModelProperty colComentannotation = field.getAnnotation(io.swagger.annotations.ApiModelProperty.class);				
//			if(colComentannotation!=null){
//				colm = colComentannotation.value();
//			}
			Object object = getProperty(paramObj,class1, field);
			String simpleName = field.getType().getSimpleName();
			if(java.lang.String.class.getSimpleName().equals(simpleName)&&StringUtils.isEmpty(String.valueOf(object))){
				sf.append(colm);
				sf.append("、");					
			}else if(null==object){
				sf.append(colm);
				sf.append("、");
			}			
		}
		if(sf.length()>1){
			sf.append("等字段不能为空!");
			throw new IllegalArgumentException(sf.toString());
		}
    	
    }
    
	private static Field getDeclaredFieldCicle(Class<? extends Object> class1, String colm) {
		// TODO Auto-generated method stub
		Field field = null;
    	try {
    		field = class1.getDeclaredField(colm);    		
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			return getDeclaredFieldCicle(class1.getSuperclass(),colm);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	return field;
	}

	/**
     * 检查某个参数对象，指定字段的值是否为空。为空的全部提示  (指定的列全部为空才提示)
     * @return
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     */
    public static void checkParam2(Object paramObj,String... columNames) throws Exception{
    	if(paramObj==null){
    		throw new IllegalArgumentException("参数为空");    		
    	}
    	Class<? extends Object> class1 = paramObj.getClass();
		//默认要抛空参数，有一个参数不为空就可以改为false
		boolean thrownullexce = true;
		StringBuffer sf = new StringBuffer();
		for(String colm:columNames){
			Field field = class1.getDeclaredField(colm);
//			ApiModelProperty colComentannotation = field.getAnnotation(io.swagger.annotations.ApiModelProperty.class);				
//			if(colComentannotation!=null){
//				colm = colComentannotation.value();
//			}
			Object object = getProperty(paramObj,class1, field);			
			String simpleName = field.getClass().getSimpleName();				
			if(java.lang.String.class.getSimpleName().equals(simpleName)&&!StringUtils.isEmpty(String.valueOf(object))){
				thrownullexce  = false;
			}else if (null!=object){
				thrownullexce  = false;
			}
			sf.append(colm);
			sf.append("、");				
		}
		if(thrownullexce){
			sf.append("等字段至少一个不能为空!");
			throw new IllegalArgumentException(sf.toString());
		}
    	
    }  
    
    
    //获取某个对象的某个列值
    public static Object getProperty(Object paramObj,Class<?> classtype, Field field) throws Exception{
		// TODO Auto-generated method stub
    	Object df = null;
		Method getMethod = classtype.getMethod(getMethodname_fromField(field));
		df = getMethod.invoke(paramObj);
		return df;
	}

	public  static  String capitalize(String name) { 
		if (name == null || name.length() == 0) { 
		    return name; 
	    }
		char[] chr = new char[2];
		chr = name.substring(0, 2).toCharArray();
		if( chr[0] >= 'a' && chr[0] <= 'z' && chr[1] >= 'a' && chr[1] <= 'z' )
		{
			return name.substring(0, 1).toUpperCase() + name.substring(1);
		}else{
			return name; 
		}
    }
    
    public static String  getMethodname_fromField(Field f){
		String readMethodName;
		String newcha =  capitalize(f.getName());
		
		if(null==f.getType()||f.getType()==boolean.class){
			 readMethodName = "is" +newcha ;
		}else{
			readMethodName = "get" +newcha;
		}	    	
		return readMethodName;
    }
    public static String  setMethodName_fromField(Field f){
    	return  "set"+capitalize(f.getName());
    }    
}
