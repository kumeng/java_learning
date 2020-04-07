package testSpringApplication;

import scanerpac.ServiceInterface.PersonLogin;
import scanerpac.entity.ApplicationContextEntity;


public class UsePersonLogin {
	
	private PersonLogin login;
	
	public void print(){
		if(login!=null){
			login.dologin("3", "4");
		}else{
			System.out.println("login is null   ...UsePersonLogin");
		}
	}

	public UsePersonLogin(){
		login = (PersonLoginImpl)ApplicationContextEntity.getBeans("personLoginImpl");
	}
}
