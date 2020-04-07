
package com.itmayiedu.service;

import com.itmayiedu.dao.UserDao;

public class UserService {

	private UserDao userDao;

	public void add() {
		System.out.println("UserService.add()");
		System.out.println("UserService.执行userDao.add()");
		userDao.add();
	}

	public UserDao getUserDao() {

		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		System.out.println("UserService.setUserDao()");
		this.userDao = userDao;
	}

}
