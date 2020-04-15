package javabase.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import javabase.beans.dog;

public class TestList {
	
	
	
	/**
	 * ArrayList
	 * 有序，不唯一
	 * 线型 列表
	 * 因为是连续的内存         。添加，移除，都从尾部开始，如果操作非尾部元素，那么将移动后面的元素，性能低下
	 * 可使用LinkedList提高操作效率
	 */
	@Test
	public void testArrayList(){

		List<dog> li = new ArrayList<dog>();
		dog d1 = new dog("d1","a1",1);
		dog d2 = new dog("d2","a2",2);
		dog d3 = new dog("d3","a3",3);
		
		//add 从列表末尾开始添加，起始索引为0
		li.add(d1);li.add(d2);
		li.add(2, d3);
		
		System.out.println("li.size():"+li.size());
		System.out.println("li第一个元素"+li.get(0).toString());
		
		dog d3_1 = new dog("d3","a3",3);
		System.out.println(li.contains(d3_1));
		System.out.println(li.contains(d3));

		System.out.println("移除前li.size():"+li.size());
		li.remove(1);//移除索引位置的元素。第二个元素
		li.remove(d1);//移除元素 ，从尾部匹配元素，只移除一个

		System.out.println("移除后li.size():"+li.size());
		System.out.println("移除后li第一个元素"+li.get(0).toString());

	}
	
	/**
	 * LinkedList
	 * 
	 */
	@Test
	public void testLinkedList(){
		LinkedList<dog> li2 = new LinkedList<dog>();
		dog d1 = new dog("d1","a1",1);
		dog d2 = new dog("d2","a2",2);
		dog d3 = new dog("d3","a3",3);
		li2.add(d1);
		li2.add(d2);
		li2.addFirst(d3);//直接添加到索引为0的位置
		
		System.out.println("li.size():"+li2.size());
		System.out.println("li第一个元素"+li2.get(0).toString());	
		
		li2.removeFirst();
		
		System.out.println("移除后 li.size():"+li2.size());
		System.out.println("移除后 li第一个元素"+li2.get(0).toString());			
		
	}
	/**
	 * 验证linkedList对首位元素操作  的效率 比 arrayList高
	 */
	@Test
	public void ArrayListAndlinkedList(){
		System.out.println("ArrayList:"+this.testArrayList1()); 
		System.out.println("LinkedList:"+this.testLinkedList1()); 
		
		System.out.println("LinkedList:"+this.testLinkedList1()); 			
		System.out.println("ArrayList:"+this.testArrayList1()); 
		

	
	}
	//一直向再首位元素添加
	private long testArrayList1(){
		long currentTimeMillis = System.currentTimeMillis();
		List<dog> li = new ArrayList<dog>();
		for(int i=0;i<10000;i++){
			dog d1 = new dog("d1","a1",i);
			li.add(0,d1);
		}		
		long currentTimeMillis2 = System.currentTimeMillis();
		return currentTimeMillis2-currentTimeMillis;
	}
	//一直向再首位元素添加
	private long testLinkedList1(){
		long currentTimeMillis = System.currentTimeMillis();		
		LinkedList<dog> li2 = new LinkedList<dog>();
		for(int i=0;i<10000;i++){
			dog d1 = new dog("d1","a1",i);
//			li2.addFirst(d1);
			li2.add(d1);
		}		
		long currentTimeMillis2 = System.currentTimeMillis();
		return currentTimeMillis2-currentTimeMillis;		
	}
	/**
	 * 测试移除list中的元素,移除后跳过一些遍历到的元素。
	 */
	@Test
	public void testremovelist(){
		int i=100;
		List<Integer> xlist = new ArrayList<Integer>(100);
		for(int x =0;x<i;x++){
			xlist.add(x);
		}
		System.out.println(xlist);
		for(int x =0;x<xlist.size();x++){
			xlist.remove(x);
//			x --;   //修复手段
		}
		System.out.println(xlist);
	}
	/**
	 * 测试移除list中的元素,移除后跳过一些遍历到的元素。
	 */
	@Test
	public void testremovelist2(){
		int i=100;
		List<Integer> xlist = new ArrayList<Integer>(100);
		for(int x =0;x<i;x++){
			xlist.add(x);
		}
		System.out.println(xlist);
		for(int x =0;x<xlist.size();x++){
			if(xlist.get(x)%3==1){
				xlist.remove(x);
				x --;   //修复手段				
			}
		}
		System.out.println(xlist);
	}	
	
}
