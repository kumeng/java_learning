package javabase.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 使用Java提供管理线程的类 ExecutorService
 * 
 * 线程池作用：
第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
第三：提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，
还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。但是，要做到合理利用
线程池，必须对其实现原理了如指掌。

 * 
 */
public class aTestExecutorService {
	
	public static void main(String[] arg0){
		aTestExecutorService testExecutorService = new aTestExecutorService();
//		testExecutorService.ThreadPool1();
//		testExecutorService.ThreadPool2();
//		testExecutorService.ThreadPool3();
		testExecutorService.ThreadPool4();
	}
	

	public void ThreadPool1(){
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		for(int i=0;i<15;i++){
			threadImpelmentsPrintName threadPrintName10 = new threadImpelmentsPrintName();
			threadPrintName10.setCounts(1);
			newCachedThreadPool.execute(threadPrintName10);
		}		
		
	}

	public void ThreadPool2(){
		ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(2);
		//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待，以共享的无界队列方式运行这些线程
		
		for(int i=0;i<15;i++){
			threadImpelmentsPrintName threadPrintName10 = new threadImpelmentsPrintName();
			threadPrintName10.setCounts(1);
			newCachedThreadPool.execute(threadPrintName10);
		}			
		
	}	
//	定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
	

	public void ThreadPool3(){
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		//创建一个定长线程池，支持定时及周期性任务执行。  安排在 给定延迟后运行命令 或定期执行
		
		for(int i=0;i<15;i++){
			threadImpelmentsPrintName threadPrintName10 = new threadImpelmentsPrintName();
			threadPrintName10.setCounts(1);
			executorService.schedule(threadPrintName10,3,TimeUnit.SECONDS);
		}	
		//延迟3秒执行
	}	

	public void ThreadPool4(){
		ExecutorService newCachedThreadPool = Executors.newSingleThreadExecutor();
		//使用单个work线程的 Executor，以无界队列方式运行该线程
		//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
		for(int i=0;i<15;i++){
			threadImpelmentsPrintName threadPrintName10 = new threadImpelmentsPrintName();
			threadPrintName10.setCounts(1);
			newCachedThreadPool.execute(threadPrintName10);
		}	
		//相当于顺序执行各项任务
	}	
	
}
