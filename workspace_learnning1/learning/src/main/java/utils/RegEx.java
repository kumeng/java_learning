package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	public final static String regEx_Int_6 = "^\\d+$";
	public final static String regEx_Double_62 = "^(\\d+)(\\.\\d{1,2})?$";

	/**
	 * 
	 * @param str
	 *            待验证字符串
	 * @param regEx
	 *            验证表达式
	 * @return boolean
	 */
	public static boolean regMatcher(String str, String regEx) {
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}

}
