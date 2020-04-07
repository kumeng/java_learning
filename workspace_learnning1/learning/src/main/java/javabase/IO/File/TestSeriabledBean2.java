package javabase.IO.File;

public class TestSeriabledBean2 extends TestSeriabledBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2457660980117805131L;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TestSeriabledBean2 "+super.toString()+" [type=" + type + "]";
	}
	
}
