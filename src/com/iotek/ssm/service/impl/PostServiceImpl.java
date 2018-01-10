package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.PostDao;
import com.iotek.ssm.entity.Post;
import com.iotek.ssm.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;

	@Override
	public Post findPostByName(String pname, String dname) {
		return postDao.queryPostByName(pname, dname);
	}

}
