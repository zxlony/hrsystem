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

import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.entity.Msg;
import com.iotek.ssm.entity.Train;
import com.iotek.ssm.service.DeptService;
import com.iotek.ssm.service.MsgService;
import com.iotek.ssm.service.TrainService;

@RequestMapping("train")
@Controller
public class TrainController {

	@Autowired
	private TrainService trainService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private MsgService msgService;

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping("add")
	public String add(Model model) {
		List<Dept> depts = deptService.findAllDept();
		model.addAttribute("depts", depts);
		return "addTrain";
	}

	@RequestMapping("lookTrain")
	public String lookTrain(Model model) {
		List<Train> trains = trainService.findTrainAll();
		model.addAttribute("trains", trains);
		return "showAllTrain";
	}

	@RequestMapping("delTrain")
	public String delTrain(int tid) {
		trainService.delTrain(tid);
		return "redirect:/train/lookTrain";
	}

	@RequestMapping("updateTrain")
	public String updateTrain(int tid, Model model) {
		Train train = trainService.findTrainByTid(tid);
		model.addAttribute("train", train);
		return "forward:/train/add";
	}

	@RequestMapping("insert")
	public String insert(Train train, int did) {
		Dept dept = deptService.findDeptByDid(did);
		train.setDept(dept);
		trainService.addTrain(train);
		Msg msg = new Msg(-1, train.getDept().getUid(), "部门有相关培训通知，请注意查收");
		msgService.addMsg(msg);
		return "admin_index";
	}
	
	@RequestMapping("update")
	public String update(Train train,int did) {
		Dept dept = deptService.findDeptByDid(did);
		train.setDept(dept);
		Train oldTrain = trainService.findTrainByTid(train.getTid());
		if(oldTrain.getDept().getDid()!=did) {
			Msg msg = new Msg(-1, train.getDept().getUid(), "部门有相关培训通知，请注意查收");
			msgService.addMsg(msg);
		}
		trainService.updateTrain(train);
		return "admin_index";
	}
	
	/**
	 * 经理查看培训通知，删除培训消息提醒
	 */
	@RequestMapping("trainNotice")
	public String trainNotice(int uid,Model model) {
		Dept dept = deptService.findDeptByUid(uid);
		List<Train> trains = trainService.findTrainByDid(dept.getDid());
		List<Msg> msgs = msgService.findMsgByUid(uid);
		for (Msg msg : msgs) {
			if(msg.getMsg().equals("部门有相关培训通知，请注意查收")) {
				msgService.delMsg(msg.getMid());
			}
		}
		model.addAttribute("trains", trains);
		return "showMgrTrain";
	}

}
