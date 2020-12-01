package A_javabase._basic8Collections;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void test1(){
		Set<String> s1 = new HashSet<String>();
		s1.add("a");
		s1.add("ab");
		s1.add("b");
		s1.add("c");
		s1.add("abc");
		Set<String> s2 = new HashSet<String>();
		s2.add("ab");
		s2.add("b");	
		s2.add("d");	
		s1.removeAll(s2);
		System.out.println(s1);
		
	}
}
