package com.iotek.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Apply;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.ApplyService;
import com.iotek.ssm.service.ResumeService;
import com.iotek.ssm.service.UserService;

@RequestMapping("apply")
@Controller
public class ApplyController {

	@Autowired
	private ApplyService applyService;
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("lookApply")
	public String lookApply(Model model) {
		List<Apply> Applies = applyService.findAllApply();
		model.addAttribute("Applies", Applies);
		return "showAllApplies";
	}
	
	@RequestMapping("lookResume")
	public String lookResume(Model model,String uname) {
		User user = userService.findUserByName(uname);
		Resume resume = resumeService.findResumeByUid(user.getUid());
		model.addAttribute("resume", resume);
		return "showUserResume";
	}
}
