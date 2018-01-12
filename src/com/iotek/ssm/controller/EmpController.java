package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.EmpService;

@RequestMapping("emp")
@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
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
}
