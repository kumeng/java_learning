
package com.itmayiedu.entity;

public class UserEntity {
	public UserEntity() {
         System.out.println("实例化UserEntity：默认无参构造函数...");
	}
	public UserEntity(String userName,Integer age) {
        System.out.println("实例化UserEntity：有参构造函数 userName:"+userName+"---,age:"+age);
		this.userName=userName;
		this.age=age;

	}
	private String userName;
	private Integer age;

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public int getAge() {

		return age;
	}

	public void setAge(Integer age) {

		this.age = age;
	}
	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", age=" + age + "]";
	}
	
	

}
