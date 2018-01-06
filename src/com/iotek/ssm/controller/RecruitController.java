package com.iotek.ssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Recruit;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.RecruitService;

@RequestMapping("recruit")
@Controller
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("addRecruit")
	public String addRecruit(Model model) {
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		return "addRecruit";
	}
	
	@RequestMapping("insertRecruit")
	public String insertRecruit(Recruit recruit,String post) {
		String job1 = recruit.getJob()+" "+post;
		recruit.setJob(job1);
		recruit.setPubdate(new Date());
		recruitService.addRecruit(recruit);
		return "admin_index";
	}
	
	@RequestMapping("lookRecruit")
	public String lookRecruit(Model model) {
		List<Recruit> recruits = recruitService.findAllRecruit();
		model.addAttribute("recruits", recruits);
		return "showAllRecruit_admin";
	}
	
	@RequestMapping("userLookRecruit")
	public String userLookRecruit(Model model) {
		List<Recruit> recruits = recruitService.findAllRecruit();
		model.addAttribute("recruits", recruits);
		return "showAllRecruit_user";
	}
	
	@RequestMapping("delRecruit")
	public String delRecruit(int rid) {
		recruitService.delRecruit(rid);
		return "redirect:/recruit/lookRecruit";
	}
	
	@RequestMapping("updateRecruit")
	public String updateRecruit(int rid,Model model) {
		Recruit recruit = recruitService.findRecruitByRid(rid);
		model.addAttribute("recruit", recruit);
		String job = recruit.getJob();
		String[] split = job.split(" ");
		String deptStr = split[0];
		String postStr = split[1];
		model.addAttribute("deptStr", deptStr);
		model.addAttribute("postStr", postStr);
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		return "addRecruit";
	}
	
	@RequestMapping("update")
	public String update(Recruit recruit,String post) {
		String job1 = recruit.getJob()+" "+post;
		recruit.setJob(job1);
		recruitService.updateRecruit(recruit);
		return "admin_index";
	}
}
