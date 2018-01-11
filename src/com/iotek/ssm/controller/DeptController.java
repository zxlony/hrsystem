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
}
