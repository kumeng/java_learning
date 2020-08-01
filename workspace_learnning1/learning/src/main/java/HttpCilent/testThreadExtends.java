package HttpCilent;

public class testThreadExtends extends Thread {
	
	String url;
	String paramJSon;
	String sessionId;
	
    @Override
    public void run() {
    	super.run();
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
	public testThreadExtends(String url,String sessionId,String paramJSon){
		this.url = url;
		this.sessionId = sessionId;
		this.paramJSon = paramJSon;
	}	
}
