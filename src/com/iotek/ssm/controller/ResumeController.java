package com.iotek.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.ResumeService;

@RequestMapping("resume")
@Controller
public class ResumeController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("lookResume")
	public String lookResume(int uid,HttpSession session,Model model) {
		Resume resume = resumeService.findResumeByUid(uid);
		List<Dept> depts = deptService.findAllDept();
		session.setAttribute("depts", depts);
		model.addAttribute("resume", resume);
		if(resume!=null) {
			String jobApplied = resume.getJobApplied();
			String[] split = jobApplied.split(" ");
			String deptStr = split[0];
			String postStr = split[1];
			model.addAttribute("deptStr", deptStr);
			model.addAttribute("postStr", postStr);
		}
		return "showMyResume";
	}
	
	@RequestMapping("insertResume")
	public String insertResume(Resume resume,String post) {
		String jobApplied1 = resume.getJobApplied()+" "+post;
		resume.setJobApplied(jobApplied1);
		resumeService.addResume(resume);
		return "user_index";
	}
	
	@RequestMapping("updateResume")
	public String updateResume(Resume resume,String post) {
		String jobApplied1 = resume.getJobApplied()+" "+post;
		resume.setJobApplied(jobApplied1);
		resumeService.updateResume(resume);
		return "user_index";
	}
}
