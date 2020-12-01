package A_javabase._basic11NIO.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

/**
 * 2个线程之间的单向数据连接。Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
 * 			-----------------------------------------	
 * 			|				Pipe					|	
 * ThreadA------->SinkChannel------->SourceChannel------>ThreadB
 * 			|										|			
 * 			-----------------------------------------
 * 
 * 写入数据到pipe的SinkChannel
 * 从  pipe的SourceChannel读数据
 * @author Administrator
 *
 */
public class testPipe {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPipe  mypipe = new MyPipe();
		testThreadA a = new testThreadA(mypipe);		
		testThreadB b = new testThreadB(mypipe);
		Thread th_a = new Thread(a);
		Thread th_b = new Thread(b);
		th_a.start();
		th_b.start();
	}


}

class  MyPipe {
	Pipe pipe = null;
	public MyPipe(){
		try {
			//打开管道
			pipe = Pipe.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//写入数据到pipe的SinkChannel
	public void writetoPipe() throws IOException{
		SinkChannel sink = pipe.sink();
		
		String newdata = "sdfdsfdsfdsfd"+System.currentTimeMillis();
		System.out.println("写入数据:"+newdata);
		ByteBuffer  buff = ByteBuffer.allocate(58);
		buff.clear();
		buff.put(newdata.getBytes());
		buff.flip();
		while(buff.hasRemaining()){
			sink.write(buff);
		}
		sink.close();
	}
	//从  pipe的SourceChannel读数据
	public ByteBuffer readFromPipe() throws IOException{
		SourceChannel source = pipe.source();
		ByteBuffer  buff = ByteBuffer.allocate(58);
		//read=读取到的字节数
		int read = source.read(buff);
		System.out.println("从管道中读取字节数："+read);
		source.close();
		return buff;
	}
}

class testThreadA implements Runnable{
	MyPipe  mypipe;
	public testThreadA(MyPipe  mypipe2){
		mypipe = mypipe2;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("testThreadA写入数据"+Thread.currentThread().getName());
			mypipe.writetoPipe();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class testThreadB implements Runnable{
	MyPipe  mypipe;
	public testThreadB(MyPipe  mypipe2){
		mypipe = mypipe2;
	}	
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("testThreadB读出数据"+Thread.currentThread().getName());
			ByteBuffer readFromPipe = mypipe.readFromPipe();
			readFromPipe.flip();
			while(readFromPipe.hasRemaining()){
				System.out.print((char)readFromPipe.get());
			}
			readFromPipe.clear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
