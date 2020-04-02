package comontest;

public class druidEncrytPwd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		 String privatekey = com.alibaba.druid.filter.config.ConfigTools.encrypt("dfgdfgd");
			System.out.println(privatekey);
			privatekey=com.alibaba.druid.filter.config.ConfigTools.decrypt(privatekey);
			System.out.println(privatekey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
