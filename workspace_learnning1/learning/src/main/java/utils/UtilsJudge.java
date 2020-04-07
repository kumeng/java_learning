package utils;

import java.util.List;

public class UtilsJudge {
	

	//判断某个值one，是否在列表list中,只判断值，额外支持null是否存在判断
	public static boolean OneExitList(Object one,List<? extends Object > list){
		boolean fl=false ;
		if(list==null||list.isEmpty()){
			fl = false;
		}else{
			
			for(Object oo:list){
				if(oo==null&&one==oo){
					fl= true;
					break;
				}else if(oo!=null&&oo.equals(one)){
					fl=  true;
					break;
				}else{
					fl=  false;
					break;
				}
			}
		}
		return fl;
			
	}
	
	//判断某个值one，是否在数组array中,只判断值，额外支持null是否存在判断
	public static boolean OneExitArray(Object one,Object[] array){
		boolean fl=false ;
		if(array==null||array.length<1){
			fl = false;
		}else{
			
			for(Object oo:array){
				if(oo==null&&one==oo){
					fl= true;
					break;
				}else if(oo!=null&&oo.equals(one)){
					fl=  true;
					break;
				}
			}
		}
		return fl;
			
	}	
}
