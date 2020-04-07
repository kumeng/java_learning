package job;

/**
 * 
 * @author Administrator
 *
 */
public class MyCalculation  extends WorkRequest{

	public MyCalculation() {
		// TODO Auto-generated constructor stub
	}
	int n,m;
	public MyCalculation(int n,int m) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.n = n;
	}	
	public Object task(){
		return new Integer(n+m);
	}

}
