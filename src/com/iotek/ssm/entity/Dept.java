package com.iotek.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class Dept {
	private int did;
	private String dname;
	private int uid;
	private List<Post> posts = new ArrayList<>();

	public Dept() {
		super();
	}

	public Dept(int did, String dname, int uid, List<Post> posts) {
		super();
		this.did = did;
		this.dname = dname;
		this.uid = uid;
		this.posts = posts;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + ", uid=" + uid + ", posts=" + posts + "]";
	}

}
