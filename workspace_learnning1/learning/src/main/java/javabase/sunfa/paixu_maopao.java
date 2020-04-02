package javabase.sunfa;

import java.util.Arrays;

public class paixu_maopao {
	public static void main(String[] arg0 ){
		System.out.println(arg0.length);
		int[] a1 = {3,456,6,45,2,123,0};
		int temp,temp1,temp2;
		for(int j=0;j<a1.length;j++){
			for(int i=0;i<a1.length-1-j;i++ ){
				temp1=a1[i];
				temp2=a1[i+1];
				if(a1[i]>a1[i+1]){
					temp = a1[i+1];
					a1[i+1] = a1[i];
					a1[i]=temp;
				}				
			}

		}
		
		for(int j=0;j<a1.length;j++){
			System.out.print(a1[j]+" ");
		}
		System.out.println();
		int[] b1 = {3,456,6,45,2,123,0};
		Arrays.sort(b1);
		for(int j=0;j<b1.length;j++){
			System.out.print(b1[j]+" ");
		}		
	}
}
