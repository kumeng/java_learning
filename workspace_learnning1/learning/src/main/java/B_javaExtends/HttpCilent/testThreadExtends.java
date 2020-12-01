package B_javaExtends.HttpCilent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class testThreadExtends extends Thread {
	
	String url;
	String paramJSon;
	String sessionId;
	
	CyclicBarrier cb;
	
    @Override
    public void run() {
    	super.run();
    	    	
    	try {
    		System.out.println("线程"+Thread.currentThread().getId()+"到达，等待执行..");
			cb.await();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String result = HttpUtils.doJSONStringPost(url, sessionId, paramJSon);
    	System.out.println(result);
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParamJSon() {
		return paramJSon;
	}

	public void setParamJSon(String paramJSon) {
		this.paramJSon = paramJSon;
	}
	
	public testThreadExtends(){
		
	}
	public testThreadExtends(String url,String sessionId,String paramJSon,CyclicBarrier cb){
		this.url = url;
		this.sessionId = sessionId;
		this.paramJSon = paramJSon;
		this.cb =  cb;
	}	
}
