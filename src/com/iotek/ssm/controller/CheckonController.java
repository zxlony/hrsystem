package com.iotek.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.Checkon;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.CheckonService;
import com.iotek.ssm.service.EmpService;

@RequestMapping("checkon")
@Controller
public class CheckonController {
	
	@Autowired
	private CheckonService checkonService;
	@Autowired
	private EmpService empService;
	
	@RequestMapping("check")
	@ResponseBody
	public String check(HttpSession session) {
		User user = (User) session.getAttribute("user");
		String clockDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Checkon checkon = checkonService.findByUidAndClock(user.getUid(), clockDate);
		if(checkon==null) {
			return "0";
		}
		if(checkon.getEndTime()==null) {
			return "1";
		}
		return "2";
	}
	
	@RequestMapping("insertCheck")
	public String insertCheck(int uid) {
		String clockDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Checkon checkon = checkonService.findByUidAndClock(uid, clockDate);
		if(checkon!=null) {
			return "employee_index";
		}
		Employee emp = empService.findEmpByUid(uid);
		Checkon checkon1 = new Checkon(-1, uid, emp.getEname(), clockDate, new Date(), null, "矿工");
		checkonService.addCheckon(checkon1);
		return "employee_index";
	}
	
	@RequestMapping("updateCheck")
	public String updateCheck(int uid) {
		String clockDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Checkon checkon = checkonService.findByUidAndClock(uid, clockDate);
		if(checkon==null) {
			return "employee_index";
		}
		Date start = checkon.getStartTime();
		Date end = new Date();
		checkon.setEndTime(end);
		long time1 = start.getTime()%86400000-3600000*9;
		long time2 = 3600000*16-end.getTime()%86400000;
		if(time1<=0&&time2<=0) {
			checkon.setStatus("出勤正常");
		}else if(time1>0&&time1<=3600000*3&&time2<=0) {
			checkon.setStatus("迟到");
		}else if(time1<=0&&time2>0&&time2<=3600000*3) {
			checkon.setStatus("早退");
		}else if((time1>0&&time1<=3600000*3)&&(time2>0&&time2<=3600000*3)) {
			checkon.setStatus("迟到且早退");
		}
		checkonService.updateCheckon(checkon);
		return "employee_index";
	}
	
	@RequestMapping("lookMyCheck")
	public String lookMyCheck(int uid,String year,String month,Model model) {
		String clockMonth = null;
		if(year==null||month==null) {
			clockMonth = "2018-01";
		}else {
			clockMonth = year+"-"+month;
		}
		List<Checkon> checkons = checkonService.findCheckonByUid(uid, clockMonth);
		int absence = 21;
		if(checkons!=null) {
			absence = 21-checkons.size();
		}
		model.addAttribute("checkons", checkons);
		model.addAttribute("absence", absence);
		return "showMyCheckon";
	}
}
