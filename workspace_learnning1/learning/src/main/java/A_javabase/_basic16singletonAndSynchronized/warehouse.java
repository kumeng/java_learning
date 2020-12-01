package A_javabase._basic16singletonAndSynchronized;

public class warehouse {
	private int amount;
	public warehouse(){
	}	
	public warehouse(int amont){
		this.amount = amont;
//		System.out.println(this);
	}
	public void addamount(int num){
		this.amount += num;
	}
	public synchronized void deleteamount(int num){
			this.amount -= num;	
	}	
	public int getamount(){
		return this.amount;
	}
}
