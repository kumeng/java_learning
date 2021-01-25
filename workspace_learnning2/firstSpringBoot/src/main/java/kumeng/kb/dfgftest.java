package kumeng.kb;

public class dfgftest {

	private static int version = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{//特殊处理方便以后版本改动
        	version = new Integer("9");
        	System.out.println(version>=9);
        	version = new Integer("8");
        	System.out.println(version>=9);
        	version = new Integer("9");
        	System.out.println(version>=9);      	
        }catch (Exception e){}
	}

}
