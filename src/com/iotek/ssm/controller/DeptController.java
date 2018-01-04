package com.iotek.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.service.DeptService;

@RequestMapping("dept")
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	
}
