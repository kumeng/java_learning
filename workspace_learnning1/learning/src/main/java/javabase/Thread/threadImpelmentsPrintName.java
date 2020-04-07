package javabase.Thread;

public class threadImpelmentsPrintName implements Runnable {
	private int counts = -1;
	public void run() {
		for(int i=0;i<counts;i++){
			System.out.println("threadImpelmentsPrintName: "+i+",name: "+Thread.currentThread().getName()
					+ ",id: "+Thread.currentThread().getId());		
		}
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
}
