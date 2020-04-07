package javabase._basicYufa;

import org.junit.Test;

/**
 * for循环的中段
 * @author jiawen
 *
 */
public class circlefor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}	
	
	@Test
	public void te1(){		
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				System.out.println(i+" "+j);
				if(j==1){
					break;
				}
			}
		}
	}
	@Test
	public void te2(){
		a:
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				System.out.println(i+" "+j);
				if(j==1){
					break a;
				}
			}
		}
	}	
}
