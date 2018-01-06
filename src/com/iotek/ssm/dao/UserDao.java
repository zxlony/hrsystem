package com.iotek.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.iotek.ssm.entity.User;

public interface UserDao {
	public User queryUserByName(String uname);
	
	public User queryUserByNameAndPsd(@Param("uname") String uname, @Param("password") String password);
	
	public int insertUser(User user);

	public int updateUser(User user);

	public User queryUserById(int uid);
}
