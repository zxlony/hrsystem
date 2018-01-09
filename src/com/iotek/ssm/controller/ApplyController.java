package com.iotek.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Apply;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Msg;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.ApplyService;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.MsgService;
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
	@Autowired
	private MsgService msgService;
	@Autowired
	private DeptService deptService;
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@RequestMapping("lookApply")
	public String lookApply(Model model) {
		List<Apply> applies = applyService.findAllApply();
		model.addAttribute("applies", applies);
		return "showAllApplies";
	}
	
	@RequestMapping("lookResume")
	public String lookResume(Model model,String uname,int aid) {
		User user = userService.findUserByName(uname);
		Resume resume = resumeService.findResumeByUid(user.getUid());
		Apply apply = applyService.findApplyByAid(aid);
		apply.setCheckStatus("已查看");
		applyService.updateApply(apply);
		model.addAttribute("resume", resume);
		model.addAttribute("apply", apply);
		return "showUserResume";
	}
	
	@RequestMapping("delApply")
	public String delApply(int aid,Model model) {
		applyService.delApply(aid);
		return "forward:/apply/lookApply";
	}
	
	@RequestMapping("updateApply")
	public String updateApply(int aid,Date interviewTime) {
		Apply apply = applyService.findApplyByAid(aid);
		apply.setInterviewStatus("按时面试");
		apply.setInterviewTime(interviewTime);
		applyService.updateApply(apply);
		User user = userService.findUserByName(apply.getUname());
		Msg msg = new Msg(-1, user.getUid(), "您有一份面试通知，详情在 反馈 中查看");
		msgService.addMsg(msg);
		return "admin_index";
	}
	
	@RequestMapping("lookMyApply")
	public String lookMyApply(String uname, Model model) {
		User user = userService.findUserByName(uname);
		List<Msg> msgs = msgService.findMsgByUid(user.getUid());
		for (Msg msg : msgs) {
			msgService.delMsg(msg.getMid());
		}
		Apply apply = applyService.findApplyByUnameAndInterviewStatus(uname);
		model.addAttribute("apply", apply);
		return "showMyApply";
	}
	
	@RequestMapping("interview")
	public String interview(int aid) {
		Apply apply = applyService.findApplyByAid(aid);
		apply.setInterviewStatus("确认面试");
		applyService.updateApply(apply);
		User user = userService.findUserByName(apply.getUname());
		Resume resume = resumeService.findResumeByUid(user.getUid());
		String dname = resume.getJobApplied().split(" ")[0];
		Dept dept = deptService.findDeptByDname(dname);
		Msg msg = new Msg(-1, dept.getUid(), "部门有应聘者，请注意前去面试");
		msgService.addMsg(msg);
		return "user_index";
	}
	
	@RequestMapping("mgrLookUserApply")
	public String mgrLookUserApply(Model model) {
		List<Apply> applies = applyService.findApplyByInterviewStatus();
		model.addAttribute("applies", applies);
		return "showUserApply";
		
	}
	
	@RequestMapping("mgrInterview")
	public String mgrInterview(Model model,String uname,int aid,int uid) {
		User user = userService.findUserByName(uname);
		Resume resume = resumeService.findResumeByUid(user.getUid());
		Apply apply = applyService.findApplyByAid(aid);
		model.addAttribute("resume", resume);
		model.addAttribute("apply", apply);
		List<Msg> msgs = msgService.findMsgByUid(uid);
		for (Msg msg : msgs) {
			if(msg.getMsg().equals("部门有应聘者，请注意前去面试")) {
				msgService.delMsg(msg.getMid());
				return "showUserResume_mgr";
			}
		}
		return "showUserResume_mgr";
	}
	
}
