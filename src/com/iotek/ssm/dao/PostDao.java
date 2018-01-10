package com.iotek.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.iotek.ssm.entity.Post;

public interface PostDao {
	public Post queryPostByName(@Param("pname")String pname, @Param("dname")String dname);
}
