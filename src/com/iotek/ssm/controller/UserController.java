package com.iotek.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.ssm.entity.User;
import com.iotek.ssm.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getName")
	@ResponseBody
	public String getUname(String uname) {
		User user = userService.findUserByName(uname);
		if(user!=null) {
			return "1";
		}else {
			return "0";
		}
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		userService.addUser(user);
		return "registerSuccess";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session,String uname,String password,Model model) {
		User user = userService.findUserByNameAndPsd(uname, password);
		if(user==null) {
			model.addAttribute("error", "用户名或密码不正确");
			return "forward:/login.jsp";
		}else {
			session.setAttribute("user", user);
			return "loginSuccess";
		}
	}
	
	@RequestMapping("view")
	public String view(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user.getType()==0) {
			return "user_index";
		}
		if(user.getType()==1) {
			return "admin_index";
		}
		if(user.getType()==2) {
			return "employee_index";
		}
		return "manager_index";
	}
	
	@RequestMapping("changePwd")
	public String changePwd() {
		return "changePassword";
	}
	
	@RequestMapping("updatePwd")
	public String updatePwd(HttpSession session,String password) {
		User user = (User) session.getAttribute("user");
		user.setPassword(password);
		userService.updateUser(user);
		return "redirect:/login.jsp";
	}
	
}
