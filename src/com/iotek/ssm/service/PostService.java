package com.iotek.ssm.service;

import com.iotek.ssm.entity.Post;

public interface PostService {
	public Post findPostByName(String pname, String dname);

	public Post findPostByPid(int pid);

	public int addPost(Post post);

	public int delPost(int pid);

	public int updatePost(Post post);

	public Post findPostByPnameAndDid(String pname, int did);
}
