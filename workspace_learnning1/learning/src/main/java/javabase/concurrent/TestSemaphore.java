package javabase.concurrent;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void t1(){
		Semaphore se = new Semaphore(1);
		try {
			se.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		se.release();
	}

}
