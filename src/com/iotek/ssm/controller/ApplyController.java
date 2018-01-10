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
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.entity.Msg;
import com.iotek.ssm.entity.Post;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.ApplyService;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.EmpService;
import com.iotek.ssm.service.MsgService;
import com.iotek.ssm.service.PostService;
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
	@Autowired
	private PostService postService;
	@Autowired
	private EmpService empService;
	
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
		apply.setCheckStatus("�Ѳ鿴");
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
		apply.setInterviewStatus("��ʱ����");
		apply.setInterviewTime(interviewTime);
		applyService.updateApply(apply);
		User user = userService.findUserByName(apply.getUname());
		Msg msg = new Msg(-1, user.getUid(), "����һ������֪ͨ�������� ���� �в鿴");
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
	/**
	 * �ο�ȷ������
	 */
	@RequestMapping("interview")
	public String interview(int aid) {
		Apply apply = applyService.findApplyByAid(aid);
		apply.setInterviewStatus("ȷ������");
		applyService.updateApply(apply);
		Dept dept = deptService.findDeptByDid(apply.getDid());
		Msg msg = new Msg(-1, dept.getUid(), "������ӦƸ�ߣ���ע��ǰȥ����");
		msgService.addMsg(msg);
		return "user_index";
	}
	
	@RequestMapping("mgrLookUserApply")
	public String mgrLookUserApply(Model model,int uid) {
		Dept dept = deptService.findDeptByUid(uid);
		List<Apply> applies = applyService.findApplyByDidAndInterviewStatus(dept.getDid());
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
		return "showUserResume_mgr";
	}
	
	/**
	 * ¼�ã��ο�-->Ա����
	 * 1.�οͱ��Ա����2.����Ա����Ϣ��3.�޸�ӦƸ��Ϣ��4.ɾ����Ϣ��msg������
	 */
	@RequestMapping("hire")
	public String hire(int uid1,int uid2) {
		//���οͱ��Ա��
		User user = userService.findUserById(uid1);
		user.setType(2);
		userService.updateUser(user);
		//���Ա����Ϣ
		Resume resume = resumeService.findResumeByUid(uid1);
		String[] split = resume.getJobApplied().split(" ");
		String dname = split[0];
		String pname = split[1];
		Post post = postService.findPostByName(pname, dname);
		Employee emp = new Employee(-1, resume.getUid(), post.getPid(), resume.getName(), 
				resume.getSex(), resume.getAge(), resume.getEducation(), resume.getPhone(), 
				resume.getEmail(), resume.getJobApplied(), resume.getStatus(), new Date(), 
				resume.getHobby(), 0);
		empService.addEmployee(emp);
		//����ӦƸ��Ϣ
		Apply apply = applyService.findApplyByUname(user.getUname());
		apply.setInterviewStatus("������");
		apply.setHiring(1);
		applyService.updateApply(apply);
		//ɾ��һ����Ϣ����
		List<Msg> msgs = msgService.findMsgByUid(uid2);
		for (Msg msg : msgs) {
			if(msg.getMsg().equals("������ӦƸ�ߣ���ע��ǰȥ����")) {
				msgService.delMsg(msg.getMid());
				return "manager_index";
			}
		}
		return "manager_index";
	}
	
	@RequestMapping("noHire")
	public String noHire(int uid1,int uid2) {
		User user = userService.findUserById(uid1);
		Apply apply = applyService.findApplyByUname(user.getUname());
		apply.setInterviewStatus("������");
		applyService.updateApply(apply);
		List<Msg> msgs = msgService.findMsgByUid(uid2);
		for (Msg msg : msgs) {
			if(msg.getMsg().equals("������ӦƸ�ߣ���ע��ǰȥ����")) {
				msgService.delMsg(msg.getMid());
				return "manager_index";
			}
		}
		return "manager_index";
	}
	
}
