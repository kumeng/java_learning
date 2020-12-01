package A_javabase._basic4ReferenceType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BigdecimalCla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal numericalValue = new BigDecimal(10100.110);

//		BigdecimalCla.getLongLength(numericalValue);
		
//		  System.out.print(BigdecimalCla.muliply(new java.math.BigDecimal(1911.11),  
//				    new java.math.BigDecimal(10.12), 2, RoundingMode.HALF_UP));  
				
		dfghdfghgf(numericalValue);
	}
	private static void dfghdfghgf(BigDecimal numericalValue) {
		try {
			//四舍五入 RoundingMode.HALF_UP ,两位小数金额
			String bigDecimalToChinese = BigdecimalCla.BigDecimalToChinese(numericalValue);
			System.out.println(bigDecimalToChinese);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static int getLongLength(java.math.BigDecimal numericalValue) {  
		   
		  String sNumericalValue = numericalValue.toPlainString();  
		  String[] arrayValues = { "", "" };  
		   
		  if (!(sNumericalValue.indexOf(".") < 0)) {  
		   arrayValues = sNumericalValue.split("\\.");  
		  } else {  
		   arrayValues[0] = sNumericalValue;  
		  }  
		   
		  if (arrayValues[0].contains("-")) {  
		   arrayValues[0] = arrayValues[0].replaceAll("-", "");  
		  }  
		   
		  int intLength = arrayValues[0].length();  
		   
		  return intLength;  
		   
		 }  
		   
		 public static java.math.BigDecimal muliply(java.math.BigDecimal bg1, java.math.BigDecimal bg2, int scale,  
		   RoundingMode roundingMode) {  
		   
		  java.math.BigDecimal result = bg1.multiply(bg2);  
		  int intLength = getLongLength(result);  
		  MathContext context = new MathContext(intLength + scale, roundingMode);  
		  result = result.round(context);  
		   
		  return result;  
		   
		 }  
		   	
		 
		 /**
		  *  思路：
		  *  整数部分：参考 " 玖仟玖佰玖拾玖亿   玖仟玖佰玖拾玖万   玖仟玖佰玖拾玖圆" 格式
		  *  数字补齐，0123 4567 9999格式，然后分位三部分，进行计算 （9999个位组，4567万位组，0123亿位组）
		  *  
		  *  小数部分：参考   " 玖角玖分" 格式
		  *  
		  *  最小0，最大9999 9999 9999.99
		  * @param cl
		  * @return
		  * @throws Exception
		  */
    public  static String BigDecimalToChinese(BigDecimal cl) throws Exception{
    	//数字组
    	char[] a1 = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    	//单位组
    	char[] a2 = {'分','角','圆'};    	
    	//量级组
    	char[] a3 = {'仟','佰','拾','亿','仟','佰','拾','万','仟','佰','拾','\0'};    	
//    	String maxtemp = "玖仟玖佰玖拾玖亿   玖仟玖佰玖拾玖万   玖仟玖佰玖拾玖圆";
//    	9999 9999 9999  	
//		数字补齐，0123 4567 9999格式，然后分位三部分，进行计算 （9999个位组，4567万位组，0123亿位组）
    	String maxchange = "999999999999";
    	if(cl==null||cl.compareTo(BigDecimal.ZERO)<0){
    		throw new Exception("金额不能为空或者负数");
    	}
		//格式化数字为(n,2)格式的标准金额 ，（四舍无入）,没有小数位则补0  
		cl = cl.setScale(2, RoundingMode.HALF_UP);
		
    	//小于0.01 直接返回零
    	if(cl.compareTo(new BigDecimal("0.01"))<0){
    		StringBuffer sf2 = new StringBuffer();
    		sf2.append(a1[0]);
    		sf2.append(a2[2]);
    		return sf2.toString();
    	}    
    	//拆分为整数部分，和小数部分
    	String sNumericalValue = cl.toPlainString();        	
		String[] arrayValues = sNumericalValue.split("\\.");
		//整数部分
		String string0 = arrayValues[0];
		//小数部分
		String string1 = arrayValues[1];
		Long  lg0 = Long.parseLong(string0);
    	if(new  BigDecimal(string0).compareTo(new  BigDecimal(maxchange))>0){
    		throw new Exception("金额超出最大计算上限");
    	}		
		Long  lg1 = Long.parseLong(string1);
		//左边需要补0的数量
		int length = maxchange.length()-arrayValues[0].length();
		char[] cr0 = new char[length];
		for(int r=0;r<cr0.length;r++){
			cr0[r]='0';
		}
		string0 = new String(cr0)+string0; 
		   
		//最终整数部分的结果
		StringBuffer sf = new StringBuffer();
		//先处理整数的 亿位组
		int startindexY = 0;
		int bgY = BigDecimalToChineseCircle(a1, a3, string0, startindexY,sf,0);
		//再处理整数的 万位组
		int startindexW = string0.length()-8;
		int bgW = BigDecimalToChineseCircle(a1, a3, string0, startindexW,sf,bgY);
		//再处理整数的 个位组
		int startindex = string0.length()-4;
		int bgG = BigDecimalToChineseCircle(a1, a3, string0, startindex,sf,bgW);		
		
		if(lg0>0){
			sf.append(a2[2]);
		}
			
		//处理小数部分
		if(lg1>0 ){					
			char[] charArray = arrayValues[1].toCharArray();
			if(charArray[0]=='0' && charArray[1]=='0' && lg0==0){
				return String.valueOf(a1[0]+a2[2]);
			}
			if(charArray[0]>'0' ){
				String c = String.valueOf(charArray[0]);
				int x = Integer.parseInt(c);
				sf.append(a1[x]);
				sf.append(a2[1]);
			}			
			if(charArray[1]>'0' ){
				if(charArray[0]=='0' && lg0>0){
					sf.append(a1[0]);	
				}
				String c2 = String.valueOf(charArray[1]);
				int x2 = Integer.parseInt(c2);
				sf.append(a1[x2]);
				sf.append(a2[0]);					
			}
		}

    	return sf.toString();
    }
    /**
     * 
     * @param a1  常量，大写数字组
     * @param a3  常量，量级组
     * @param string0 补为"9999 9999 9999"格式的待处理数字转换的字符串
     * @param startindex  本方法，四位一组，进行处理，该参数为截取起始位置，常有0 4 8
     * @param sf    最终转换的大写数字字符串的buffer
     * @param beforeNumber  上一组，转换为的数字
     * @return 返回本组转换的数字
     */
		private static int BigDecimalToChineseCircle(char[] a1, char[] a3, String string0, int startindex,StringBuffer sf,int beforeNumber) {
			char[] cr = new char[20];	
			int j = cr.length;
			String substringG = string0.substring(startindex,startindex+4);
			int intG = Integer.parseInt(substringG);
			if(intG>0){
				//拼接整数部分
				char[] charArray = substringG.toCharArray();
				//从右至左，挨个处理，当前位=0时，是否需要补大写零的标志
				boolean hasnumlastalong  = false;
				//从右至左，挨个处理，对仟而言，只要佰位不为零则为true
				boolean hasnumlast = false;
				for(int i=charArray.length-1;i>-1;i--){
					if(hasnumlast){
//						hasnumlast表示当前位的地位有值，还需要当前位的高位有值, 即上一组数字大于0
						if(beforeNumber>0){
							hasnumlastalong = true;
						}		
						///,若上一组等于0，则当前位的至少前一位有值
						else if(beforeNumber==0){
							for(int z=0;z<i;z++){
								//字符在1-9直接，字符为0时，=48
								if(charArray[z]>48&&charArray[z]<58){
									hasnumlastalong = true;break;
								}								
							}
							hasnumlastalong =false;
						}else{
							hasnumlastalong =false;
						}
					}					
					if(i==3){
						j =j-1;
						cr[j]=(a3[startindex+3]);					
					}
					//数字转汉字
					String c = String.valueOf(charArray[i]);
					int x = Integer.parseInt(c);
					if(x==0){
						if(hasnumlastalong){
							j =j-1;
							cr[j]=(a1[x]);
							hasnumlastalong  = false;
						}
						//标记当前位置的值，做为下一轮前一位的数据标记
						hasnumlast=false;						
					}else{				
						if(i<3){
							j =j-1;
							cr[j]=a3[startindex+i];									
						}					
						j =j-1;					
						cr[j]=a1[x];
						
						//标记当前位置的值，做为下一轮前一位的数据标记
						hasnumlast=true;
					}					
				}			
			}
			
			for(int r=0;r<cr.length;r++){
				if(cr[r]=='\0'){
					continue;
				}
				sf.append(cr[r]);
			}
			return intG;
		}
    
}
