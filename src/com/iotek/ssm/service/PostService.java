package com.iotek.ssm.service;

import com.iotek.ssm.entity.Post;

public interface PostService {
	public Post findPostByName(String pname,String dname);
}
