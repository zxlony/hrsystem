package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.EmpService;
import com.iotek.ssm.service.PostService;

@RequestMapping("post")
@Controller
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private EmpService empService;
	
	@RequestMapping("delPost")
	public String delPost(int pid) {
		List<Employee> emps = empService.findEmpByPid(pid);
	}
	
}
