
package javabase.jvm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author jiawen
 * HotSpot虚拟机    sun公司
 * 
 * JVM虚拟机的默认内存分配情况
 * 最大可用内存,-Xmx  默认大约实际机器物理内存的1/4;  虚拟机设置参数  -Xmx300m
 * 虚拟机设置300m 实际可用最大内存267m
 * 
 * 其中老年代，默认最大可用    约等于 最大内存 的  2/3  
 * 剩下的1/3 原空间占用3.5m，新生代占用剩下的
 * 
 * 当老年代占用超出 最大内存 的  2/3 时，会扩展到 -Xmx值的2/3,再超出该值(即使新生代依然有空间可用)，就会抛OOM  堆内存溢出，java.lang.OutOfMemoryError: Java heap space 
 * 
 * 其他vm参数说明
 * -XX:+printGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError  生成堆内存镜像分析文件
 * 
 * 
 * -XX:+UseSerialGC    使用串行回收器进行回收
 * -XX:+UseParNewGC    Parallel是并行的意思  ParNew收集器是Serial收集器的多线程版本，
 * 使用这个参数后会在新生代进行并行回收，老年代仍旧使用串行回收。新生代S区任然使用复制算法。
 * 打印GC详情时ParNew标识着使用了ParNewGC回收器。默认关闭。
 * 
 * 操作系统是多核CPU上效果明显，单核CPU建议使用串行回收器。
 * 
 * -XX:+UseParallelGC  
 * -XX:+UseParallelOldGC  新生代和老年代都使用并行收集器。打印出的GC会带PSYoungGen、ParOldGen关键字 
 */
public class JvmInfoDemo{
	///-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
	//-Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=2
	
	//堆溢出错误时，对jvm内存进行快照导出
	////-Xms1m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
		
	
	public static void main(String[] args) throws InterruptedException {
		jvmInfo();

		
		System.out.println("最小运行条件下");
		System.out.println("老年代内存total:"+toM(173568*1024)+"M");
		System.out.println("新生代内存total:"+toM((75776)*1024)+"M");
		System.out.println("原空间占用:"+toM((3576)*1024)+"M");
		
		//多少k
		int num = 204700;
		userMemory3(num);
		System.out.println("分配了"+toM(num*1024)+"M内存");
		jvmInfo();
		System.out.println("老年代内存total:"+toM(204700*1024)+"M");
		System.out.println("新生代内存total:"+toM((75776)*1024)+"M");
		System.out.println("原空间占用:"+toM((3576)*1024)+"M");
	}
	private static void userMemory1(int num){
		List<Object> listObject = new ArrayList<Object>();
		for (int i = 0; i < num; i++) {
			listObject.add(new byte[1024]);
		}	
	}
	private static void userMemory2(int num){
		byte[] bytes02 = new byte[num*1024];
	}
	private static void userMemory3(int num){
		Map<byte[],byte[]> map  = new HashMap<byte[],byte[]>();
		map.put(new byte[1], new byte[num*1024]);
	}		

	static private String toM(long maxMemory) {
		float num = (float) maxMemory / (1024 * 1024);
		DecimalFormat df = new DecimalFormat("0.00");// 格式化小数
		String s = df.format(num);// 返回的是String类型
		return s;
	}

	public static void jvmInfo() {
		// 最大内存配置信息
		long maxMemory = Runtime.getRuntime().maxMemory();
		System.out.println("最大可用内存：maxMemory:" + maxMemory + "," + toM(maxMemory) + "M");
		// 当前空闲内存,意义不大。可以忽略
//		long freeMemory = Runtime.getRuntime().freeMemory();
//		System.out.println("freeMemory:" + freeMemory + "," + toM(freeMemory) + "M");
		//已使用内存
		long totalMemory = Runtime.getRuntime().totalMemory();
		System.out.println("totalMemory:" + totalMemory + "," + toM(totalMemory) + "M");
	}
}
