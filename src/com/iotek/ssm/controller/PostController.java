package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.entity.Post;
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
	public String delPost(int pid, Model model) {
		List<Employee> emps = empService.findEmpByPid(pid);
		if(!emps.isEmpty()) {
			model.addAttribute("error", "该职位有员工，不能删除");
			return "forward:/dept/admQueryAll";
		}
		postService.delPost(pid);
		return "redirect:/dept/admQueryAll";
	}
	
	@RequestMapping("updatePost")
	public String updatePost(int pid,Model model) {
		List<Employee> emps = empService.findEmpByPid(pid);
		if(!emps.isEmpty()) {
			model.addAttribute("error", "该职位还有员工，不能修改");
			return "forward:/dept/admQueryAll";
		}
		Post post = postService.findPostByPid(pid);
		model.addAttribute("jobPost", post);
		return "forward:/dept/admQueryAll";
	}
	
	@RequestMapping("addPost")
	public String addPost(Post post,Model model) {
		Post post1 = postService.findPostByPnameAndDid(post.getPname(),post.getDid());
		if(post1!=null) {
			model.addAttribute("error", "增加的职位已存在");
			return "forward:/dept/admQueryAll";
		}
		postService.addPost(post);
		return "redirect:/dept/admQueryAll";
	}
	
	@RequestMapping("update")
	public String update(Post post,Model model) {
		Post post1 = postService.findPostByPnameAndDid(post.getPname(),post.getDid());
		if(post1!=null) {
			model.addAttribute("error", "更改后的职位已存在");
			return "forward:/dept/admQueryAll";
		}
		postService.updatePost(post);
		return "redirect:/dept/admQueryAll";
	}
	
}
