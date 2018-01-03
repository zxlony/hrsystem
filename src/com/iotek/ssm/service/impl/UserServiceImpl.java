package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.UserDao;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserByName(String uname) {
		return userDao.queryUserByName(uname);
	}

	@Override
	public User findUserByNameAndPsd(String uname, String password) {
		return userDao.queryUserByNameAndPsd(uname, password);
	}

	@Override
	public int addUser(User user) {
		return userDao.insertUser(user);
	}

}
