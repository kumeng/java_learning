package A_javabase._basic9concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 特殊队列 BlockingQueue 
 * 特殊性：  为空时 ，取操作会被阻断进入等待；队列满时，存入操作会被阻断进入等待；不空时，唤醒取操作；不满时，唤醒存入操作。
 * 
 * 分四实现类 
 * ArrayBlockingQueue   ,大小固定，所以构造器必须带int参数，对象以FIFO（先入先出）排序
 * LinkedBlockingQueue  ，大小不定，构造器可带可不带int参数，不带时默认Integer.MAX_VALUE，同样FIFO顺序
 * PriorityBlockingQueue ,类似LinkedBlockingQueue,但不是FIFO排序，构造器所带的Comparator决定顺序
 * SynchronousQueue      :特殊 BlockingQueue 对其操作必须是放和取交替完成
 * 
 * @author Administrator
 *
 */
public class TestBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testArrayBlockingQueue(){
		BlockingQueue<Integer>  bq =new  ArrayBlockingQueue <Integer>(3);
		for(int i=0;i<6;i++){
			try {
				//存入队列，设置2秒超时
				boolean offer = bq.offer(i, 2, TimeUnit.SECONDS);

				System.out.println("是否成功存入:"+offer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<6;i++){
			try {
				//出队列，设置2秒超时
				Integer poll = bq.poll(2, TimeUnit.SECONDS);
				System.out.println("取出元素："+poll);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
