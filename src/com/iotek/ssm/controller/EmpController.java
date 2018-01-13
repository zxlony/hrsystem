package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.entity.Post;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.EmpService;
import com.iotek.ssm.service.PostService;

@RequestMapping("emp")
@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private PostService postService;
	
	@RequestMapping("lookInfo")
	public String lookInfo(int uid,Model model) {
		Employee emp = empService.findEmpByUid(uid);
		model.addAttribute("emp", emp);
		return "showEmpInfo";
	}
	
	@RequestMapping("updateEmp")
	public String updateEmp(Employee emp) {
		empService.updateEmployee(emp);
		return "employee_index";
	}
	
	@RequestMapping("lookOnEmp")
	public String lookOnEmp(Model model) {
		List<Employee> emps = empService.findEmpByType(0);
		model.addAttribute("emps", emps);
		return "showAllOnEmp";
	}
	
	@RequestMapping("lookLeaveEmp")
	public String lookLeaveEmp(Model model) {
		List<Employee> emps = empService.findEmpByType(1);
		model.addAttribute("emps", emps);
		return "showAllLeaveEmp";
	}
	
	@RequestMapping("lookAemp")
	public String lookAemp(int uid,Model model) {
		Employee emp = empService.findEmpByUid(uid);
		model.addAttribute("emp", emp);
		return "showEmpInfo_admin";
	}
	
	@RequestMapping("transfer")
	public String transfer(int uid,Model model) {
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		model.addAttribute("uid", uid);
		return "forward:/emp/lookOnEmp";
	}
	
	@RequestMapping("staff")
	public String staff(int uid,String job,String post) {
		Employee emp = empService.findEmpByUid(uid);
		Post postClass = postService.findPostByName(post, job);
		String station = job+" "+post;
		emp.setPid(postClass.getPid());
		emp.setStation(station);
		empService.updateEmpPidAndStation(emp);
		return "redirect:/emp/lookOnEmp";
	}
}
