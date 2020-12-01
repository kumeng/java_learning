package testSpringApplication;

import scanerpac.ServiceInterface.PersonLogin;

public class PersonLoginImpl implements PersonLogin {

	public Integer dologin(String name, String pwd) {
		// TODO Auto-generated method stub
		this.printInfo();
		return null;
	}

	public void printInfo() {
		System.out.println("接口PersonLogin的实现类" + this.toString());
	}

}
