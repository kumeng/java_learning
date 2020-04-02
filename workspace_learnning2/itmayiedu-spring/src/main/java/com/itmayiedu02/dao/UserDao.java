
package com.itmayiedu02.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoItmayiedu")
public class UserDao {

	public void add() {
		System.out.println("userDao2.add()");
	}

}
