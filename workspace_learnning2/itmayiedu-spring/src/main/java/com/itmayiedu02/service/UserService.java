
package com.itmayiedu02.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itmayiedu02.dao.UserDao;

import net.sf.cglib.proxy.Factory;

@Service
public class UserService {
	//
	@Autowired()
	@Qualifier("userDaoItmayiedu")
	private UserDao userDao;
	// @Resource(name = "userDaoItmayiedu")
	// private UserDao userDao;

	public void add() {
		System.out.println("UserService2.add()");
		// int i =1/0;
		userDao.add();
	}
}
