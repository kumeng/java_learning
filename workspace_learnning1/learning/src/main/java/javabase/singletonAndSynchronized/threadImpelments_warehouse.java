package javabase.singletonAndSynchronized;



public class threadImpelments_warehouse  implements Runnable  {
	
	public  void run() {
		// TODO Auto-generated method stub
		singletondemo1 singled = singletondemo1.getNewInstance();			
//		singled.addamount(2);
		singled.deleteamount(6);
		System.out.println("currentThread:"+Thread.currentThread().getName()+
				"\t"+"currentAmount:"+singled.getamount()+
				"\t"+singled);
	}

}
