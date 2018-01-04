package com.iotek.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class Dept {
	private int did;
	private String dname;
	private List<Post> posts = new ArrayList<>();

	public Dept() {
		super();
	}

	public Dept(int did, String dname, List<Post> posts) {
		super();
		this.did = did;
		this.dname = dname;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + ", posts=" + posts + "]";
	}

}
