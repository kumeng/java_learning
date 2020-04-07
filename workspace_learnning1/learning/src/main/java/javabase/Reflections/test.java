package javabase.Reflections;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aClass a = new aClass();
		a.setname("324");
		String b = a.getname();
		System.out.println(b);
		test t = new test();
		t.newInstance2();
		
	}
	public void newInstance2(){
		try {
			aClass c = (aClass)Class.forName("Reflections.aClass").newInstance();
			c.setname("2ssss");
			System.out.println(c.getname());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
