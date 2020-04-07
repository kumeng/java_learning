package javabase.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel 从文件中读写数据
 * 
 * @author Administrator
 *
 */
public class TestFileChannel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile raf = new RandomAccessFile("c:\\jbpm4眼睛.~sql","rwd");
			FileChannel channel = raf.getChannel();
			//设定Buffer 的capacity属性，即buff对应内存的固定大小
			ByteBuffer  bb = ByteBuffer.allocate(48);
			//从文件通道FileChannel读取,写入到ByteBuffer
			int read = channel.read(bb);
			//循环读取
			while(read!=-1){
				System.out.println("\nread"+read);
				bb.flip();
				while(bb.hasRemaining()){
					//循环打印buffer内容    ，中文乱码了
					System.out.print((char)bb.get());
				}
				bb.clear();
				read = channel.read(bb);
			}
			
			//获取当前指针位置
			long position = channel.position();
			System.out.println("当前指针位置："+position);
			//或者关联文件大小
			long size = channel.size();
			System.out.println("关联文件大小："+size);
			//截取前   总大小一半数的字节,,关联文件后面剩余的数据会被删除
			//截取前   总大小一半数的字节,,关联文件后面剩余的数据会被删除
			//截取前   总大小一半数的字节,,关联文件后面剩余的数据会被删除
			channel.truncate(Math.round(size/2));
			position = channel.position();
			size = channel.size();
			System.out.println("截取指针位置："+position);
			System.out.println("截取后关联文件大小："+size);
			//指定指针位置
			channel.position(position+1);
			
			String newData="ttttttttttttttttt"+System.currentTimeMillis();
			ByteBuffer  buffer = ByteBuffer.allocate(48);
			buffer.clear();
			buffer.put(newData.getBytes());
			buffer.flip();
			while(buffer.hasRemaining()){
				//无法保证write()方法一次能向FileChannel写入多少字节，因此需要重复调用write()方法，
//				、直到Buffer中已经没有尚未写入通道的字节
				channel.write(buffer);
			}
			//FileChannel里的数据，一般会被系统缓存在内存中
			//同时将文件数据和元数据强制写到磁盘上
			channel.force(true);
			
			
			
			channel.close();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
