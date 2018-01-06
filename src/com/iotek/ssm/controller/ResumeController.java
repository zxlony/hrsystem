package com.iotek.ssm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Apply;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Recruit;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.ApplyService;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.RecruitService;
import com.iotek.ssm.service.ResumeService;
import com.iotek.ssm.service.UserService;

@RequestMapping("resume")
@Controller
public class ResumeController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private UserService userService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private RecruitService recruitService;
	
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
	
	/**
	 * 添加简历，如果应聘的职位不存在，则给出提示，若存在，同时生成应聘信息表
	 */
	@RequestMapping("insertResume")
	public String insertResume(Resume resume,String post,Model model) {
		String jobApplied1 = resume.getJobApplied()+" "+post;
		List<Recruit> allRecruit = recruitService.findAllRecruit();
		for (Recruit recruit : allRecruit) {
			if(jobApplied1.equals(recruit.getJob())) {
				resume.setJobApplied(jobApplied1);
				User user = userService.findUserById(resume.getUid());
				Apply apply = new Apply(-1, user.getUname(), new Date(), "未查看", "未面试", null, 0);
				applyService.addApply(apply);
				resumeService.addResume(resume);
				return "user_index";
			}
		}
		model.addAttribute("error", "您应聘的职位不存在");
		return "showMyResume";
	}
	
	/**
	 * 更新简历，如果应聘的职位不存在，给出提示，如果存在，则判断应聘职位有没有修改，若修改，则生成应聘信息表
	 * @param resume
	 * @param post
	 * @return
	 */
	@RequestMapping("updateResume")
	public String updateResume(Resume resume,String post,Model model) {
		String jobApplied1 = resume.getJobApplied()+" "+post;
		Resume resume1 = resumeService.findResumeByUid(resume.getUid());
		if(jobApplied1.equals(resume1.getJobApplied())) {
			resumeService.updateResume(resume);
			return "user_index";
		}else {
			List<Recruit> allRecruit = recruitService.findAllRecruit();
			for (Recruit recruit : allRecruit) {
				if(jobApplied1.equals(recruit.getJob())) {
					resume.setJobApplied(jobApplied1);
					User user = userService.findUserById(resume.getUid());
					Apply apply = new Apply(-1, user.getUname(), new Date(), "未查看", "未面试", null, 0);
					applyService.addApply(apply);
					resumeService.addResume(resume);
					return "user_index";
				}
			}
			model.addAttribute("error", "您应聘的职位不存在");
			return "showMyResume";
		}
	}
}
