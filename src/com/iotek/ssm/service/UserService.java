package com.iotek.ssm.service;

import com.iotek.ssm.entity.User;

public interface UserService {
	
	public User findUserByName(String uname);
	
	public User findUserByNameAndPsd(String uname,String password);
	
	public int addUser(User user);

	public int updateUser(User user);

	public User findUserById(int uid);
}
