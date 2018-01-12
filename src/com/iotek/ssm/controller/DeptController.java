package com.iotek.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.service.DeptService;

@RequestMapping("dept")
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("empQueryAll")
	public String empQueryAll(Model model) {
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		return "showAllDept_emp";
	}
	
	@RequestMapping("admQueryAll")
	public String admQueryAll(Model model) {
		List<Dept> depts = deptService.findAllDeptNoPost();
		List<Dept> depts1 = deptService.findAllDept();
		for (Dept d : depts) {
			for (Dept d1 : depts1) {
				if(d.getDid()==d1.getDid()) {
					d.setPosts(d1.getPosts());
				}
			}
		}
		model.addAttribute("depts", depts);
		return "showAllDept_admin";
	}
	
	@RequestMapping("delDept")
	public String delDept(int did,Model model) {
		Dept dept = deptService.findDeptAndPostByDid(did);
		if(dept!=null) {
			model.addAttribute("error", "该部门中有职位，不能删除");
			return "forward:/dept/admQueryAll";
		}
		deptService.delDept(did);
		return "redirect:/dept/admQueryAll";
	}
	
	@RequestMapping("updateDept")
	public String updateDept(int did,Model model) {
		Dept dept = deptService.findDeptAndPostByDid(did);
		if(dept!=null) {
			model.addAttribute("error", "该部门中有职位，不能修改");
			return "forward:/dept/admQueryAll";
		}
		Dept deptmt = deptService.findDeptByDid(did);
		model.addAttribute("deptmt", deptmt);
		return "forward:/dept/admQueryAll";
	}
	
	@RequestMapping("addDept")
	public String addDept(Dept dept,Model model) {
		Dept dept1 = deptService.findDeptByDname(dept.getDname());
		if(dept1!=null) {
			model.addAttribute("error", "增加的部门已存在");
			return "forward:/dept/admQueryAll";
		}
		deptService.addDept(dept);
		return "redirect:/dept/admQueryAll";
	}
	
	@RequestMapping("update")
	public String update(Dept dept,Model model) {
		Dept dept1 = deptService.findDeptByDname(dept.getDname());
		if(dept1!=null) {
			model.addAttribute("error", "更改后的部门已存在");
			return "forward:/dept/admQueryAll";
		}
		deptService.updateDept(dept);
		return "redirect:/dept/admQueryAll";
	}
}
