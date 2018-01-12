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

	@Override
	public Post findPostByPid(int pid) {
		return postDao.queryPostByPid(pid);
	}

	@Override
	public int addPost(Post post) {
		return postDao.insertPost(post);
	}

	@Override
	public int delPost(int pid) {
		return postDao.deletePost(pid);
	}

	@Override
	public int updatePost(Post post) {
		return postDao.updatePost(post);
	}

	@Override
	public Post findPostByPnameAndDid(String pname, int did) {
		return postDao.queryPostByPnameAndDid(pname, did);
	}

}
