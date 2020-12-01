package A_javabase._basic21sunfa;

import java.util.Arrays;

public class paixu {
	public static void main(String[] arg0 ){
		System.out.println(arg0.length);
		int[] a1 = {3,456,6,45,2,123,0};
		System.out.println("冒泡排序");
		Bubble_Sort(a1);
		
		//java.util.Arrays  中自带的排序算法
		int[] b1 = {3,456,6,45,2,123,0};
		Arrays.sort(b1);
		System.out.println("java.util.Arrays  中自带的排序算法");
		printArray(b1);
		
		
		System.out.println("选择排序");
		Selection_Sort(a1);		
		
		System.out.println("插入排序");
		Insertion_Sort(a1);	
		
		System.out.println("希尔排序");
		Shell_Sort(a1);				
		
		System.out.println("归并排序");
		Merge_Sort(a1);			
		
		System.out.println("快速排序");
		Quick_Sort(a1);		
		
		
		System.out.println("堆排序");
		Heap_Sort(a1);		
		
		System.out.println("计数排序");
		Counting_Sort(a1);		
		
		System.out.println("桶排序");
		BucketSort(a1);	
		
		System.out.println("基数排序");
		RadixSort(a1);			
		
	}

	private static void Heap_Sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	private static void Counting_Sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	private static void RadixSort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	private static void BucketSort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	private static void Merge_Sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 从数列中挑出一个元素，称为 “基准”（pivot）；
重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）
。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。


	 * @param a1
	 */
	private static void Quick_Sort(int[] a1) {
		// TODO Auto-generated method stub		
		int pivot = a1[0];int temp;
		for(int i=1;i<a1.length;i++){
			if(a1[i]<pivot){
				temp = a1[i];
				
			}
		}
	}

	private static void Shell_Sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 从第一个元素开始，该元素可以认为已经被排序；
取出下一个元素，在已经排序的元素序列中从后向前扫描；
如果该元素（已排序）大于新元素，将该元素移到下一位置；
重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
将新元素插入到该位置后；
重复步骤2~5。

插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
	 * @param a1
	 */
	private static void Insertion_Sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素
	 * ，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
	 * 
	 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好
	 * 。唯一的好处可能就是不占用额外的内存空间了吧。
	 */
	private static void Selection_Sort(int[] a1) {
		// TODO Auto-generated method stub		
		int[] b1 = new int[a1.length];//结果数组
		int[] index = new int[a1.length];//已选排序元素索引位置 数组
		
		int tempmin=a1[0];	//临时值，指向未排序的最小值
		int indexmin =0;   //临时索引，指向未怕序的最小值的索引
		Selection_Sort_core(b1,a1,tempmin,indexmin,index);
	}
	

	private static void Selection_Sort_core(int[] b1,int[] a1,int tempmin,int indexmin,int[] index ) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<a1.length;i++){	
			for(int z:index){
				if(z==i){
					
				}
			}
			
			if(a1[i]<tempmin){
				tempmin = a1[i];
				indexmin = i;
			}
		}		
		b1[0]=tempmin;	
		Selection_Sort_core(b1,a1,tempmin,indexmin,index);
	}

	/**
	 * 每轮从未排序的第一个元素开始，与第二个元素比较，取大的元素放在第二个位置(交换位置或不变)，用第二个与第三个比较，如此循环。
	 * 每轮将最大的元素反正最后
	 * @param a1
	 */
	private static void Bubble_Sort(int[] a1) {
		int temp;
		for(int j=0;j<a1.length;j++){
			for(int i=0;i<a1.length-1-j;i++ ){
				if(a1[i]>a1[i+1]){
					temp = a1[i+1];
					a1[i+1] = a1[i];
					a1[i]=temp;
				}				
			}

		}
		
		printArray(a1);
	}

	
	
	
	
	private static void printArray(int[] a1) {
		for(int j=0;j<a1.length;j++){
			System.out.print(a1[j]+" ");
		}
		System.out.println();
	}
}
