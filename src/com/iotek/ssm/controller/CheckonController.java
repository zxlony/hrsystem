package com.iotek.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.Checkon;
import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.CheckonService;

@RequestMapping("checkon")
@Controller
public class CheckonController {
	
	@Autowired
	private CheckonService checkonService;
	
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
}
