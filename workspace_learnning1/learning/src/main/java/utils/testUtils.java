package utils;

import org.junit.Test;

public class testUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CardUtil.isPhone("19180510329")); 
		
		String s = String.valueOf(null);
		System.out.println(s);
		System.out.println(s.equals(""));
		System.out.println(s.equals(null));
	}
	
	@Test
	public void te1(){
		System.out.println("421421199010104519".substring(6,10));
	}

}
